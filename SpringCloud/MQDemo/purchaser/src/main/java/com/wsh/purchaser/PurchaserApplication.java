package com.wsh.purchaser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling//1.启用注解版定时器
public class PurchaserApplication {

    public static void main(String[] args) {
        SpringApplication.run(PurchaserApplication.class, args);
    }

}
