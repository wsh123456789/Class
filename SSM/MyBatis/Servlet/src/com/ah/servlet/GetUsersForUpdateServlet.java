package com.ah.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ah.bean.User;
import com.ah.service.UserService;
import com.ah.service.UserServiceImpl;
@WebServlet("/getUsersById")
public class GetUsersForUpdateServlet extends HttpServlet{
	UserService userService=new UserServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=Integer.valueOf(req.getParameter("id"));
		User user=userService.getUsersById(id);
		req.setAttribute("user", user);
		req.getRequestDispatcher("jsp/update.jsp").forward(req, resp);
	}
}
