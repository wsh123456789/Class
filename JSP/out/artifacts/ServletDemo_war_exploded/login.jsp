<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录</title>
</head>
<body>
<%request.setAttribute("path", request.getContextPath()); %>

<form action="${path}/login" method="post">
    <table border="1" align="center" cellspacing="0" cellpadding="20">
        <tr>
            <td>用户名:</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>密码:</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr align="center" >
            <td colspan="2"><input type="submit" value="登录"></td>
        </tr>

    </table>

</form>
</body>
</html>