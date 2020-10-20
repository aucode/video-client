<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2018-11-24
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>登陆页面</h1>
<form action="/loginUser" method="post">
    <input type="text" name="username" placeholder="用户名"><br>
    <input type="password" name="password" placeholder="密码"><br>
    <input type="submit" value="提交">
</form>
<a href="/regUI">去注册一个账号吧</a>
</body>
</html>
