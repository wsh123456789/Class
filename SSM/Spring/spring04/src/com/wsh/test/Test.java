package com.wsh.test;

import static org.junit.Assert.*;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wsh.bean.Husband;
import com.wsh.bean.Wife;

public class Test {

	@org.junit.Test
	public void test() {
		ClassPathXmlApplicationContext cc = new ClassPathXmlApplicationContext("ioc.xml");
		Husband husband = cc.getBean("husbandBean",Husband.class);
		Wife wife = cc.getBean("wifeBean",Wife.class);
		System.out.println(husband);
		System.out.println(wife);
	}

}
