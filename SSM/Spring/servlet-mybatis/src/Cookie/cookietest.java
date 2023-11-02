package Cookie;

import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class cookietest extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置相应的具体格式
		resp.setContentType("text/html;charset=utf-8");
		//没有cookie为lasttime的情况
		//获取所有的cookie
		Cookie[] cookies = req.getCookies();
		if (cookies == null || cookies.length == 0) {
		    //没有cookie为lasttime，第一次访问
		    Date date = new Date();
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
		    String time = sdf.format(date);
		    Cookie cookie = new Cookie("lasttime", time);
		    cookie.setValue(time);
		    //设置cookie的最大存活时间
		    cookie.setMaxAge(10);
		    resp.addCookie(cookie);
		    resp.getWriter().write("<h1>您好欢迎你首次访问</h1>");
		}else{
			for (Cookie cookie : cookies) {
			    //判断cookie数组中是否有lasttime名字的cookie
			    String name = cookie.getName();
			    if (name.equals("lasttime")) {
			        //如果有说明不是第一次访问
			        //设置cookie的value获取当前时间的字符串，重新设置value，进行重新发送
			        Date date =new Date ();
			        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
			        String time = sdf.format(date);
			        cookie.setValue(time);
			        //设置cookie的最大存活时间
			        cookie.setMaxAge(10);
			        resp.addCookie(cookie);
			        //获取cookie的value也就是上次访问的时间
			        String value = cookie.getValue();
			        resp.getWriter().write("<h1>欢迎回来，你上次访问的时间为：" + value + "</h1>");
			        break;
			    }
			}
		}

	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
