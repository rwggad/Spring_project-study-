<%--
  Created by IntelliJ IDEA.
  User: rwgga
  Date: 2018-12-09
  Time: 오후 4:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>$Title$</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
            integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
            integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="jumbotron">
    <h1>MAIN</h1>
    <p class="font-weight-light">SeverTime : ${serverTime}</p>
    <c:if test="${!empty memberSession}">
        <p>현재 접속 회원 : ${memberSession.memId}</p>
    </c:if>
    <br>
</div>

<div class="container">
    <c:choose>
        <c:when test="${empty memberSession}">
            <!-- 로그인 안했을 때-->
            <button class="btn btn-primary" onclick="location.href='${cp}/LoginSystem/LoginForm'">Login</button>
            &nbsp; &nbsp;
            <button class="btn btn-primary" onclick="location.href='${cp}/LoginSystem/JoinForm'">Join</button>
            &nbsp; &nbsp;
        </c:when>
        <c:otherwise>
            <div>
                <button class="btn btn-primary" onclick="location.href='${cp}/LoginSystem/Logout'">Logout</button> &nbsp;
                <button class="btn btn-primary" onclick="location.href='${cp}/LoginSystem/ModifyForm'">Modify</button>
                &nbsp;
                <button class="btn btn-primary" onclick="location.href='${cp}/LoginSystem/RemoveForm'">Remove</button>
                &nbsp;
            </div>
            <br>
            <hr/>
            <h3>Functions</h3>
            <br>
            <a class="btn btn-light" href="${cp}/SearchSystem/HomeForm">Find Word System</a> <br> <br>
            <a class="btn btn-light" href="${cp}/BoardSystem/HomeForm">Board System</a> <br> <br>
            <a class="btn btn-light" href="${cp}/PetClinic/HomeForm">My PetClinic</a> <br> <br>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>
