<%--
  Created by IntelliJ IDEA.
  User: rwgga
  Date: 2018-12-12
  Time: 오후 5:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ include file="/WEB-INF/include/include-header.jspf" %>
</head>

<tbody>
<div class="jumbotron">
    <h1>Delete Word</h1>
    <p class="font-weight-light">SeverTime : ${serverTime}</p>
    <c:if test="${!empty memberSession}">
        <p>현재 접속 회원 : ${memberSession.memId}</p>
    </c:if>
    <br>
</div>

<div class="container">
    <form:form action="${cp}/SearchSystem/Delete" method="post" commandName="wordSet">
        <div><form:input class="btn btn-outline-secondary" path="wordKey" placeholder="삭제할 단어를 입력하세요" /></div> <br>
        <hr/>
        <div style="float:left;">
            <input class="btn btn-primary" type="submit" value="Delete">
            <a class="btn btn-primary" href="${cp}/SearchSystem/HomeForm">BACK</a>
        </div>
    </form:form>
</div>
</tbody>
</html>
