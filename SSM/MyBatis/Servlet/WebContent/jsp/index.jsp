<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页页面</title>
</head>
<body>
	<%request.setAttribute("path", request.getContextPath()); %>
	<table border="1" cellpadding="20" cellspacing="0" align="center">
		<tr bgcolor="yellow">
			<td>ID</td>
			<td>用户名</td>
			<td>用户密码</td>
			<td>年龄</td>
			<td>性别</td>
			<td>状态</td>
			<td>操作 <a href="jsp/add.jsp">新增</a>
			</td>
		</tr>
		<c:forEach items="${pageVo.userList}" var="user">
			<tr>
				<td>${user.id}</td>
				<td>${user.username}</td>
				<td>${user.password}</td>
				<td>${user.age}</td>
				<td>${user.sex}</td>
				<td>${user.status}</td>
				<td><a href="${path}/deleteUsersById?id=${user.id}">删除</a> <a
					href="${path}/getUsersById?id=${user.id}">修改</a></td>
			</tr>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="7" align="center"><a
				href="${path}/queryUserPage?page=1">首页</a> <c:if
					test="${pageVo.currentPage > 1}">
					<a href="${path}/queryUserPage?page=${pageVo.currentPage - 1}">上一页</a>
				</c:if> <c:if test="${pageVo.currentPage == 1}">
					<a>上一页</a>
				</c:if> <c:if test="${pageVo.currentPage < pageVo.totalPage}">
					<a href="${path}/queryUserPage?page=${pageVo.currentPage +1}">下一页</a>
				</c:if> <c:if test="${pageVo.currentPage == pageVo.totalPage}">
					<a>下一页</a>
				</c:if> <a href="${path}/queryUserPage?page=${pageVo.totalPage}">尾页</a></td>
		</tr>
	</table>
</body>
</html>