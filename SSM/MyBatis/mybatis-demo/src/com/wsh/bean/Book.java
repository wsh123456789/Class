package com.wsh.bean;

public class Book {
	private Integer id;

	private String bookName;

	private Double price;

	private Integer studentId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", bookName=" + bookName + ", price=" + price + ", studentId=" + studentId + "]";
	}

	

}
