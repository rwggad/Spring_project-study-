<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <h1>Modify Fail</h1>
    <p class="font-weight-light">SeverTime : ${serverTime}</p>
    <br>
</div>

<div class="container">
    <hr>
    <a class="btn btn-primary" href="${cp}/LoginSystem/ModifyForm"> BACK </a>
</div>

</body>
</html>
