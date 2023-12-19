package org.example;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;

public class MyRealm extends AuthenticatingRealm {

    // 自定义登录认证方法，shiro的login方法的底层会调用该类的认证方法进行认证
    // 需要配置自定义的realm生效，在ini文件中配置，在spring boot中配置
    // 该方法只是获取进行对比的信息，认证逻辑还是按照shiro底层认证逻辑完成
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 1.获取身份信息
        String principal = authenticationToken.getPrincipal().toString();
        // 2.获取凭证信息
        String password = authenticationToken.getCredentials().toString();
        System.out.println("认证用户信息：" + principal + "=====" + password);
        // 3.获取数据库中的存储的用户信息
        if (principal.equals("zhangsan")){
            // 4.验证数据库中的三次迭代加盐密码
            String pwdInfo = "7174f64b13022acd3c56e2781e098a5f";
            // 5.创建封装校验逻辑对象，封装数据返回
            AuthenticationInfo info = new SimpleAuthenticationInfo(
                    authenticationToken.getPrincipal(), // 用户对象
                    pwdInfo,                            // 数据库中获取的密码
                    ByteSource.Util.bytes("salt"),// 设置盐值
                    getName()                           // 当前realm名
            );
            System.out.println("myRealm");
            return info;
        }
        return null;
    }
}
