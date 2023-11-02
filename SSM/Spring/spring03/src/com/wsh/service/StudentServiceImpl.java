package com.wsh.service;

import com.wsh.dao.StudentDao;

public class StudentServiceImpl implements StudentService{

	private StudentDao stuDao;
	
	@Override
	public void eat() {
		System.out.println("吃饭");
		
	}

	public void setStuDao(StudentDao stuDao) {
		System.out.println("setStuDao................");
	}

	
}
