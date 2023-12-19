package com.wsh;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @GetMapping("xiadan")
    public String xiadan(){
        OrderVo orderVo = new OrderVo();
        orderVo.setId(1);
        orderVo.setCode("AAA");
        orderVo.setCount(100);
        amqpTemplate.convertAndSend("key001","hello===这是下单信息");
        amqpTemplate.convertAndSend("key001",orderVo);
        return "下单";
    }
}
