package com.wsh.bean;

public class User {

	private Integer id;

	private String username;

	private String password;

	private Integer age;

	private String sex;

	private Integer trueName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	
	public Integer getTrueName() {
		return trueName;
	}

	public void setTrueName(Integer trueName) {
		this.trueName = trueName;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", age=" + age + ", sex=" + sex
				+ ", trueName=" + trueName + "]";
	}

	
}
