package com.wsh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wsh.bean.User;
import com.wsh.service.UserService;

@Controller
@RequestMapping("/user")
public class TestControllerDemo {

	@RequestMapping("/login")
	public String login() {
		System.out.println("HelloWorld");
		return "login";
	}
	
	@RequestMapping("/login2")
	public String login2(String username, String password) {
		System.out.println("获取参数，用户名：" + username + "; 密码：" + password);
		return "login";
	}
	
	@RequestMapping("/login3")
	public String login3(@RequestParam("name")String username, @RequestParam("pw")String password) {
		System.out.println("获取参数，用户名：" + username + "; 密码：" + password);
		return "login";
	}
	
	@RequestMapping("/addUser")
	public String addUser(User user) {
		System.out.println("获取参数，" + user);
		return "login";
	}
	
	@RequestMapping("/deleteUser")
	@ResponseBody
	public List<Integer> deleteUser(@RequestBody List<Integer> ids) {
		System.out.println("获取参数，" + ids);
		return ids;
	}
	
	@RequestMapping("/getUser")
	public String getUser(String name,Model model) {
		System.out.println("获取参数，" + name);
		model.addAttribute("name", name);
		return "login";
	}
	@Autowired
	private UserService userService;
	
	@RequestMapping("/getUser2")
	public String getUser2(String name,Model model) {
		System.out.println("获取参数，" + name);
		userService.eat(name);
		model.addAttribute("name", name);
		return "login";
	}
}
