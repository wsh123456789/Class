package com.chen.order;


import com.chen.order.entiy.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "userService",path = "user")
public interface UserProxy {
    @GetMapping("{id}")
    List<User> query(@PathVariable("id") Integer id);
}
