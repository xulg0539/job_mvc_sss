<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html >
<head>
    <meta http-equiv="content-type" content="txt/html; charset=utf-8" />
</head>
<body>
<h2 align="center">欢迎访问sss版web</h2>
<form action="${pageConext.request.contextPath}/user/login" method="post">
    <label>用户名:</label><input type="text" name="username" value=""><br>
    <label>密  码:</label><input type="password" name="password" value=""><br>
    <input type="submit" value="登录">
</form>
</body>
</html>
