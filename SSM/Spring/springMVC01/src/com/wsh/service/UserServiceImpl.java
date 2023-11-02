package com.wsh.service;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

	@Override
	public void eat(String name) {
		
		System.out.println(name + "正在吃东西");
		
	}

}