<%--
  Created by IntelliJ IDEA.
  User: Angus
  Date: 2023/9/8
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>添加</title>
</head>
<body>
<%request.setAttribute("path", request.getContextPath()); %>
<form action="${path}/add" method="post">
    <table border="1" cellspacing="0" cellpadding="20" align="center">
        <caption>添加用户信息</caption>
        <tr>
            <td>用户名:</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>密码:</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td>年龄:</td>
            <td><input type="text" name="age"></td>
        </tr>
        <tr>
            <td>性别:</td>
            <td>
                <input type="radio" name="sex" value="男">男
                <input type="radio" name="sex" value="女">女
            </td>
        </tr>

        <tr align="center" >
            <td colspan="2"><input type="submit" value="添加"></td>
        </tr>
    </table>

</form>
</body>
</html>
