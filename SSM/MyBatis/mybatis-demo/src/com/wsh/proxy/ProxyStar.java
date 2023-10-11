package com.wsh.proxy;

//代理类
public class ProxyStar implements Stra{
	
	private Stra stra;
	
	public ProxyStar(Stra stra) {
		super();
		this.stra = stra;
	}

	@Override
	public String sing(String name) {
		System.out.println("准备话筒");
		String s1 = stra.sing(name);
		
		return s1;
	}

	@Override
	public String dance(String name) {
		System.out.println("准备背带裤");
		String s1 = stra.dance(name);
		
		return s1;
	}

	@Override
	public void play(String name) {
		System.out.println("准备篮球");
		stra.dance(name);
	}

}
