package com.example.provider;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {
    @GetMapping("testProvider")
    public String testProvider(){
        return "hello provider!!!===7011";
    }

    @PostMapping("testProviderPost")
    public UserVo testProviderPost(@RequestBody UserVo userVo) throws InterruptedException {
//        Thread.sleep(1100);
        userVo.setName("hello provider!!!===7010");
        return userVo;
    }

    @GetMapping("testProvider2")
    public String testProvider2()throws Exception{
//        Thread.sleep(1100);
//        throw new Exception();
//        return "hello provider!!!===7011===2";
        return "hello provider";
    }

    @GetMapping("testProvider3")
    public String testProvider3(Integer name)throws Exception{
//        Thread.sleep(1100);
//        throw new Exception();
        return "hello provider!!!===7011===feign" + name;
//        return "hello provider";
    }
}
