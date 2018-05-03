<%--
  Created by IntelliJ IDEA.
  User: zzz
  Date: 2018/4/30
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>

<script language="JavaScript">
    function register() {
        window.location.href="./register.jsp"

    }
</script>

<form action="../../storage/servlet/LoginServlet" method="post">
    用户名：<input type="text" name="userName"><br/>
    密码：<input type="password" name="password"><br/>
    <input type="submit" value="登录"><br/>

</form>
没有账号？注册一个：<input type="button" value="注册" onclick="register()">
</body>
</html>