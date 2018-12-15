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
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${cp}/resources/css/normal.css">
</head>
<body>
<h2>Search Word Home</h2>
<h6>SeverTime : ${serverTime}</h6>
<div>
    <button onclick="location.href='${cp}/SearchSystem/InsertForm'">Insert</button> &nbsp; &nbsp;
    <button onclick="location.href='${cp}/SearchSystem/DeleteForm'">Delete</button> &nbsp; &nbsp;
</div>
<br>
<hr/>
<div>
    <table style="text-align: center">
        <tr>
            <td colspan="4">
                검색할 단어를 입력하세요.
            </td>
        </tr>
        <tr>
            <form:form action="${cp}/SearchSystem/Search" method="post" commandName="wordSet">
                <td colspan="2">
                    <form:input path="wordKey"/>
                </td>
                <td>
                    <input type="submit" value="Search">
                </td>
            </form:form>
            <form:form action="${cp}/SearchSystem/AllSearch">
                <td>
                    <input type="submit" value="All">
                </td>
            </form:form>
        </tr>
        <c:choose>
            <c:when test="${empty wordList}"> <!-- 단어가 없을때 때 -->
                <tr>
                    <td colspan="4">
                        정의된 단어가 없습니다!
                    </td>
                </tr>
            </c:when>
            <c:otherwise> <!-- 단어가 있을 때 -->
                <c:forEach items="${wordList}" var="word">
                    <tr>
                        <td colspan="4">
                            <div style="font-size: 25px; font-weight: bold;">
                                    ${word.wordKey}</div>
                            <div style="font-size: 15px;">
                                    ${word.wordValue}</div>
                            <div style="font-size: 10px; float: right;">
                                작성자 : ${word.insertUser}</div>
                        </td>
                    </tr>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </table>
</div>
<br>
<button onclick="location.href='${cp}/'">GO MAIN</button>
</body>
</html>