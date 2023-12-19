package com.example.zuul;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component//Component 把当前对象交给容器管理
@Configuration
public class Config {
//     选择负载均衡算法
    @Bean
    public IRule myFuZai(){
        return new MyFuZaiSuanFa();
//        return new BestAvailableRule();
    }
}
