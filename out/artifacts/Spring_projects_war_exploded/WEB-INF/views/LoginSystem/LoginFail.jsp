<%--
  Created by IntelliJ IDEA.
  User: rwgga
  Date: 2018-12-12
  Time: 오후 6:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ include file="/WEB-INF/include/include-header.jspf" %>
</head>
<body>
<div class="jumbotron">
    <h1>Login Fial</h1>
    <p class="font-weight-light">SeverTime : ${serverTime}</p>
    <br>
</div>

<div class="container">
    <h6>아이디 또는 비밀번호가 잘못 되었습니다.</h6>
    <hr>
    <a class="btn btn-primary" href="${cp}/LoginSystem/LoginForm"> BACK </a>
</div>

</body>
</html>
