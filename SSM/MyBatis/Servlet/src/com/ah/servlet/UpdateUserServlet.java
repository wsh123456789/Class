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
@WebServlet("/updateUser")
public class UpdateUserServlet extends HttpServlet{
     UserService userService=new UserServiceImpl();
     @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	resp.setCharacterEncoding("UTF-8");
 		resp.setContentType("text/html; charset=UTF-8");
 		req.setCharacterEncoding("UTF-8");
 
 		int id=Integer.valueOf(req.getParameter("id"));
 		String username=req.getParameter("username");
 		boolean flag = userService.getUserByNameAndId(id,username);
 		
 		PrintWriter out = resp.getWriter();
 	    if(flag){
 	    	 out.print("<script>alert('修改失败！！！');" +
	                    "window.location='/MyServlet/queryUserPage?page=1'</script>");
 	    }else{
 	    	String password=req.getParameter("password");
 	    	int age=Integer.valueOf(req.getParameter("age"));
 	    	String sex=req.getParameter("sex");
 	    	User user=new User();
 	    	user.setId(id);
 	    	user.setAge(age);
 	    	user.setPassword(password);
 	    	user.setSex(sex);
 	    	user.setUsername(username);
 	    	int line = userService.updateUser(user);
 	    	if(line>0){
	    		//3.如果添加成功，跳转页面
	            out.print("<script>alert('修改成功！！！');" +
	                    "window.location='/MyServlet/queryUserPage?page=1'</script>");
	    	}else{
	    		 //4.如果已存在提示 添加失败
	            out.print("<script>alert('修改失败！！！');" +
	                    "window.location='/MyServlet/queryUserPage?page=1'</script>");
	    	}
 	    	out.flush();
 	        out.close();
 	    }
 	}
    
}
