package com.wsh.purchaser.controller;

import com.wsh.model.AddVo;
import com.wsh.purchaser.service.PurchaserService;
import com.wsh.purchaser.utils.ResultBuildVo;
import com.wsh.purchaser.utils.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
public class PurchaserController {

    @Autowired
    private PurchaserService purchaserService;
    // 因为保存，修改是存到自己数据库就不详细写，提交包含了保存的功能，
    // 先看验证订单是否已存在，然后查询库存是否足够，如过足够，进行占用，并且存入采购方数据库
    // 因为是demo，并没有写备件表验证备件是否存在，提交后进行审核，审核只是改本库一个状态，忽略
    // 审批过后要传给rabbitMQ，MQ给供应商一个请求，返回状态进入运行中
    // 采购方会设置重试机制每隔五分钟就进行一次检验是否还在进行，五次之后还是进行中，那么进入失败状态，释放占用，人工介入

    // 提交订单
    @PostMapping("submit")
    public ResultVo add(@RequestBody @Valid AddVo addVo, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultBuildVo.error(bindingResult.getFieldError().getDefaultMessage());
        }
        System.out.println(addVo);
        return purchaserService.add(addVo);
    }

    // 审批
    // 因为审批要把数据传给供应商，这里就不去查数据库了，直接模拟数据传给供应商
    @PostMapping("check")
    public ResultVo check(@RequestBody AddVo addVo){
        return purchaserService.check(addVo);
    }

}
