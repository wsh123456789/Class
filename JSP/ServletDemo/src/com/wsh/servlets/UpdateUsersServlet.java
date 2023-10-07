package com.wsh.servlets;

import com.wsh.bean.User;
import com.wsh.services.UserService;
import com.wsh.services.UserServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/update")
public class UpdateUsersServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        // 设置编码格式
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        // 调用service层
        UserService userService = new UserServiceImpl();

        // 创建user传数据
        User user = new User();
        // 获取前端数据
        user.setId(Integer.valueOf(req.getParameter("id")));
        user.setUsername(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));
        user.setAge(Integer.parseInt(req.getParameter("age")));
        user.setSex(req.getParameter("sex"));

        // 查询用户名是否存在

        boolean flag = userService.getUserByIdAndName(user.getId(), user.getUsername());
        // 数据传送回后端

        PrintWriter out = resp.getWriter();
        if(flag) {
            //3.如果用户存在，跳转页面
            out.print("<script>alert('用户名已存在，修改失败！！！');" +
                    "window.location='/queryUsersPage?page=1'</script>");

        }else {
            //4.如果用户不存在就添加
            int line = userService.updateUsers(user);
            if (line > 0){
                out.print("<script>alert('修改成功！！！');" +
                        "window.location='/queryUsersPage?page=1'</script>");
            }else {
                out.print("<script>alert('修改失败！！！');" +
                        "window.location='/queryUsersPage?page=1'</script>");
            }

        }
        out.flush();
        out.close();

    }
}
