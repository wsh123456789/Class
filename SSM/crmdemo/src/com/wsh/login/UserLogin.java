package com.wsh.login;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import com.wsh.bean.PermissionVo;
import com.wsh.bean.UserInfo;
import com.wsh.service.UserService;

@Controller
@RequestMapping("/user")
public class UserLogin {
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping("/login")
	public String login(String userName, String userPw, HttpSession session,HttpServletRequest req){
		boolean flag = userService.loginByUsernameAndPw(userName,userPw);
		List<PermissionVo> pv = userService.getPermission(userName);
		UserInfo user = userService.getUserByUserName(userName);
		List<String> nameList = userService.queryPermissionInterfaceByUserName(userName);
		user.setNameList(nameList);
		if(flag) {
			session = req.getSession();
			session.setAttribute("flag", flag);
			session.setAttribute("user",user);
			session.setAttribute("permission",pv);
			return "frame/main";		
		}else {
			return "login";
		}
		
	}
}
