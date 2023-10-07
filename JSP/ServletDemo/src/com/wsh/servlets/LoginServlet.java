package com.wsh.servlets;

import com.wsh.services.UserService;
import com.wsh.services.UserServiceImpl;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 *1.获取前端数据
 *2.将数据传到数据库
 *3.如果存在登陆成功，跳转页面
 *4.如果不存在提示 登录失败
 */

@WebServlet("/login")
public class LoginServlet extends HttpServlet{


//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        ServletOutputStream outputStream = resp.getOutputStream();
//        outputStream.print("hahaha");
//        System.out.println("nihao");
//
//
//    }

    //处理级别最高的
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        // 设置编码格式
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        req.setCharacterEncoding("UTF-8");

        UserService userService = new UserServiceImpl();

        //1.获取前端数据
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //将数据传到数据库
        boolean flag = userService.loginByNameAndPwd(username,password);

        if(flag) {
            //3.如果存在登陆成功，跳转页面
            resp.sendRedirect(req.getContextPath() + "/queryUsersPage?page=1");
        }else {
            //4.如果不存在提示 登录失败
            resp.getWriter().write("用户名应为手机号，用户名或密码输入错误，登陆失败！！！！");
        }

        // 会话跟踪技术
        // http是无状态的： 服务器无法判断这两次请求是否是同一个客户端发送过来的。
        // 客户端第一次给服务端发请求，服务端获取session，如果获取不到就创建新的响应给客户端
        // 下次客户端给服务端发请求时，会把sessionID带给服务器，那么服务器就能获取到id,
        // 服务器判断这一次请求和之前请求是否是同一个客户端，从而区分客户端

        // 常用的API
        // request.getSession()  获取当前会话，没有则创建一个新会话
        // request.getSession(true) 和上边相同
        // request.getSession(false) 获取当前会话，没有就返回null，不会创建新会话
        // session.getID() 获取sessionID
        // session.isNew() 判断当前session是否为新的
        // session.
        // session.getMaxInactiveInterval() session的非激活间隔时长，默认1800秒
        // session.setMaxInactiveInterval() 设置session的非激活间隔时长
        // session.invalidate() 强制让会话立即失效

        // session保存作用域
        // session的保存作用域是和某一个具体的session对应的
        // 常用API
        // void session.setAttribute(k,v) 以键值对的形式存储数据在作用域中
        // Object session.getAttribute(k) 通过key值返回Object类型的value
        // void session.removeAttribute(k)通过key值删除数据

        // 服务器内部转发以及客户端重定向
        // request.getRequestDispatcher().forward(req,resp) 服务器内部转发
        // response.sendRedirect() 重定向

        // Thymeleaf  视图模板技术
    }



}

