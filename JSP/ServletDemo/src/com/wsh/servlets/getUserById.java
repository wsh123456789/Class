package com.wsh.servlets;

import com.wsh.bean.User;
import com.wsh.services.UserService;
import com.wsh.services.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getUserById")
public class getUserById extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置编码格式
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        req.setCharacterEncoding("UTF-8");

        UserService userService = new UserServiceImpl();

        //1.获取前端数据
        Integer id = Integer.valueOf(req.getParameter("id"));
        //将数据传到数据库
        User user = userService.getUserById(id);

        // 拿到数据传回前端界面
        req.setAttribute("user",user);

        // 转发 可以携带数据
        req.getRequestDispatcher("update.jsp").forward(req,resp);
    }
}
