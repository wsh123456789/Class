package com.wsh.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
  import com.wsh.service.TestService;


@ContextConfiguration("classpath:ioc.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestJunit {
	
	@Autowired
	private TestService testService;
	
	@Test
	public void text01() {
		testService.add(1, 2);
		testService.delete(3);
	}
	

}
