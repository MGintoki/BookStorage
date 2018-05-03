<%--
  Created by IntelliJ IDEA.
  User: zzz
  Date: 2018/4/30
  Time: 19:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../css/demo.css">
</head>
<body>

<script language="JavaScript">
function login() {
    window.location.href='./login.jsp'

}

</script>

<div id="container" style="width:500px">

    <div id="header" >

        <h1 style="margin-bottom:0;">菜鸟书城</h1></div>
        <h4>欢迎登陆</h4><input type="button" onclick=login()>
    <div id="menu">
        <b>菜单</b><br>



    </div>

    <div id="content" >
        内容在这里</div>

    <div id="footer" >
        Copyright©MGintoki@904448980@qq.com</div>

</div>

</body>
</html>