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
import java.io.PrintWriter;

@WebServlet("/add")
public class AddUsersServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        boolean flag = false;

        // 非空判断
        if (req != null){
            System.out.println(req);
            resp.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html; charset=UTF-8");
            req.setCharacterEncoding("UTF-8");
            UserService userService = new UserServiceImpl();

            // 创建user对象存储传来的数据
            User user = new User();
            // 获取前端数据
            user.setUsername(req.getParameter("username"));
            user.setPassword(req.getParameter("password"));
            user.setAge(Integer.valueOf(req.getParameter("age")));
            user.setSex(req.getParameter("sex"));
            System.out.println("user" + user);

            // 将数据传到数据库
            flag = userService.addUsers(user);
            // boolean flag = userService.addUsers(user.getId());

        }

        PrintWriter out = resp.getWriter();
        if(flag) {
            //3.如果添加成功，跳转页面
            out.print("<script>alert('添加成功！！！');" +
                    "window.location='/queryUsersPage?page=1'</script>");
        }else {
            //4.如果已存在提示 添加失败
            out.print("<script>alert('添加失败！！！');" +
                    "window.location='/queryUsersPage?page=1'</script>");
        }
        out.flush();
        out.close();


    }
}
