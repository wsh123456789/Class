package com.wsh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.wsh.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService ss;
	
}
