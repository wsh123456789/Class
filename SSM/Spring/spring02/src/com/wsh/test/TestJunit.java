package com.wsh.test;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wsh.bean.Student;
import com.wsh.service.StudentService;

@ContextConfiguration("classpath:ioc.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestJunit {
	
	/*
	@Autowired 是由spring框架提供 注解默认按照类型进行装配
	@Resource 是由J2EE提供 注解默认按照名称进行装配
	*/
	
	
	@Autowired//依赖注入
	Student student;
	
	@Autowired
//	@Resource
	private StudentService ss;
	
	@Test
	@Ignore
	public void test() {
		System.out.println("asdasd");
	}
	
	@Test
	public void test2() {
		student.setId(2);
		student.setName("Angus");
		System.out.println(student);
		System.out.println(student.hashCode());
	}
	
	@Test
	public void test3() {
		System.out.println("---------------" + student.getId());
	}

}
