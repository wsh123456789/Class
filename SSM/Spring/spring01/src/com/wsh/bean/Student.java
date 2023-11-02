package com.wsh.bean;

import java.util.List;

public class Student {
	private Integer id;
	private String name;
	private List<Book> bookList;
	
	public Student() {
		
	}
	public Student(Integer id, String name) {
		super();
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
	
	public List<Book> getBookList() {
		return bookList;
	}
	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", bookList=" + bookList + "]";
	}
	
	
}
