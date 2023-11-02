<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>显示客户信息</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script type="text/javascript"
	src="${pageContext.request.contextPath }/resource/js/jquery-1.9.1.js"></script>

<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}

.STYLE1 {
	font-size: 12px
}

.STYLE3 {
	font-size: 12px;
	font-weight: bold;
}

.STYLE4 {
	color: #03515d;
	font-size: 12px;
}

a {
	text-decoration: none;
	color: #033d61;
	font-size: 12px;
}

A:hover {
	COLOR: #f60;
	TEXT-DECORATION: underline
}
-->
</style>
<script>
var  highlightcolor='#c1ebff';
var  clickcolor='#51b2f6';
function  changeto(){
source=event.srcElement;
if  (source.tagName=="TR"||source.tagName=="TABLE")
return;
while(source.tagName!="TD")
source=source.parentElement;
source=source.parentElement;
cs  =  source.children;
//alert(cs.length);
if  (cs[1].style.backgroundColor!=highlightcolor&&source.id!="nc"&&cs[1].style.backgroundColor!=clickcolor)
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor=highlightcolor;
}
}

function  changeback(){
if  (event.fromElement.contains(event.toElement)||source.contains(event.toElement)||source.id=="nc")
return
if  (event.toElement!=source&&cs[1].style.backgroundColor!=clickcolor)
//source.style.backgroundColor=originalcolor
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor="";
}
}

function  clickto(){
source=event.srcElement;
if  (source.tagName=="TR"||source.tagName=="TABLE")
return;
while(source.tagName!="TD")
source=source.parentElement;
source=source.parentElement;
cs  =  source.children;
//alert(cs.length);
if  (cs[1].style.backgroundColor!=clickcolor&&source.id!="nc")
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor=clickcolor;
}
else
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor="";
}
}
</script>
<script type="text/javascript">
	function add(){  
		window.location="${pageContext.request.contextPath }/customer/customerAction_add";
	}

</script>

<script type="text/javascript">
	function goPage(){
		var toPageNum = $("#toPage").val();
		query1(toPageNum);
	}

	function query1(currentPage){
		var queryType = $("#queryType").val();
		var queryContent = $("#queryContent").val();
		
		console.log("queryType" + queryType);
		console.log("queryContent" + queryContent);
		//动态绑定当前页
		$("#currentPage").val(currentPage)
		
		var queryPropetyName;
		switch (queryType) {
		case "1":
			queryPropetyName = "customerName";
			break;
		case "2":
			break;
		case "3":
			break;
		case "4":
			queryPropetyName = "sourceName";
			break;
		case "5":
			break;
		case "6":
			break;

		default:
			break;
		}
		
		$("#queryProperty").attr("name",queryPropetyName);
		$("#queryProperty").val(queryContent);
		
		//提交表单
		$("form")[0].submit();
	}

	/* function chagePage(currentPage){
		//动态绑定当前页
		$("#currentPage").val(currentPage)
		//动态绑定查询的字段名
		var queryType = $("#queryType").val();
		var queryContent = $("#queryContent").val();
		var queryPropetyName;
		switch (queryType) {
		case "1":
			queryPropetyName = "customerName";
			break;
		case "2":
			
			break;
		case "3":
			queryPropetyName = "cs.sourceName";
			break;
		case "4":
			
			break;
		case "5":
			
			break;
		case "6":
			
			break;

		default:
			break;
		}
		$("#queryProperty").attr("name",queryPropetyName);
		$("#queryProperty").val(queryContent);
		//提交表单
		$("form")[0].submit();
	}
	
	function query(){
		var queryType = $("#queryType").val();
		var queryContent = $("#queryContent").val();
		switch (queryType) {
		case "1":
			window.location.href="${pageContext.request.contextPath }/customerAction_listByPageBean?customerName="+queryContent;
			break;
		case "2":
			
			break;
		case "3":
			window.location.href="${pageContext.request.contextPath }/customerAction_listByPageBean?cs.sourceName="+queryContent+"&queryType="+queryType+"&queryContent="+queryContent;
			break;
		case "4":
			
			break;
		case "5":
			
			break;
		case "6":
			
			break;

		default:
			break;
		}
		
	} */
</script>

</head>

<body>
	<form
		action="${pageContext.request.contextPath }/customer/customerAction_listByPageBean"
		method="post">

		<!-- 当前页隐藏域 -->
		<input type="hidden" id="currentPage" name="currentPage"> <input
			type="hidden" id="queryProperty" name="">


		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td height="30"
					background="${pageContext.request.contextPath }/resource/images/tab_05.gif"><table
						width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="12" height="30"><img
								src="${pageContext.request.contextPath }/resource/images/tab_03.gif"
								width="12" height="30" /></td>
							<td><table width="100%" border="0" cellspacing="0"
									cellpadding="0">
									<tr>
										<td class="STYLE4" align="center">&nbsp;&nbsp;请输入查询内容：<input
											type="text" id="queryContent" name="queryContent"
											value="${queryContent }" style="width: 290px" /></td>
										<td class="STYLE4">&nbsp;&nbsp;请选择查询方式： <select
											id="queryType" name="queryType" style="width: 100px">

												<option value="1"
													<c:if test="${queryType=='1' }">selected</c:if>>客户姓名</option>
												<option value="2"
													<c:if test="${queryType=='2' }">selected</c:if>>客户状态</option>
												<option value="3"
													<c:if test="${queryType=='3' }">selected</c:if>>客户来源</option>
												<option value="4"
													<c:if test="${queryType=='4' }">selected</c:if>>客户类型</option>
												<option value="5"
													<c:if test="${queryType=='5' }">selected</c:if>>所属员工</option>
												<option value="6"
													<c:if test="${queryType=='6' }">selected</c:if>>客户公司</option>
										</select>
										</td>
										<td class="STYLE4">&nbsp;&nbsp;<input type="button"
											onclick="query1()" value="查询" style="width: 50px" /></td>
										<td class="STYLE4">&nbsp;&nbsp;<input type="button"
											value="添加" onclick="add()" style="width: 50px" /></td>
									</tr>
								</table></td>
							<td width="16"><img
								src="${pageContext.request.contextPath }/resource/images/tab_07.gif"
								width="16" height="30" /> <input type="hidden" name="userId"
								value="" /></td>
						</tr>
					</table></td>
			</tr>


			<tr>
				<td><table width="100%" border="0" cellspacing="0"
						cellpadding="0">
						<tr>
							<td width="8"
								background="${pageContext.request.contextPath }/resource/images/tab_12.gif">&nbsp;</td>
							<td><table width="100%" border="0" cellpadding="0"
									cellspacing="1" bgcolor="b5d6e6" onmouseover="changeto()"
									onmouseout="changeback()">
									<tr>
										<td width="5%" height="22"
											background="${pageContext.request.contextPath }/resource/images/bg2.gif"
											bgcolor="#FFFFFF"><div align="center">
												<span class="STYLE1">姓名</span>
											</div></td>
										<td width="7%" height="22"
											background="${pageContext.request.contextPath }/resource/images/bg2.gif"
											bgcolor="#FFFFFF"><div align="center">
												<span class="STYLE1">状态</span>
											</div></td>
										<td width="7%" height="22"
											background="${pageContext.request.contextPath }/resource/images/bg2.gif"
											bgcolor="#FFFFFF"><div align="center">
												<span class="STYLE1">来源</span>
											</div></td>
										<td width="7%" height="22"
											background="${pageContext.request.contextPath }/resource/images/bg2.gif"
											bgcolor="#FFFFFF"><div align="center">
												<span class="STYLE1">所属员工</span>
											</div></td>
										<td width="7%" height="22"
											background="${pageContext.request.contextPath }/resource/images/bg2.gif"
											bgcolor="#FFFFFF"><div align="center">
												<span class="STYLE1">类型</span>
											</div></td>
										<td width="4%" height="22"
											background="${pageContext.request.contextPath }/resource/images/bg2.gif"
											bgcolor="#FFFFFF"><div align="center">
												<span class="STYLE1">性别</span>
											</div></td>
										<td width="5%" height="22"
											background="${pageContext.request.contextPath }/resource/images/bg2.gif"
											bgcolor="#FFFFFF"><div align="center">
												<span class="STYLE1">手机</span>
											</div></td>
										<td width="5%" height="22"
											background="${pageContext.request.contextPath }/resource/images/bg2.gif"
											bgcolor="#FFFFFF"><div align="center">
												<span class="STYLE1">QQ</span>
											</div></td>
										<td width="6%" height="22"
											background="${pageContext.request.contextPath }/resource/images/bg2.gif"
											bgcolor="#FFFFFF"><div align="center">
												<span class="STYLE1">邮箱</span>
											</div></td>
										<td width="6%" height="22"
											background="${pageContext.request.contextPath }/resource/images/bg2.gif"
											bgcolor="#FFFFFF"><div align="center">
												<span class="STYLE1">职位</span>
											</div></td>
										<td width="16%" height="22"
											background="${pageContext.request.contextPath }/resource/images/bg2.gif"
											bgcolor="#FFFFFF"><div align="center">
												<span class="STYLE1">公司</span>
											</div></td>
										<td width="10%" height="22"
											background="${pageContext.request.contextPath }/resource/images/bg2.gif"
											bgcolor="#FFFFFF"><div align="center">
												<span class="STYLE1">备注</span>
											</div></td>
										<td width="15%" height="22"
											background="${pageContext.request.contextPath }/resource/images/bg2.gif"
											bgcolor="#FFFFFF" class="STYLE1"><div align="center">基本操作</div></td>
									</tr>


									<c:forEach items="${pb.customerList }" var="c">
										<tr>
											<td height="20" bgcolor="#FFFFFF" style="width: 3%"><div
													align="center">
													<span class="STYLE1">${c.customerName }</span>
												</div></td>
											<td height="20" bgcolor="#FFFFFF" style="width: 3%"><div
													align="center">
													<span class="STYLE1">${c.conditionName }</span>
												</div></td>
											<td height="20" bgcolor="#FFFFFF" style="width: 3%"><div
													align="center">
													<span class="STYLE1">${c.sourceName}</span>
												</div></td>
											<td height="20" bgcolor="#FFFFFF" style="width: 6%"><div
													align="center">
													<span class="STYLE1">${c.userName }</span>
												</div></td>
											<td height="20" bgcolor="#FFFFFF" style="width: 3%"><div
													align="center">
													<span class="STYLE1">${c.typeName }</span>
												</div></td>
											<td height="20" bgcolor="#FFFFFF" style="width: 3%"><div
													align="center">
													<span class="STYLE1">${c.customerSex }</span>
												</div></td>
											<td height="20" bgcolor="#FFFFFF" style="width: 5%"><div
													align="center">
													<span class="STYLE1">${c.customerMobile }</span>
												</div></td>
											<td height="20" bgcolor="#FFFFFF" style="width: 3%"><div
													align="center">
													<span class="STYLE1">${c.customerQq }</span>
												</div></td>
											<td height="20" bgcolor="#FFFFFF" style="width: 5%"><div
													align="center">
													<span class="STYLE1">${c.customerEmail }</span>
												</div></td>
											<td height="20" bgcolor="#FFFFFF" style="width: 3%"><div
													align="center">
													<span class="STYLE1">${c.customerJob }</span>
												</div></td>
											<td height="20" bgcolor="#FFFFFF" style="width: 3%"><div
													align="center">
													<span class="STYLE1">${c.customerCompany }</span>
												</div></td>
											<td height="20" bgcolor="#FFFFFF" style="width: 8%"><div
													align="center">
													<span class="STYLE1">${c.customerRemark }</span>
												</div></td>
											<td height="20" bgcolor="#FFFFFF" style="width: 15%"><div
													align="center">
													<span class="STYLE4"><img
														src="${pageContext.request.contextPath }/resource/images/edt.gif"
														width="16" height="16" /> <a
														href="${pageContext.request.contextPath }/customer/customerAction_toEdit?customerId=${c.customerId}">编辑</a>&nbsp;
														<img
														src="${pageContext.request.contextPath }/resource/images/edt.gif"
														width="16" height="16" /> <a href="${pageContext.request.contextPath }/customer/customerAction_toDetail?customerId=${c.customerId}">详情</a>&nbsp;
														<img
														src="${pageContext.request.contextPath }/resource/images/del.gif"
														width="16" height="16" /> <a href="${pageContext.request.contextPath }/customer/customerAction_delete?customerId=${c.customerId}">删除</a></span>
												</div></td>
										</tr>

									</c:forEach>

									<tr>
										<td height="20" bgcolor="#FFFFFF" colspan="22" align="center">
											<div align="center">
												<span class="STYLE1">没有客户相关信息</span>
											</div>
										</td>
									</tr>

								</table></td>
							<td width="8"
								background="${pageContext.request.contextPath }/resource/images/tab_15.gif">&nbsp;</td>
						</tr>
					</table></td>
			</tr>
			<tr>
				<td height="35"
					background="${pageContext.request.contextPath }/resource/images/tab_19.gif"><table
						width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="12" height="35"><img
								src="${pageContext.request.contextPath }/resource/images/tab_18.gif"
								width="12" height="35" /></td>
							<td><table width="100%" border="0" cellspacing="0"
									cellpadding="0">
									<tr>
										<td class="STYLE4">&nbsp;&nbsp;共有${pb.totalSize}条记录，当前第
											${pb.currentPage }/${pb.totalPage }页</td>
										<td><table border="0" align="right" cellpadding="0"
												cellspacing="0">
												<tr>
													<td width="40"><img
														src="${pageContext.request.contextPath }/resource/images/first.gif"
														width="37" height="15" onclick="query1(1)" /></td>
													<c:if test="${pb.currentPage > 1}">
														<td width="45"><img
															src="${pageContext.request.contextPath }/resource/images/back.gif"
															width="43" height="15"
															onclick="query1(${pb.currentPage-1})" /></td>
													</c:if>
													<c:if test="${pageVo.currentPage == 1}">
														<td width="45"><img
															src="${pageContext.request.contextPath }/resource/images/back.gif"
															width="43" height="15" /></td>
													</c:if>
													<c:if test="${pb.currentPage < pb.totalPage}">
														<td width="45"><img
															src="${pageContext.request.contextPath }/resource/images/next.gif"
															width="43" height="15"
															onclick="query1(${pb.currentPage+1})" /></td>
													</c:if>
													<%-- <td width="45"><a href="${pageContext.request.contextPath }/customerAction_listByPageBean?currentPage=${pb.currentPage+1}">下一页</a></td> --%>
													<c:if test="${pb.currentPage == pb.totalPage}">
														<td width="45"><img
															src="${pageContext.request.contextPath }/resource/images/next.gif"
															width="43" height="15" /></td>
													</c:if>
													<td width="40"><img
														src="${pageContext.request.contextPath }/resource/images/last.gif"
														width="37" height="15" onclick="query1(${pb.totalPage})" /></td>
													<td width="100"><div align="center">
															<span class="STYLE1">转到第 <input name="textfield"
																id="toPage" type="text" size="4"
																style="height: 12px; width: 20px; border: 1px solid #999999;" />
																页
															</span>
														</div></td>
													<td width="40"><img
														src="${pageContext.request.contextPath }/resource/images/go.gif"
														onclick="goPage()" width="37" height="15" /></td>
												</tr>
											</table></td>
									</tr>
								</table></td>
							<td width="16"><img
								src="${pageContext.request.contextPath }/resource/images/tab_20.gif"
								width="16" height="35" /></td>
						</tr>
					</table></td>
			</tr>
		</table>
	</form>
</body>
</html>
