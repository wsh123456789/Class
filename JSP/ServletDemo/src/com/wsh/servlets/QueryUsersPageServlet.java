package com.wsh.servlets;

import com.wsh.bean.PageVo;
import com.wsh.bean.User;
import com.wsh.services.UserService;
import com.wsh.services.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/queryUsersPage")
public class QueryUsersPageServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接收查看的页数
        int page = Integer.parseInt(req.getParameter("page"));

        int page_count = 5;

        if (req.getParameter("page_count") != null){
            page_count = Integer.parseInt(req.getParameter("page_count"));
        }

        System.out.println("page_count"  + page_count);
        // 分页查询数据
        PageVo pageVo = userService.queryUsersPage(page, page_count);
//        System.out.println(pageVo);
        // 数据传给前端
        req.setAttribute("pageVo",pageVo);
        req.getRequestDispatcher("index.jsp").forward(req,resp);

    }
}
