<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增页面</title>
</head>
<body>
	<%request.setAttribute("path", request.getContextPath()); %>
	<form action="${path}/updateUser" method="post">
		<table border="1" cellspacing="0" cellpadding="20" align="center">
			<caption>修改用户信息</caption>
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="username" value="${user.username}">
					<input type="hidden" name="id" value="${user.id}"></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name="password"
					value="${user.password}"></td>
			</tr>
			<tr>
				<td>年龄：</td>
				<td><input type="number" name="age" value="${user.age}"></td>
			</tr>
			<tr>
				<td>性别：</td>
				<td><c:if test="${user.sex eq '男'}">
						<input type="radio" name="sex" value="男" checked="checked">男
            <input type="radio" name="sex" value="女">女
        </c:if> <c:if test="${user.sex eq '女'}">
						<input type="radio" name="sex" value="男">男
            <input type="radio" name="sex" value="女" checked="checked">女
        </c:if></td>
			</tr>
			<tr align="center">
				<td colspan="2"><input type="submit" value="提交"></td>
			</tr>
		</table>
	</form>
</body>
</html>