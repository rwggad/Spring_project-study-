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
    <h1>Delete Fail</h1>
    <p class="font-weight-light">SeverTime : ${serverTime}</p>
    <br>
</div>

<div class="container">
    <h6>존재하지 않는 단어 입니다.</h6>
    <hr>
    <a class="btn btn-primary" href="${cp}/SearchSystem/DeleteForm"> BACK </a>
</div>

</body>
</html>
