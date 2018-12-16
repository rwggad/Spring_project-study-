<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <h1>Board Home</h1>
    <p class="font-weight-light">SeverTime : ${serverTime}</p>
    <c:if test="${!empty memberSession}">
        <p>현재 접속 회원 : ${memberSession.memId}</p>
    </c:if>
    <br>
</div>

<div class="container">
    <button class="btn btn-primary" onclick="location.href='${cp}/BoardSystem/InsertForm'">Insert</button>
    <button class="btn btn-primary" onclick="location.href='${cp}/BoardSystem/DeleteForm'">Delete</button>
    <hr>
    <div class="container">
        <c:choose>
            <c:when test="${empty boardList}">
                <div>
                    작성된 게시물이 존재 하지 않습니다.
                </div>
            </c:when>
            <c:otherwise>
                <c:forEach items="${boardList}" var="board">
                    <div>
                        <div>
                            제목 : ${board.boardTitle}
                        </div>
                        <div>
                            작성자 :${board.boardWriter}
                        </div>
                        <div>
                            날짜 : ${board.boardDate}
                        </div>
                        <div>
                                ${board.boardContent}
                        </div>
                    </div>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </div>
    <div style="float: right;">
        <button class="btn btn-success" onclick="location.href='${cp}/'">GO MAIN</button>
    </div>
</div>
</div>

</body>
</html>
