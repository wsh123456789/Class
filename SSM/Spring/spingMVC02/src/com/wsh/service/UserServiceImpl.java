package com.wsh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wsh.bean.User;
import com.wsh.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User getUserByNameAndPs(String username, String password) {
		
		System.out.println("我到了service层了"+username+","+password);
		return userMapper.getUserByNameAndPs(username,password);
		
	}
	
}
