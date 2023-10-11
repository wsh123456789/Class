package com.wsh.proxy;

import java.lang.reflect.Proxy;

public class Test01 {
	public static void main(String[] args) {
		//委托类
		Stra stra = new BigStar("坤坤");
		
		ProxyStar proxyStar = new ProxyStar(stra);
		
		String s1 = proxyStar.sing("及你太美");
		System.out.println(s1);
		String s2 = proxyStar.dance("极乐世界");
		System.out.println(s2);
		proxyStar.play("篮球");
	}
}
