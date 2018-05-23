<%@ page import="storage.domain.Category" %>
<%@ page import="storage.dao.CatDao" %>
<%@ page import="storage.domain.User" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ classEA.
  User: zzz
  Date: 2018/4/30
  Time: 18:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>homePage</title>
  <link rel="stylesheet" type="text/css" href="css/bookStyle2.0.css">
  <link rel="stylesheet" type="text/css" href="css/showBook.css">
  <script src="./js/ajax.js"></script>
</head>
<script>
    function loginOut() {

    }
</script>
<body>

<%
  String loginDisplay2 = "display: none";
  String loginDisplay = "";
  String userName = "";
  String loginState = "";
  User user = new User();
  if(session.getAttribute("loginState") != null){
    loginDisplay = "display: none";
    loginDisplay2 = "";
    loginState = "success";
    if(session.getAttribute("user") != null){
      user = (User)session.getAttribute("user");
      userName = user.getUserName();

    }
  }




%>

<div class="container">

  <div class="top">

            <span class="logo">
                <a href="/index.jsp"><img class="logoPic" src="image/logo.png"></a>
                <h2 class="logoName" id="logoName">菜鸟书城</h2>

            </span>

    <ul class="top">
      <li class="login" style="<%=loginDisplay2%>"><a href="">欢迎，<%=userName%></a></li>
      <li class="login" style="<%=loginDisplay2%>"><a href="LoginOutServlet">登出</a></li>
      <li class="login" style="<%=loginDisplay%>"><a href="login1.jsp">登陆</a></li>

      <li><a href="cat.jsp">购物车</a></li>
      <li><a href="showOrder.jsp">我的订单</a></li>
      <li><a href="admin.jsp">管理员入口</a></li>
      <li class="about"><a href="https://mgintoki.github.io/">关于</a></li>
    </ul>
  </div>

  <div class="menu">

    <div class="menuName">
      <p>图书分类</p>
    </div>
    <ul class="menu">
      <%
        CatDao catDao = new CatDao();
        ArrayList<Category> categories = catDao.getCatList();

        for(Category category : categories){

      %>

      <li class="category" id=<%=category.getCid()%>>
        <div class="menuLi"><%=category.getcName()%><div/>
      <li/>

      <%
        }
      %>

  </div>
  <div class="content" id="books" style="margin: 100px 150px">
   <h1>欢迎来到菜鸟书城</h1>
  </div>
  <div class="msg" id="msg" >
    <p id="<%=loginState%>">zzzzzzzzzzzzz</p>
  </div>

</div>

<%--<div class="container">--%>

  <%--<div class="header" >--%>

    <%--<h1>菜鸟书城</h1>--%>
    <%--<a href="login.jsp">欢迎登陆</a>--%>
  <%--</div>--%>

  <%--<div class="menu">--%>

    <%--<ul>--%>
      <%--<%--%>
        <%--CatDao catDao = new CatDao();--%>
        <%--ArrayList<Category> categories = catDao.getCatList();--%>

        <%--for(Category category : categories){--%>

      <%--%>--%>

        <%--<li class="category" id=<%=category.getCid()%>>--%>
          <%--<div class="zz"><%=category.getcName()%><div/>--%>
            <%--<li/>--%>
        <%--<%--%>
          <%--}--%>
      <%--%>--%>
    <%--</ul>--%>





<%--</div>--%>

<%--</div>--%>

<%--<div class="content" id="books" >--%>
  <%--<p>zzz</p>--%>

<%--</div>--%>



</body>
</html>