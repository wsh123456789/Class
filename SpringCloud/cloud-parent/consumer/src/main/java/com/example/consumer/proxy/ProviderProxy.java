package com.example.consumer.proxy;

import com.example.consumer.UserVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "provider")
public interface ProviderProxy {

    @GetMapping("testProvider")
    public String testProvider();

    @GetMapping("testProvider2")
    public String testProvider2()throws Exception;

    @GetMapping("testProvider3")
    public String testProvider3(@RequestParam("name") Integer name)throws Exception;

    @PostMapping("testProviderPost")
    public UserVo testProviderPost(@RequestBody UserVo userVo) throws InterruptedException;
}
