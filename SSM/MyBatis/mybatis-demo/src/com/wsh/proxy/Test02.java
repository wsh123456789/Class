package com.wsh.proxy;

public class Test02 {
	public static void main(String[] args) {
		Stra stra = new BigStar("坤坤");
		
		Stra straProxy = StraProxyUtil.createKkProxy(stra);
		
		String s1 = straProxy.sing("姬霓太美");
		System.out.println(s1);
		String s2 = straProxy.dance("极乐尽土");
		System.out.println(s2);
		straProxy.play("篮球");
	}
}
