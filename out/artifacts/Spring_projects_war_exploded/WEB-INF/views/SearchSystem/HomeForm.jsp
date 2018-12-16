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
    <h1>Search Word Home</h1>
    <p class="font-weight-light">SeverTime : ${serverTime}</p>
    <c:if test="${!empty memberSession}">
        <p>현재 접속 회원 : ${memberSession.memId}</p>
    </c:if>
    <br>
</div>


<div class="container">
    <button class="btn btn-primary" onclick="location.href='${cp}/SearchSystem/InsertForm'">Insert</button>
    <button class="btn btn-primary" onclick="location.href='${cp}/SearchSystem/DeleteForm'">Delete</button>
    <hr>
    <div class="container">
        <table class="table table-bordered">
            <tr>
                <td>
                    <div>
                        <div >
                            <form:form action="${cp}/SearchSystem/Search" method="post" commandName="wordSet">
                                <form:input class="btn btn-outline-secondary" path="wordKey" placeholder="검색할 단어를 입력하세요"/>
                                <input class="btn btn-Info" type="submit" value="Search">
                            </form:form>
                        </div>
                        <%--
                        <div>
                            <form:form action="${cp}/SearchSystem/AllSearch" method="post" commandName="wordSet">
                                <input type="submit" value="All">
                            </form:form>
                        </div>--%>
                    </div>
                    <hr>
                    <div style="margin-left: 30px; margin-right: 30px">
                        <c:choose>
                            <c:when test="${empty wordList}"> <!-- 단어가 없을때 때 -->
                                <div>정의된 단어가 없습니다!</div>
                            </c:when>
                            <c:otherwise> <!-- 단어가 있을 때 -->
                                <c:forEach items="${wordList}" var="word">
                                    <div style="font-size: 25px; font-weight: bold;">
                                            ${word.wordKey}</div>
                                    <div style="font-size: 15px;">
                                            ${word.wordValue}</div>
                                    <div style="font-size: 10px; float: right;">
                                        작성자 : ${word.insertUser}</div>
                                </c:forEach>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </td>
            </tr>
        </table>
    </div>
    <div style="float: right;">
        <button class="btn btn-success" onclick="location.href='${cp}/'">GO MAIN</button>
    </div>
</div>

<br>
</body>
</html>