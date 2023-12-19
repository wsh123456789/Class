package com.chen.user.service;

import com.chen.user.entiy.User;
import com.chen.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {


    List<User> queryUsrInfo();

    List<User> queryUsrInfoById(int id);
}
