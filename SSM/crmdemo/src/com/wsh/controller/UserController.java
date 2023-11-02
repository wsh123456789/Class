package com.wsh.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wsh.bean.PermissionVo;
import com.wsh.bean.Role;
import com.wsh.bean.UserInfo;
import com.wsh.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping("/register")
	public String register(UserInfo userInfo) {
		Integer line = userService.registerUser(userInfo);
		if(line == 0) {
			return "register";
		}else {
			return "login";
		}
		
		
	}
	
	
	// 角色分配回显
	@RequestMapping("/queryRole")
	public String queryRole(Model model){
		List<Role> role = userService.queryRoleAll();
		List<UserInfo> user = userService.getUserAll();
		model.addAttribute("role",role);
		model.addAttribute("user",user);
		return "frame/userRole";
	}
	
	// 角色分配修改
	@RequestMapping("/distributerole")
	public String distributerole(Integer userId,@RequestParam List<Integer> roleId,Model model){
		Integer line = userService.distributerole(userId,roleId);
		return "redirect:/user/queryRole";
	}
	
	// 权限分配回显
	@RequestMapping("/queryPermission")
	public String queryPermission(Model model){
		List<PermissionVo> permissionList = userService.queryPermission();
		List<Role> roleList = userService.queryRoleAll();
		model.addAttribute("roleList",roleList);
		model.addAttribute("permissionList",permissionList);
		return "frame/distributePermission";
	}
	
	// 	权限分配修改
	@RequestMapping("/authorityOfDistribution")
	public String authorityOfDistribution(Integer roleId,@RequestParam List<Integer> permissionId,Model model){
		Integer line = userService.authorityOfDistribution(roleId,permissionId);
		return "redirect:/user/queryPermission";
	}
	
}
