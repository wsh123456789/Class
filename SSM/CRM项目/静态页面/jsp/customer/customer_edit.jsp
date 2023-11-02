<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<!-- <base href="${pageContext.request.contextPath }/"> -->

		<title>修改客户信息</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<LINK href="${pageContext.request.contextPath }/resource/css/admin.css" type=text/css
			rel=stylesheet>
		<script type="text/javascript"
			src="${pageContext.request.contextPath }/resource/js/CheckForm.js"></script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath }/resource/js/My97DatePicker/WdatePicker.js"></script>
<script language="JavaScript" type="text/javascript" src="${pageContext.request.contextPath }/resource/js/FormValid.js"></script>
	</head>

	<body>
		<form action="${pageContext.request.contextPath }/servlet/CustomerUpdateServlet"
			method="post" name="form2" onsubmit="return validator(this)" >
			

			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr class=editHeaderTr>
					<td class=editHeaderTd colSpan=7>
						请修改客户信息
						<input type="hidden" name="customerId"
							value="3" />
					</td>
				</tr>
		<tr>
		
		
		<td width="12%" bgcolor="#FFFDF0"><div align="center">负责员工：</div></td>
		
		<td colspan="3" bgcolor="#FFFFFF">
		
		<select  name="customerForUser" style=" width: 145px">
			
			<c:forEach items="${us }" var="u">
				<option  <c:if test="${u.userId==c.ui.userId }">selected</c:if>  value="${u.userId }" >${u.userName }</option>
				
			</c:forEach>	
			<!-- <option    value="6">蒋元征</option>
					
			<option    value="1" >张三</option>
					
			<option    value="7">黄建新</option>
					
			<option    value="3">王五</option>
					
			<option    value="4">孙悟空</option>
					
			<option    value="5">猪八戒</option> -->
			
			</select>		
		</td>
					<td width="12%" bgcolor="#FFFDF0">
						<div align="center">
							客户来源：
						</div>
					</td>
					<td width="37%" colspan="3" bgcolor="#FFFFFF">
						<select name="customerSource" style="width: 145px">
							
							
							<option value="1"
								
								selected="selected" >自己上门</option>
							
							<option value="2"
								>朋友推荐</option>
							
							<option value="3"
								>百度网</option>
							
						</select>
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							客户姓名：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" style=" width: 145px" readonly="readonly"   name="customerName"
							value="${c.customerName }">
					</td>
					<td bgcolor="#FFFDF0">
						<div align="center">
							客户状态：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<select name="customerCondition" style="width: 145px">
							
							
							<option value="1"
								
								selected="selected" >潜在客户</option>
							
							<option value="2"
								>意向客户</option>
							
							<option value="3"
								>交易客户</option>
							
						</select>
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							客户性别：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="radio" name="customerSex" value="男"
							
							checked="checked"  />
						男&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" name="customerSex" value="女"
							 />
						女
						<br />
					</td>
					<td bgcolor="#FFFDF0">
						<div align="center">
							客户类型：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<select name="customerType" style="width: 145px">
							
							
							<option value="1"
								
								selected="selected" >客户</option>
							
							<option value="2"
								>合作伙伴</option>
							
							<option value="3"
								>供应商</option>
							
							<option value="4"
								>合作伙伴</option>
							
						</select>
					</td>
				</tr>

				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							出生日期：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text"style=" width: 145px"  disabled="disabled" name="customerBirthday"
							value="2013-05-21 15:40:54.0"
							readonly="readonly" id="customerBirthday"
							onclick="WdatePicker({el:customerBirthday,dateFmt:'yyyy-MM-dd HH:mm:ss '})">
						&nbsp;
					</td>
					<td bgcolor="#FFFDF0">
						<div align="center">
							客户手机：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" style=" width: 145px"    valid="regexp"  regexp="^1[3|4|5|8][0-9]\d{8}$"   errmsg="请输入正确的手机号码!"   name="customerMobile"
							value="13854545454">
						&nbsp;
					</td>
				</tr>

				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							客户QQ：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" style=" width: 145px"   valid="isQQ"   errmsg="请输入正确的QQ号码!"  name="customerQq"
							value="23245">
						&nbsp;
					</td>
					<td bgcolor="#FFFDF0">
						<div align="center">
							客户地址：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" style=" width: 145px"  maxlength="50" name="customerAddress"
							value="重庆">
						&nbsp;
					</td>
				</tr>

				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							客户邮箱：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" style=" width: 145px"  maxlength="50" name="customerEmail"  valid="required|isEmail"  errmsg="Email不能为空|Email格式不对!" value="379727687@qq.com">
						&nbsp;
					</td>
					<td bgcolor="#FFFDF0">
						<div align="center">
							客户职位：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" style=" width: 145px"  maxlength="50" name="customerJob"
							value="学生">
						&nbsp;
					</td>
				</tr>

				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							客户微博：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" style=" width: 145px" maxlength="50"  name="customerBlog"
							value="6567">
						&nbsp;
					</td>
					<td bgcolor="#FFFDF0">
						<div align="center">
							客户座机：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" style=" width: 145px" valid="isPhone"   errmsg="请输入正确的座机号码!" name="customerTel"
							value="52454789">
						&nbsp;
					</td>
				</tr>

				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							客户MSN：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" style=" width: 145px" maxlength="50"  name="customerMsn"
							value="53423134">
						&nbsp;
					</td>
					<td bgcolor="#FFFDF0">
						<div align="center">
							客户公司：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" style=" width: 145px"  maxlength="50" name="customerCompany"
							value="微微">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							创建人：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" style=" width: 145px" disabled="disabled" name="customerAddMan"
							value="张三">
						<input type="hidden"
							value="2017-06-15 10:10:30"
							name="customerChangeTime">
						<input type="hidden" name="customerAddTime"
							value="2013-05-23 23:08:52.0"
							readonly="readonly" id="customerAddTime">
					</td>
					<td bgcolor="#FFFDF0">
						<div align="center">
							修改人：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" style=" width: 145px"  maxlength="50" name="customerChangeMan"
							value="热热热">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							备注：
						</div>
					</td>
					<td colspan="6" bgcolor="#FFFFFF">
						<textarea rows="10" name="customerRemark"
							style="width: 100%; resize: none;">
						如同仁堂
		
		</textarea>
					</td>
				</tr>
			</table>
			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr bgcolor="#ECF3FD">
					<td width="36%"></td>
					<td width="17%"><input type="submit" name="submit"  value="提交"></td>
					<td width="4%"><input type="button" name="button"  onClick="history.back() "  value="返回"></td>
					<td width="43%"></td>
				</tr>
			</table>
		</form>
	</body>
</html>
