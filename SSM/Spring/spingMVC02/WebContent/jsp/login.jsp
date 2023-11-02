<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%request.setAttribute("path", request.getContextPath()); %>
<!-- action="放的是请求的url(后台提供的要求前端访问的路径)"，method(请求方式，请求的是get/post) -->
	<form action="${path }/user/login" method="post">
		<table border="all" align="center">
			<tr>
				<th>用户名：</th>
				<th>
					<input type="text" name="username">
				</th>
			</tr>
			<tr>
				<th>密码：</th>
				<th>
					<input type="password" name="password">
				</th>
			</tr>
			<tr>
				<th colspan="2">
					<input type="submit" value="登录">
				</th>
			</tr>
		</table>
	</form>
</body>
</html>