package com.wsh.purchaser.service.impl;

import com.wsh.model.AddVo;
import com.wsh.model.ParamUtil;
import com.wsh.purchaser.mapper.PurchaserMapper;
import com.wsh.purchaser.service.PurchaserService;
import com.wsh.purchaser.utils.ResultBuildVo;
import com.wsh.purchaser.utils.ResultVo;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.Map;

@Service
@Component
public class PurchaserServiceImpl implements PurchaserService {
    // 重试次数
    private int repeatCount = 0;
    // 状态
    private Integer mqStatus = 0;
    // 数据
    private AddVo addVo = null;
    // 下单时间
    private Date createTime;


    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    private PurchaserMapper purchaserMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultVo add(AddVo addVo) {
        // 查询订单是否已存在
        int orderCodeCount = purchaserMapper.queryOrderByCode(addVo);
        if (orderCodeCount != 0){
            return ResultBuildVo.error(ParamUtil.ORDER_REPEAT);
        }
        // 占用库存 查看库存是否存在
        Map<String,Integer> errorSpare = restTemplate.postForObject("http://localhost:5010/hasInventory",addVo, Map.class);
        System.out.println(errorSpare);
        if (!errorSpare.isEmpty()){
            return ResultBuildVo.error("备件库存不足，库存不足的备件编码和对应的库存为" + errorSpare.toString());
        }
        // 添加创建时间
        addVo.setCreateTime(new Date());
        this.createTime = addVo.getCreateTime();
        // 基础信息存入数据库
        purchaserMapper.add(addVo);
        // 数量存入采购备件表
        purchaserMapper.addCount(addVo);
        return ResultBuildVo.success();
    }

    @Override
    public ResultVo check(AddVo addVo) {
        // 查询订单是否过期(模拟)
        Date now = new Date();
        if (now.getTime() - createTime.getTime() > 24){
            return ResultBuildVo.error("订单已超时");
        }
        // 将订单改为审批状态和运行中
        purchaserMapper.check(addVo);
        this.addVo = addVo;
        return ResultBuildVo.success();
    }




    @Scheduled(cron = "0/5 * * * * ?")
    public void repeat(){
        System.out.println(mqStatus);
        // 模拟当前时间
        Date now = new Date();
        // 调用数据库查询是否为审批状态,判断是否创建订单时间大于5分钟，且访问次数小于五次，通过全局addVo的orderCode查询
        if (repeatCount < 5 && addVo != null){
            System.out.println(addVo);
            mqStatus = purchaserMapper.queryMQStatusByCodeAndStatus(addVo);
        }
        System.out.println("mqStatus" + mqStatus);
        if (repeatCount < 5 && mqStatus == 1 && (now.getTime() - createTime.getTime())/1000/60 >= 5){
                repeatCount++;
                System.out.println(addVo.toString());
                amqpTemplate.convertAndSend("repeatResponse",addVo);
                System.out.println(2222);
        }
    }

    @RabbitListener(queuesToDeclare = @Queue(value = "repeatResult",autoDelete = "true"))
    public void repeat(int status){
        if (status == 2){
            purchaserMapper.updateMQStatus(addVo.getOrderCode(),status);
            repeatCount = 0;
            mqStatus = 0;
        }
    }


}
