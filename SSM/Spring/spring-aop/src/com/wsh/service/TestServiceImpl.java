package com.wsh.service;

import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService{
	
	@Override
	public void add(int a,int b) {
		System.out.println("我是添加方法 a: " + a + ", b: " + b );
	}
	
	@Override
	public void delete(int a) {
		System.out.println("我是删除方法 a: " + a);
	}
}
