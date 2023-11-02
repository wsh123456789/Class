package com.wsh.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Component//指定类的注解
//@Controller//只在controller层下面的类上打上注解
//@Service
public class Student {

//	@Value("1")
	private Integer id;
	
//	@Value("张三")
	private String name;

	public Student(){
		
	}
	
	public Student(Integer id, String name){
		this.id = id;
		this.name = name;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}

}
