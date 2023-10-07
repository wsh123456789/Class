package com.ah.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ah.bean.User;
import com.ah.service.UserService;
import com.ah.service.UserServiceImpl;
@WebServlet("/addUser")
public class AddUserServlet extends HttpServlet{
	UserService userService=new UserServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		req.setCharacterEncoding("UTF-8");

		String username=req.getParameter("username");
		String password=req.getParameter("password");
		int age=Integer.valueOf(req.getParameter("age"));
		String sex=req.getParameter("sex");

		boolean flag=userService.getUserByUsername(username);
		
		PrintWriter out = resp.getWriter();
	    if(flag){
	    	out.print("<script>alert('用户名或密码错误！！！');" +
                    "window.location='/MyServlet/queryUserPage?page=1'</script>");
	    }else{
	    	User user=new User();
	    	user.setAge(age);
	    	user.setPassword(password);
	    	user.setSex(sex);
	    	user.setUsername(username);
	    	int line = userService.addUser(user);
	    	if(line>0){
	    		//3.如果添加成功，跳转页面
	            out.print("<script>alert('添加成功！！！');" +
	                    "window.location='/MyServlet/queryUserPage?page=1'</script>");
	    	}else{
	    		 //4.如果已存在提示 添加失败
	            out.print("<script>alert('用户名已存在！！！');" +
	                    "window.location='/MyServlet/queryUserPage?page=1'</script>");
	    	}
	    }
	    
        out.flush();
        out.close();
	}
	
}
