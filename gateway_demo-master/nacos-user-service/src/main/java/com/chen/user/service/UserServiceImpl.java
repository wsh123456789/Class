package com.chen.user.service;

import com.chen.user.entiy.User;
import com.chen.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;


    @Override
    public List<User> queryUsrInfo() {
        return userMapper.queryUsrInfo();
    }

    @Override
    public List<User> queryUsrInfoById(int id) {
        return userMapper.queryUsrInfoById(id);
    }
}
