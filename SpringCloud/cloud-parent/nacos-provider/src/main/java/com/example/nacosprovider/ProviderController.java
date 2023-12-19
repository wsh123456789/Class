package com.example.nacosprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProviderController {
    @Autowired
    private ProviderMapper providerMapper;

    @GetMapping("testProvider")
    public String testProvider(){
        return "hello provider!!!===8084";
    }

    @GetMapping("testProvider2")
    public List<UserVo> testProvider2(){
        return providerMapper.queryUser();
    }

}
