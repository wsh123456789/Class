<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>CRM客户关系管理系统_用户登录</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/resource/js/CheckForm.js"></script>
<script type="text/javascript">
	var errori =<%=request.getParameter("error")%>
	if (errori == 'yes') {
		alert("用户或密码错误！请重新输入！");
	}
</script>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #016aa9;
	overflow: hidden;
}

.STYLE1 {
	color: #000000;
	font-size: 12px;
}

#in1 {
	margin-left: 20px;
	height: 18px;
	width: 49px;
	border: 0px;
	background: rgb(24, 25, 26);
}

#in2 {
	margin-left: 20px;
	background-image:
		url('${pageContext.request.contextPath }/resource/images/dl.gif');
	height: 18px;
	width: 49px;
	border: 0px;
}
-->
</style>
<script language="JavaScript" type="text/javascript"
	src="${pageContext.request.contextPath }/resource/js/FormValid.js"></script>

<script type="text/javascript">
	function isNumberOrLetter(s) {//判断是否是数字或字母 

		var regu = "^[0-9a-zA-Z]+$";
		var re = new RegExp(regu);
		if (re.test(s)) {
			return true;
		} else {
			alert("账号只能是字母或数字!");
			return false;
		}
	}
</script>
</head>

<body>
	<form name="from1"
		action="${pageContext.request.contextPath }/user/login" method="post"
		onsubmit="return validator(this)">
		<table width="100%" height="100%" border="0" cellpadding="0"
			cellspacing="0">
			<tr>
				<td><table width="962" border="0" align="center"
						cellpadding="0" cellspacing="0">
						<tr>
							<td height="235"
								background="${pageContext.request.contextPath }/resource/images/login_03.gif">&nbsp;</td>
						</tr>
						<tr>
							<td height="53"><table width="100%" border="0"
									cellspacing="0" cellpadding="0">
									<tr>
										<td width="394" height="53"
											background="${pageContext.request.contextPath }/resource/images/login_05.gif">&nbsp;</td>
										<td width="206"
											background="${pageContext.request.contextPath }/resource/images/login_06.gif"><table
												width="100%" border="0" cellspacing="0" cellpadding="0">
												<tr>
													<td width="16%" height="25"><div align="right">
															<span class="STYLE1">用户</span>
														</div></td>
													<td width="57%" height="25"><div align="center">
															<input type="text" name="userName"
																
																style="width: 105px; height: 17px; background-color: #292929; border: solid 1px #7dbad7; font-size: 12px; color: #6cd0ff">
														</div></td>
														<!-- valid="required|regexp" regexp="^[A-Za-z0-9]+$" -->
														<!-- errmsg="用户名不能为空!|账号只能由字母和数字组成!" -->
													<td width="27%" height="25">&nbsp;</td>
												</tr>
												<tr>
													<td height="25"><div align="right">
															<span class="STYLE1">密码</span>
														</div></td>
													<td height="25"><div align="center">
															<input type="password" name="userPw" valid="required"
																errmsg="密码不能为空!"
																style="width: 105px; height: 17px; background-color: #292929; border: solid 1px #7dbad7; font-size: 12px; color: #6cd0ff">
														</div></td>
												</tr>
												<tr>
													<td colspan="2" height="25">
														<button id="in1">
															<a style="text-decoration: none; color: white;"
																href="${pageContext.request.contextPath }/jsp/register.jsp">注册</a>
														</button> 
														<input type="submit" id="in2" value="登录" />
													</td>
												</tr>
											</table></td>
										<td width="362"
											background="${pageContext.request.contextPath }/resource/images/login_07.gif">&nbsp;</td>
									</tr>
								</table></td>
						</tr>
						<tr>
							<td height="213"
								background="${pageContext.request.contextPath }/resource/images/login_08.gif">
							</td>
						</tr>
					</table></td>
			</tr>
		</table>
	</form>
</body>
</html>