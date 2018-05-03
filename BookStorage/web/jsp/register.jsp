<%--
  Created by IntelliJ IDEA.
  User: zzz
  Date: 2018/4/30
  Time: 19:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
</head>
<body>
<form action="../../storage/servlet/LoginServlet" method="post">
    用户名：<input type="text" name="userName"><br/>
    密码：<input type="password" name="password"><br/>
    邮箱：<input type="text" name="mail"><br/>
    <input type="submit" value="注册"><br/>
</form>
</body>
</html>