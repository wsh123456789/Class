package com.example.kafkaconsumer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@RequestMapping
public class KafkaConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaConsumerApplication.class, args);
    }

    //logf4j
    private final static Logger logger = LoggerFactory.getLogger(KafkaConsumerApplication.class);

    @RequestMapping("/index")
    public String index(){
        return "hello,kafka";
    }

    //整合kafka需要声明两个变量
    @Autowired
    private KafkaTemplate kafkaTemplate;
    @Autowired
    private static final String topic = "wzy";

    //消息生产
    @GetMapping("/send/{input}")
    public String sendToKafka(String input){
        this.kafkaTemplate.send(topic,input);
        //事务的支持
        kafkaTemplate.executeInTransaction(t->{
            t.send(topic,input);
            return true;
        });

        return "发送成功";
    }
    //消息接收
    @KafkaListener(id = "",topics = topic,groupId = "group.demo")
    public void Listener(@PathVariable String input){
        logger.info("message input value:{}",input);
    }

    //事务第二种方式,注解开启事务
    //消息生产
    @GetMapping("/send2/{input}")
    @Transactional(rollbackFor = RuntimeException.class)
    public String sendToKafkaTransactional(String input){
        //事务的支持
        kafkaTemplate.send(topic,input);
        kafkaTemplate.send(topic,"222");
        return "发送成功";
    }

}
