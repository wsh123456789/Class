package com.wsh.supplier.util;

import com.wsh.model.AddVo;
import com.wsh.supplier.service.SupplierService;
import org.springframework.amqp.core.Address;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MQUtil {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    private SupplierService supplierService;

    @RabbitListener(queuesToDeclare = @Queue(value = "repeatResponse",autoDelete = "true"))
    public void getMessage(AddVo addVo){
        supplierService.add(addVo);
        System.out.println(addVo);
        amqpTemplate.convertAndSend("repeatResult",2);
    }
}