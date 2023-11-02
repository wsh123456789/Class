package com.wsh.aop;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


import com.wsh.bean.UserInfo;
@Aspect//切面注解
@Component//交给spring容器管理当前对象
public class PointProxy {
	@Before("execution(public * com.wsh.controller..*(..))")
	private void before(JoinPoint joinPoint)throws Exception {
		System.out.println("是否进入切面");
		//只要获取浏览器发送的请求，都用这一段方法体。
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        assert sra != null;
        HttpServletRequest request = sra.getRequest();
        //=====================================================
        StringBuffer requestURL = request.getRequestURL();
        System.out.println("请求地址"+requestURL);
        String contentType = request.getContentType();
        System.out.println("请求类型"+contentType);
        //session信息
        HttpSession session = request.getSession();
        UserInfo user = (UserInfo) session.getAttribute("user");
        if(user==null){
        	throw new LoginNoneException("用户未登录，没有获取到session信息");
        }
        String contextPath = request.getContextPath();
        String newURL = requestURL.substring(requestURL.indexOf(contextPath)+ contextPath.length(),requestURL.length());
        List<String> nameList = user.getNameList();
        if(!nameList.contains(newURL)) {
        	throw new PermissionNoneExpection("用户权限不足");
        }
	}
}


