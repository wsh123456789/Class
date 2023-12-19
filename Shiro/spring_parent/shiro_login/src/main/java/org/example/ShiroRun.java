package org.example;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

public class ShiroRun {
    public static void main(String[] args) {
        // 1.初始化获取SecurityManager
        IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        // 获取认证管理器
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        // 2.获取Subject对象
        Subject subject = SecurityUtils.getSubject();
        // 3.创建token对象，web应用用户名密码从页面传递
        AuthenticationToken token = new UsernamePasswordToken("zhangsan", "z3");
        // 4.完成登录
        try {
            subject.login(token);
            System.out.println("登录成功");
            // 判断角色
            Boolean hasRole = subject.hasRole("role1");
            System.out.println("hasRole====" + hasRole);
            // 判断权限
            boolean isPermitted = subject.isPermitted("user:insert");
            System.out.println("isPermitted=====" + isPermitted);
            // 也可以用checkPermission方法验证权限，没有返回值，如果没有权限会抛异常AuthenticationException
//            subject.checkPermission("user:insert1");
        } catch (UnknownAccountException e) {
            // 登录之前走的Realm认证方法，里面token啥都没有或者已经过期了，
            // 所以拿不到东西，拿不到东西数据库就查不到数据，那你的user类就是null，就会报这个错
            e.printStackTrace();
            System.out.println("用户不存在");
        } catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            System.out.println("密码错误");
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
    }
}
