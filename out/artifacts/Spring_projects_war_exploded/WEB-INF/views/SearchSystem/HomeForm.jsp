<%--
  Created by IntelliJ IDEA.
  User: rwgga
  Date: 2018-12-12
  Time: 오후 5:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/WEB-INF/resources/css/normal.css?after"/>
</head>
<body>
<h2>Search Word Home</h2>
<h6>SeverTime : ${serverTime}</h6>
<div>
    <button onclick="location.href='${cp}/SearchSystem/InsertForm'">Insert</button> &nbsp; &nbsp;
    <button onclick="location.href='${cp}/SearchSystem/SearchForm'">Search</button> &nbsp; &nbsp;
    <button onclick="location.href='${cp}/SearchSystem/DeleteForm'">Delete</button> &nbsp; &nbsp;
</div>
<br>
<hr/>
<div>
    <table>
        <thead>
        <tr>
            <td>User</td>
            <td>Key</td>
            <td>Content</td>
        </tr>
        </thead>
        <tbody >
        <c:forEach items="${wordList}" var="word">
            <tr>
                <td>user</td>
                <td>${word.wordKey}</td>
                <td>${word.wordValue}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<br>
<button onclick="location.href='${cp}/'">GO MAIN</button>
</body>
</html>
