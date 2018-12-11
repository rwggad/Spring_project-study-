
<%--
  Created by IntelliJ IDEA.
  User: rwgga
  Date: 2018-12-10
  Time: 오후 1:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Insert title here</title>
</head>
<body>

<h1>MAIN</h1>

<c:if test="${empty member}">
    <a href="${cp}/member/joinForm">JOIN</a> &nbsp;&nbsp;
    <a href="${cp}/member/loginForm">LOGIN</a> &nbsp;&nbsp;
</c:if>

<c:if test="${!empty member}">
    <a href="${cp}/member/modifyForm">MODIFY</a> &nbsp;&nbsp;
    <a href="${cp}/member/logout">LOGOUT</a> &nbsp;&nbsp;
    <a href="${cp}/member/removeForm">REMOVE</a> &nbsp;&nbsp;
</c:if>

</body>
</html>