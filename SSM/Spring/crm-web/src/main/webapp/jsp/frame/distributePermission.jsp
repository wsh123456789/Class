<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户角色修改</title>
</head>
<body>
	<!-- 1.搞一个用户下拉框  2.搞一个角色多选框  3.提交 -->
	<form action="${pageContext.request.contextPath}/user/authorityOfDistribution"
		method="post">


		角色信息：<select name="roleId">
			<c:forEach items="${roleList}" var="r">
				<option value="${r.roleId }">${r.roleName }</option>
			</c:forEach>
		</select> <br /> 权限信息：
		<c:forEach items="${permissionList}" var="p">
				${p.name }<input type="checkbox" name="permissionId" value="${p.id}">
		</c:forEach>
		<br /> <input type="submit" value="提交">
	</form>


</body>
</html>