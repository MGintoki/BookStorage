<%@ page import="storage.domain.Category" %>
<%@ page import="storage.dao.CatDao" %>
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
  <title>Title</title>
  <link rel="stylesheet" type="text/css" href="css/demo.css"?v=<%=System.currentTimeMillis()%>>
  <script src="./js/ajax.js"></script>
</head>
<body>

<script language="JavaScript">
    function login() {
        window.location.href='./jsp/login.jsp'

    }

</script>

<div class="container">

  <div class="header" >

    <h1>菜鸟书城</h1>
    欢迎<input type="button" value="登陆" onclick=login()>
  </div>

  <div class="menu">

    <ul>
      <%
        CatDao catDao = new CatDao();
        ArrayList<Category> categories = catDao.getCatList();

        for(Category category : categories){

      %>

        <li class="category" id=<%=category.getCid()%>>
          <div class="zz"><%=category.getcName()%><div/>
            <li/>
        <%
          }
      %>
    </ul>





</div>

</div>

<div class="content" id="books" >
  <p>zzz</p>

</div>



</body>
</html>