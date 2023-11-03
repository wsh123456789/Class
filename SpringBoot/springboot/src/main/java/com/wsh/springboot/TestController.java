package com.wsh.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@Controller
//@ResponseBody
@RestController
public class TestController {

    @Autowired
    private TestMapper testMapper;

    @GetMapping("test")
    public List<UserVo> test(){
        List<UserVo> userVos = testMapper.queryAll();
        return userVos;
    }

}
