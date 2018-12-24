<%--
  Created by IntelliJ IDEA.
  User: rwgga
  Date: 2018-12-09
  Time: 오후 4:46
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
