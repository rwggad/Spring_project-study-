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
</head>
<body>
<h2>Search Word Home</h2>
<h6>SeverTime : ${serverTime}</h6>
<div>
    <button onclick="location.href='${cp}/BoardSystem/InsertForm'">Insert</button> &nbsp; &nbsp;
    <button onclick="location.href='${cp}/BoardSystem/DeleteForm'">Delete</button> &nbsp; &nbsp;
</div>
<br>
<hr/>
<div>
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

</body>
</html>
