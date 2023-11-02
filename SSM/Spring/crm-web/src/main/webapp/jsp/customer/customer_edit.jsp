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
	<script type="text/javascript" src="${pageContext.request.contextPath }/resource/kindeditor/kindeditor.js"></script>
<script type="text/javascript">
			KE.show({
			id:'remark',
			items:['source', '|', 'fullscreen', 'undo', 'redo', 'print', 'cut', 'copy', 'paste',
					'plainpaste', 'wordpaste', '|', 'justifyleft', 'justifycenter', 'justifyright',
					'justifyfull', 'insertorderedlist', 'insertunorderedlist', 'indent', 'outdent', 'subscript',
					'superscript', '|', 'selectall', '-',
					'title', 'fontname', 'fontsize', '|', 'textcolor', 'bgcolor', 'bold',
					'italic', 'underline', 'strikethrough', 'removeformat', '|', 'image',
					'flash', 'media', 'advtable', 'hr', 'emoticons', 'link', 'unlink', '|', 'about'],
			width:'80%'
			});
	</script>
	</head>

	<body>
		<form action="${pageContext.request.contextPath }/customer/CustomerUpdateServlet"
			method="post" name="form2" onsubmit="return validator(this)" >
			

			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr class=editHeaderTr>
					<td class=editHeaderTd colSpan=7>
						请修改客户信息
						<input type="hidden" name="customerId"
							value="${ci.customerId }" />
					</td>
				</tr>
		<tr>
		
		
		<td width="12%" bgcolor="#FFFDF0"><div align="center">负责员工：</div></td>
		
		<td colspan="3" bgcolor="#FFFFFF">
		
		<select  name="userId" style=" width: 145px">	
			<c:forEach items="${ci.userInfo }"  var="ui">
				<option  <c:if test="${ci.userId} == ${ui.userId }">selected</c:if>  value=" ${ui.userId }" > ${ui.userName }</option>
			</c:forEach>
			</select>		
		</td>
					<td width="12%" bgcolor="#FFFDF0">
						<div align="center">
							客户来源：
						</div>
					</td>
					<td width="37%" colspan="3" bgcolor="#FFFFFF">
						<select name="sourceId" style="width: 145px">
							<c:forEach items="${ci.customerSource }"  var="cs">
								<option  <c:if test="${ci.sourceId} == ${cs.sourceId }">selected</c:if>  value=" ${cs.sourceId }" > ${cs.sourceName }</option>
							</c:forEach>
							<%-- <option  <c:if test="${ci.sourceId} == 1">selected</c:if>  value="1" >自己上门</option>
							<option  <c:if test="${ci.sourceId} == 2">selected</c:if>  value="2" >网上推荐</option>
							<option  <c:if test="${ci.sourceId} == 3">selected</c:if>  value="3" >朋友推荐</option>
							<option  <c:if test="${ci.sourceId} == 4">selected</c:if>  value="4" >电话推荐</option>
							<option  <c:if test="${ci.sourceId} == 5">selected</c:if>  value="5" >缅甸来客</option> --%>

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
							value="${ci.customerName }">
					</td>
					<td bgcolor="#FFFDF0">
						<div align="center">
							客户状态：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<select name="conditionId" style="width: 145px">
							<c:forEach items="${ci.customerCondition }"  var="cc">
								<option  <c:if test="${ci.conditionId} == ${cc.conditionId }">selected</c:if>  value=" ${cc.conditionId }" > ${cc.conditionName }</option>
							</c:forEach>
	
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
							<c:if test="${ci.customerSex eq '男'}">checked</c:if> />
						男&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" name="customerSex" value="女"
							<c:if test="${ci.customerSex  eq '女'}">checked</c:if> />
						女
						<br />
					</td>
					<td bgcolor="#FFFDF0">
						<div align="center">
							客户类型：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<select name="typeId" style="width: 145px">
							<c:forEach items="${ci.customerType }"  var="ct">
								<option  <c:if test="${ci.typeId} == ${ct.typeId }">selected</c:if>  value=" ${ct.typeId }" > ${ct.typeName }</option>
							</c:forEach>
							<%-- <option  <c:if test="${ci.typeId} == 1">selected</c:if>  value="1" >客户</option>
							<option  <c:if test="${ci.typeId} == 2">selected</c:if>  value="2" >合作伙伴</option>
							<option  <c:if test="${ci.typeId} == 3">selected</c:if>  value="3" >供应商</option>
							<option  <c:if test="${ci.typeId} == 4">selected</c:if>  value="4" >合作大佬</option>
							<option  <c:if test="${ci.typeId} == 5">selected</c:if>  value="5" >彩票入股</option>
							 --%>
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
						<input type="datetime-local"style=" width: 145px" name="birthDay"
							value="${ci.birthDay}"
							 id="birthDay"
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
							value="${ci.customerMobile }">
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
							value="${ci.customerQq }">
						&nbsp;
					</td>
					<td bgcolor="#FFFDF0">
						<div align="center">
							客户地址：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" style=" width: 145px"  maxlength="50" name="customerAddress"
							value="${ci.customerAddress }">
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
						<input type="text" style=" width: 145px"  maxlength="50" name="customerEmail"  valid="required|isEmail"  errmsg="Email不能为空|Email格式不对!" value="${ci.customerEmail} ">
						&nbsp;
					</td>
					<td bgcolor="#FFFDF0">
						<div align="center">
							客户职位：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" style=" width: 145px"  maxlength="50" name="customerJob"
							value="${ci.customerJob} ">
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
							value="${ci.customerBlog}">
						&nbsp;
					</td>
					<td bgcolor="#FFFDF0">
						<div align="center">
							客户座机：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" style=" width: 145px" valid="isPhone"   errmsg="请输入正确的座机号码!" name="customerTel"
							value="${ci.customerTel}">
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
							value="${ci.customerMsn}">
						&nbsp;
					</td>
					<td bgcolor="#FFFDF0">
						<div align="center">
							客户公司：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" style=" width: 145px"  maxlength="50" name="customerCompany"
							value="${ci.customerCompany}">
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
							value="${ci.customerAddMan}">
						<input type="hidden"
							value="${ci.customerChangeTime}"
							name="customerChangeTime">
						<input type="hidden" name="customerAddTime"
							value="${ci.customerAddTime}"
							readonly="readonly" id="customerAddTime">
					</td>
					<td bgcolor="#FFFDF0">
						<div align="center">
							修改人：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" style=" width: 145px"  maxlength="50" name="ChangeMan"
							value="${ci.changeMan}">
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
							<textarea name="customerRemark" id="remark" cols="100" rows="8">>${ci.customerRemark}</textarea>
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
