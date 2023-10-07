<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.wsh.bean.User" %>
<%@ page import="com.wsh.bean.PageVo" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>首页</title>
</head>
<body>
<%request.setAttribute("path", request.getContextPath()); %>
<table align="center" border="1" cellspacing="0" cellpadding="20">
    <tr>
        <td>id</td>
        <td>用户名</td>
        <td>密码</td>
        <td>年龄</td>
        <td>性别</td>
        <td>版本</td>
        <td>操作 <a href="${path}/add.jsp">添加</a></td>
    </tr>
    <c:forEach items="${pageVo.userList}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>${user.age}</td>
            <td>${user.sex}</td>
            <td>${user.version}</td>
            <td><a href="${path}/delete?id=${user.id}">删除</a> <a href="${path}/getUserById?id=${user.id}">修改</a>
            </td>
        </tr>
    </c:forEach>
    <tr align="center">
        <td colspan="7">
            <a href="${path}/queryUsersPage?page=1">首页</a>
            <c:if test="${pageVo.currentPage > 1}">
                <a href="${path}/queryUsersPage?page=${pageVo.currentPage - 1}&page_count=${pageVo.pageCount}">上一页</a>
            </c:if>
            <c:if test="${pageVo.currentPage == 1}">
                <a>上一页</a>
            </c:if>
            <c:if test="${pageVo.currentPage < pageVo.totalPage}">
                <a href="${path}/queryUsersPage?page=${pageVo.currentPage + 1}&page_count=${pageVo.pageCount}">下一页</a>
            </c:if>
            <c:if test="${pageVo.currentPage == pageVo.totalPage}">
                <a>下一页</a>
            </c:if>
            <a href="${path}/queryUsersPage?page=${pageVo.totalPage}&page_count=${pageVo.pageCount}">尾页</a>
            <span style="display: inline-block">
                <form action="${path}/queryUsersPage?page=1" method="post">
                    <select name="page_count">
                        <option selected>5</option>
                        <option>7</option>
                        <option>10</option>
                    </select>
                    <input type="submit" value="确定">
                </form>
            </span>

        </td>
    </tr>
</table>
</body>
</html>
