<%--
  Created by IntelliJ IDEA.
  User: Angus
  Date: 2023/9/8
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改</title>
</head>
<body>
<%request.setAttribute("path", request.getContextPath()); %>
<form action="${path}/update" method="post">
  <table border="1" cellspacing="0" cellpadding="20" align="center">
    <caption>修改用户信息</caption>
    <tr>
      <td>用户名:</td>
      <td>
        <input type="hidden" name="id" value="${user.id}">
        <input type="text" name="username" value="${user.username}"></td>

      </td>
    </tr>
    <tr>
      <td>密码:</td>
      <td><input type="text" name="password" value="${user.password}"></td>
    </tr>
    <tr>
      <td>年龄:</td>
      <td><input type="text" name="age" value="${user.age}"></td>
    </tr>
    <tr>
      <td>性别:</td>
      <td>
      <c:if test="${user.sex eq '男'}">
        <input type="radio" name="sex" value="男" checked="checked">男
        <input type="radio" name="sex" value="女">女
      </c:if>
      <c:if test="${user.sex eq '女'}">
        <input type="radio" name="sex" value="男">男
        <input type="radio" name="sex" value="女" checked="checked">女
      </c:if>
      </td>
    </tr>
    <tr align="center" >
      <td colspan="2"><input type="submit" value="修改"></td>
    </tr>
  </table>

</form>
</body>
</html>
