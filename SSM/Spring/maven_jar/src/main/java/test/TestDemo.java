package test;

import org.springframework.stereotype.Controller;

@Controller
public class TestDemo {
	public static String print() {
		return "你好 Maven";
	}
	
	public static void main(String[] args) {
		System.out.println("你好 Maven");
	}
}
