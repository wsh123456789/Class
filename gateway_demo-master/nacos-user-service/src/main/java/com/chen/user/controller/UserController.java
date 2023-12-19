package com.chen.user.controller;

import com.chen.user.entiy.User;
import com.chen.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/query")
    public List<User> query(@RequestHeader(value = "Truth",required = false) String header) {
        System.out.println("请求头为："+"Truth:"+header);
        return userService.queryUsrInfo();
    }
    @GetMapping("{id}")
    public List<User> queryById(@PathVariable("id")Integer id) {
        return userService.queryUsrInfoById(id);
    }
}
