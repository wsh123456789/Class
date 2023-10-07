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
import java.util.ArrayList;

// 注解
@WebServlet("/query")
public class QueryUsersServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置编码格式
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        req.setCharacterEncoding("UTF-8");

        // 查询用户数据
        ArrayList<User> userList = userService.queryUsers();

        System.out.println(userList);
        // 拿到数据传回前端界面
        req.setAttribute("userList",userList);

        // 转发 可以携带数据
        req.getRequestDispatcher("index.jsp").forward(req,resp);


    }
}
