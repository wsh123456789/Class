package com.wsh.proxy;

public class BigStar implements Stra{
	private String name;
	

	public BigStar(String name) {
		super();
		this.name = name;
	}

	@Override
	public String sing(String name) {
		System.out.println(this.name + " 唱：" + name);

        return "小黑子";
	}

	@Override
	public String dance(String name) {
		 System.out.println(this.name + " 跳：" + name);

	     return "小黑子";
	}

	@Override
	public void play(String name) {
		System.out.println(this.name + " 打" + name);
		
	}

}
