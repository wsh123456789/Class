package com.wsh.servlets;

import com.wsh.services.UserService;
import com.wsh.services.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/delete")
public class DeleteUsersServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        UserService userService = new UserServiceImpl();

        // 获取要删除用户名
        Integer id = Integer.valueOf(req.getParameter("id"));

        // 删除用户数据
        boolean flag = userService.deleteUsers(id);

        PrintWriter out = resp.getWriter();
        if(flag) {
            //3.如果删除成功，跳转页面
            out.print("<script>alert('删除成功！！！');" +
                    "window.location='/queryUsersPage?page=1'</script>");
        }else {
            //4.如果不存在提示 删除失败
            out.print("<script>alert('用户不存在！！！')</script>" +
                    "window.location='/queryUsersPage?page=1'</script>");
        }
        out.flush();
        out.close();

    }
}
