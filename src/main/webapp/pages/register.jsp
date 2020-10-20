<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2018-11-26
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>
<h1>用户注册</h1>
<form action="/register" method="post">
    <input type="text" name="username" placeholder="用户名"><br>
    <input type="password" name="password" placeholder="密码"><br>
    <input type="submit" value="提交">
</form>
<a href="/login1">已有账号去登陆吧</a>
</body>
</html>
