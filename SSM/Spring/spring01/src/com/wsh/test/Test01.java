package com.wsh.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wsh.bean.Book;
import com.wsh.bean.Student;

public class Test01 {
	public static void main(String[] args) {
		
		// 构造函数注入创建stu对象
		ClassPathXmlApplicationContext cp = new ClassPathXmlApplicationContext("ioc.xml");
		Student stu1 = cp.getBean("student", Student.class);
		System.out.println(stu1);
		// set注入创建book对象
		List<Book> bookList = new ArrayList<>();
		Book book1 = cp.getBean("book1",Book.class);
		Book book2 = cp.getBean("book2",Book.class);
		Book book3 = cp.getBean("book3",Book.class);
		bookList.add(book1);
		bookList.add(book2);
		bookList.add(book3);
		stu1.setBookList(bookList);
		System.out.println(stu1);
		// set注入创建stu2对象，并将book列表写入
		Student stu2 = cp.getBean("student2",Student.class);
		System.out.println(stu2);
	}
}
