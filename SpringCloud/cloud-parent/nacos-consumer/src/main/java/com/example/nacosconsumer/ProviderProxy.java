package com.example.nacosconsumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "nacos-provider")
public interface ProviderProxy {

    @GetMapping("testProvider")
    public String testProvider();
}
