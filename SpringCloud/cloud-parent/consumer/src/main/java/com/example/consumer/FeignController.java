package com.example.consumer;

import com.example.consumer.proxy.ProviderProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FeignController {

    @Autowired
    private ProviderProxy providerProxy;

    @GetMapping("testFeign")
    public String testFeign(){
        String s = providerProxy.testProvider();
        return s;
    }

    @GetMapping("testFeign2")
    public String testFeign2() throws Exception {
        String s = providerProxy.testProvider2();
        return s;
    }

    @GetMapping("testFeign3")
    public String testFeign3(Integer name) throws Exception {
        String s = providerProxy.testProvider3(name);
        return s;
    }

//    @GetMapping("testFeign4")
//    public UserVo testFeign4() throws Exception {
//        UserVo userVo = new UserVo();
//        userVo.setId(1);
//        userVo.setName("张三");
//        UserVo userVo1 = providerProxy.testProviderPost(userVo);
//        return userVo1;
//    }
}
