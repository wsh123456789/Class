package com.wsh;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MQUtil {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @RabbitListener(queuesToDeclare = @Queue(value = "key001",autoDelete = "true"))
    public void getMessage(OrderVo orderVo){
        System.out.println(orderVo.toString());

        amqpTemplate.convertAndSend("returnKey","响应信息");
    }
}
