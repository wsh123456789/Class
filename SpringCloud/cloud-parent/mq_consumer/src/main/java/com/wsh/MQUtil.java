package com.wsh;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MQUtil {

    @RabbitListener(queuesToDeclare = @Queue(value = "returnKey",autoDelete = "true"))
    public void getMessage(String message){
        System.out.println(message);
    }
}
