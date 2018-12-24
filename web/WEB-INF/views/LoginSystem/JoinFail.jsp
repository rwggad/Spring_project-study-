<%--
  Created by IntelliJ IDEA.
  User: rwgga
  Date: 2018-12-13
  Time: 오후 4:54
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
    <h1>Join Fail</h1>
    <p class="font-weight-light">SeverTime : ${serverTime}</p>
    <br>
</div>

<div class="container">
    <h6>중복되는 아이디 입니다.</h6>
    <hr>
    <a class="btn btn-primary" href="${cp}/LoginSystem/JoinForm"> BACK </a>
</div>

</body>
</html>

