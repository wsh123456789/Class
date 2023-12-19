package com.example.nacosconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {
    @Autowired
    private ProviderProxy providerProxy;

    @GetMapping("testConsumer")
    public String testConsumer(){
        return providerProxy.testProvider();
    }
}
