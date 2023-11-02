package com.wsh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wsh.bean.User;
import com.wsh.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public String login(String username, String password) {
		System.out.println("获取前端结果" + username + ":" + password);
		User user = userService.getUserByNameAndPs(username, password);
		System.out.println(user);
		return "index";
	}
}
