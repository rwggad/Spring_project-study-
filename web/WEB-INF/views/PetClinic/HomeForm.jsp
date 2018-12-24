<%--
  Created by IntelliJ IDEA.
  User: rwgga
  Date: 2018-12-18
  Time: 오후 4:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ include file="/WEB-INF/include/include-header.jspf" %>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark sticky-top">
    <a class="navbar-brand" href="${cp}/PetClinic/HomeForm">Home</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav nav-pills mr-auto">
        <a class="nav-item nav-link" href="${cp}/PetClinic/FindForm">FIND OWNERS</a>
        <a class="nav-item nav-link" href="#">VETERINARIANS</a>
        <a class="nav-item nav-link" href="#">ERROR</a>
    </ul>
    </div>
</nav>
<br>
<div class="container">
    <div class="jumbotron">
        <h1>WelCome</h1>
        <p class="font-weight-light">SeverTime : ${serverTime}</p>
        <c:if test="${!empty memberSession}">
            <p>현재 접속 회원 : ${memberSession.memId}</p>
        </c:if>
        <br>
    </div>

    <div style="float: right;">
        <button class="btn btn-success" onclick="location.href='${cp}/'">GO MAIN</button>
    </div>
</div>

</body>
</html>
