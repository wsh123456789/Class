package com.wsh.purchaser.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component//Component 把当前对象交给容器管理
public class Config {
    @Bean//把这个方法交给spring容器管理
    public RestTemplate RestTemplate(){
        return new RestTemplate();
    }
}
