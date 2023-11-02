package com.wsh.bean;

public class Wife {

	private String name;
	
	private Husband husband;
	
	

	public Wife(String name, Husband husband) {
		super();
		this.name = name;
		this.husband = husband;
	}



	public String getName() {
		return name;
	}



	@Override
	public String toString() {
		return "Wife [name=" + name + ", husband=" + husband+ "]";
	}
	
	
}
