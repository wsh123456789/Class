package com.example.mybatis_plus.user.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatis_plus.user.entity.User;
import com.example.mybatis_plus.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wsh
 * @since 2023-12-08
 */
@RestController
@RequestMapping("/user/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("queryUser")
    public List<User> queryUser(){
        List<User> list = userService.list(null);
        // 简单的（单表的）常用的；增删改查；分页
        // 查询： 条件查询， 批量查询， 模糊查询， 范围查询
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // 根据一个条件查询
        queryWrapper.eq("id",1);
        // 模糊查询
        queryWrapper.like("name","1");
        // 批量查询
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        queryWrapper.in("id",ids);
        List<User> list1 = userService.list(queryWrapper);
        System.out.println(list1);

        // 分页
        Page<User> objectPage = new Page<>(0,2);
        QueryWrapper<User> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.in("id",ids);
        IPage<User> page = userService.page(objectPage,queryWrapper1);
        System.out.println(page);

        // 新增 userService.save(对象或对象集合)
        // 根据id修改 userService.updateById(user)
        // 根据条件修改
//        QueryWrapper<User> queryWrapper2 = new QueryWrapper<>();
//        queryWrapper2.in("id",ids);
//        userService.update(user,queryWrapper2);
        // 删除
//        userService.remove(queryWrapper1);

        return list;
    }
}
