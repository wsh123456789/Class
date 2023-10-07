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
@WebServlet("/deleteUsersById")
public class DeleteUserServlet extends HttpServlet{
	
	UserService userService=new UserServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		req.setCharacterEncoding("UTF-8");

		
		int id=Integer.valueOf(req.getParameter("id"));
        int flag = userService.deleteUser(id);
        PrintWriter out = resp.getWriter();
        if(flag > 0) {
            //如果删除成功，跳转页面
            out.print("<script>alert('删除成功！！！');" +
                    "window.location='/MyServlet/queryUserPage?page=1'</script>");
        }else {
            //4.如果删除失败，给出提示
            out.print("<script>alert('用户不存在！！！');" +
                    "window.location='/MyServlet/queryUserPage?page=1'</script>");
        }
        out.flush();
        out.close();
	}
}
