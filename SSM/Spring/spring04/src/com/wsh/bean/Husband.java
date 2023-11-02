package com.wsh.bean;

public class Husband {

	private String name;
	
	private Wife wife;
	
	

	public Husband(String name, Wife wife) {
		super();
		this.name = name;
		this.wife = wife;
	}


	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Husband [name=" + name + ", wife=" + wife + "]";
	}
	
	
}
