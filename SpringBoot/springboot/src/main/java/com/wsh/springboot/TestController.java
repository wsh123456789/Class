package com.wsh.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    // @RequestBody 接受json格式的数据
    @PostMapping("postTest")
    public UserVo postTest(@RequestBody UserVo userVo){
        return userVo;
    }

    @PutMapping("putTest")
    public String update(){
        return "修改";
    }

    // restFull风格
    @GetMapping("/rest/{name}")
    public String testRest(@PathVariable("name") String name){
        return name;
    }

    @Value("${userinfo.name}")
    private String name;

    @GetMapping("getName")
    public String getName(){
        return  name;
    }

    @Value("${userinfo.age}")
    private String age;

    @GetMapping("getAge")
    public String getAge(){
        return  age;
    }

    @Autowired
    private GetProperties getProperties;

    @GetMapping("getNameAndAge")
    public String getNameAndAge(){
        return getProperties.getName() + getProperties.getAge();
    }

}
