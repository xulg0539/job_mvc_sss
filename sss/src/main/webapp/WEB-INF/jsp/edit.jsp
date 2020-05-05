<%--
  Created by IntelliJ IDEA.
  User: xulin
  Date: 2020/5/5
  Time: 8:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>数据编辑</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/opts" method="post">
    <input type="hidden" name="id" value="${item.id}">
    <fieldset>
        <label>姓名：</label><input type="text" name="name" value="${item.name}"><br>
        <label>地址：</label><input type="text" name="address" value="${item.address}"><br>
        <label>电话：</label><input type="text" name="phone" value="${item.phone}"><br>
        <input type="submit" value="提交">
    </fieldset>
</form>
</body>
</html>
