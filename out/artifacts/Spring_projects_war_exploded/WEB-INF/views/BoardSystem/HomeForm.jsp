<%--
  Created by IntelliJ IDEA.
  User: rwgga
  Date: 2018-12-16
  Time: 오후 3:23
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
    <h1>Board Home</h1>
    <p class="font-weight-light">SeverTime : ${serverTime}</p>
    <c:if test="${!empty memberSession}">
        <p>현재 접속 회원 : ${memberSession.memId}</p>
    </c:if>
    <br>
</div>

<div class="container">
    <button class="btn btn-primary" onclick="location.href='${cp}/BoardSystem/InsertForm'">Insert</button>
    <hr>
    <div class="container">
        <c:choose>
            <c:when test="${empty list}">
                <div>
                    작성된 게시물이 존재 하지 않습니다.
                </div>
            </c:when>
            <c:otherwise>
                <c:forEach items="${list}" var="board">
                    <div class="jumbotron">
                        <div>제목 : ${board.BOARDTITLE}</div> <br>
                        <div>작성자 :${board.BOARDWRITER}</div> <br>
                        <div>날짜 : ${board.BOARDDATE}</div>
                        <hr>
                        <div>${board.BOARDCONTENT}</div>
                        <hr><%--
                        <div style="float: right;">
                            <c:if test="${board.boardWriter.equals(memberSession.memId)}">
                                <form:form action="${cp}/BoardSystem/Delete" method="post" commandName="board">
                                    <form:hidden path="boardId" value="${board.boardId}"/>
                                    <form:hidden path="boardWriter" value="${board.boardWriter}"/>
                                    <form:hidden path="boardTitle" value="${board.boardTitle}"/>
                                    <form:hidden path="boardContent" value="${board.boardContent}"/>
                                    <form:hidden path="boardDate" value="${board.boardDate}"/>
                                    <form:hidden path="boardCnt" value="${board.boardCnt}"/>
                                    <form:hidden path="ipAddress" value="${board.ipAddress}"/>
                                    <input class="btn btn-danger" type="submit" value="Delete">
                                </form:form>
                            </c:if>
                        </div>--%>
                    </div>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </div>
    <div style="float: right;">
        <button class="btn btn-success" onclick="location.href='${cp}/'">GO MAIN</button>
    </div>
</div>
<br>
<br>

</body>
</html>
