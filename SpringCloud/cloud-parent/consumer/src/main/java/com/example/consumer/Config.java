package com.example.consumer;

import com.netflix.loadbalancer.BestAvailableRule;
import com.netflix.loadbalancer.IRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component//Component 把当前对象交给容器管理
public class Config {
    @Bean//把这个方法交给spring容器管理
    @LoadBalanced //开启负载均衡
    public RestTemplate restTemplate(){
        HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        httpComponentsClientHttpRequestFactory.setConnectionRequestTimeout(1000);
        httpComponentsClientHttpRequestFactory.setConnectTimeout(1000);
        httpComponentsClientHttpRequestFactory.setReadTimeout(1000);
        return new RestTemplate(httpComponentsClientHttpRequestFactory);
    }

//     选择负载均衡算法
    @Bean
    public IRule myFuZai(){
        return new MyFuZaiSuanFa();
//        return new BestAvailableRule();
    }
}
