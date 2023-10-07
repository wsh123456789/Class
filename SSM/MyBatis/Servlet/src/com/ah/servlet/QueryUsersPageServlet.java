package com.ah.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ah.bean.PageVo;
import com.ah.service.UserService;
import com.ah.service.UserServiceImpl;
@WebServlet("/queryUserPage")
public class QueryUsersPageServlet extends HttpServlet{
	UserService userService=new UserServiceImpl();
	@Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int page=Integer.valueOf(req.getParameter("page"));
		System.out.println(page);
		PageVo pageVo=userService.queryUsersPage(page);
		
		req.setAttribute("pageVo", pageVo);
		
		req.getRequestDispatcher("jsp/index.jsp").forward(req, resp);
    }
	
}
