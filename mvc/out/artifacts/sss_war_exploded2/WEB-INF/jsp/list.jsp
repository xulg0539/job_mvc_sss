<%--
  Created by IntelliJ IDEA.
  User: xulin
  Date: 2020/5/3
  Time: 12:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 align="center">简历列表</h1>
<div style="border: 1px solid white;text-align: center">
    <a href="/user/opt">新增</a>
</div>
<table border="1px;" style="width:80%;margin: 0 auto;">
    <tr align="center" style="border: 1px solid gray;">
        <td>姓名</td>
        <td>地址</td>
        <td>电话</td>
        <td>操作</td>
    </tr>
    <c:if test="${not empty datas}">
        <c:forEach items="${datas}" var="item">
            <tr align="center" style="border: 1px solid red;">
                <td>${item.name}</td>
                <td>${item.address}</td>
                <td>${item.phone}</td>
                <td><a href="/user/opt?id=${item.id}">修改</a>&nbsp;&nbsp;<a href="/user/delById?id=${item.id}">删除</a></td>
            </tr>
        </c:forEach>
    </c:if>
    <c:if test="${ empty datas}">
        <tr align="center" style="border: 1px solid red;">
            <td colspan="4">没有符合条件的数据</td>

        </tr>
    </c:if>
</table>
</body>
</html>
