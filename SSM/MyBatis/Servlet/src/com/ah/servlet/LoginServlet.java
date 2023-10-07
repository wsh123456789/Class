package com.ah.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ah.service.UserService;
import com.ah.service.UserServiceImpl;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8");
 		resp.setContentType("text/html; charset=UTF-8");
 		
 		UserService userService = new UserServiceImpl();
 		req.setCharacterEncoding("UTF-8");
        //1.获取前端数据
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username);
        //将数据传到数据库
        boolean flag = userService.loginByUserNameAndPwd(username,password);
        System.out.println(flag);
        PrintWriter out = resp.getWriter();
        if(flag) {
            //3.如果添加成功，跳转页面
            out.print("<script>alert('登录成功！！！');" +
                    "window.location='/MyServlet/queryUserPage?page=1'</script>");
        }else {
            //4.如果已存在提示 添加失败
            out.print("<script>alert('用户名或密码错误！！！');" +
                    "window.location='/MyServlet/jsp/login.jsp'</script>");
        }
        out.flush();
        out.close();
	}
}
