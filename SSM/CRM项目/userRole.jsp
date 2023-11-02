<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 1.搞一个用户下拉框  2.搞一个角色多选框  3.提交 -->
<form action="${pageContext.request.contextPath}/distributerole" method="post">
		用户信息：<select name="userid">
			<c:forEach items="${us}" var="u">
				<option value="${u.userId }">${u.userName }</option>
			</c:forEach>
		</select>
		<br/>
		角色信息：<c:forEach items="${role}" var="r">
				${r.roleName }<input type="checkbox" name="roleid" value="${r.roleId }">
			</c:forEach>
		<br/>
		<input type="submit" value="提交">
	</form>

</body>
</html>