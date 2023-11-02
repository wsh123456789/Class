<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
    #f1{
        color: orangered;
    }
    #f2{
        font-size: 4px;
        font-weight:600;
    }
    #t1{
        border: solid 5px orangered;
    }
    a{
        text-decoration: none;
        color:orangered;
    }
    input{
        outline:none
    }
</style>
<body background="./aaa.jpg">
    <form action="${pageContext.request.contextPath }/user/register" method="post" >
        <table id="t1" align="center">
            <tr>
                <td>
            <table 1border="1px" align="center" cellspacing="px" cellpadding="15px">
            <tr>
                <td>
                    <font id="f1">会员注册</font>
                </td>
                <td>
                    <font id="f2">MEMBER REGISTRATION</font>
                </td>
            </tr>
            <tr>
                <td>
                    <font>用户名：</font>
                </td>
                <td>
                    <input type="text" name="userName" placeholder="请输入用户名">
                </td>
            </tr>
            <tr>
                <td>
                    <font>密码：</font>
                </td>
                <td>
                    <input type="password" name="userPw" placeholder="请输入密码">
                </td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td>
                    <input type="submit" name="" id="" value="注册">
                <a href="${pageContext.request.contextPath }/jsp/login.jsp">点击登录</a>
                </td>
            </tr>
        </table>
    </td>
    </tr>
    </table>        
    </form>
</body>
</html>