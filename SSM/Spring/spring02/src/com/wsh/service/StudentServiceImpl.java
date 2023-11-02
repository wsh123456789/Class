package com.wsh.service;

import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{

	@Override
	public void eat() {
		System.out.println("我正在吃饭");
	}
	
}
