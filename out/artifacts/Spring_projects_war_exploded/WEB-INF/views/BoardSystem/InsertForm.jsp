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
    <h1>Insert Board</h1>
    <p class="font-weight-light">SeverTime : ${serverTime}</p>
    <br>
</div>

<div class="container">
    <form id="frm">
        <input type="hidden" id="boardWriter" name="boardWriter" value="${tryMember.memId}"/>
        <input type="hidden" id="boardDate" name="boardDate" value="${serverTime}"/>
        <div>
            <input type="text" class="btn btn-outline-secondary" id="boardTitle" name="boardTitle"
                  style="width: 100%;" placeholder="제목"/>
        </div>
        <br>
        <div>
            <input type="textarea" class="btn btn-outline-secondary" id="boardContent" name="boardContent"
                   style="width: 100%; height: 350px;"  placeholder="내용"/>
        </div>
        <br>
        <hr>
        <div style="float: left;">
            <a class="btn btn-primary" href="#this" id="write">WRITE</a>
        </div>
        <div style="float:right;">
            <a class="btn btn-primary" href="#this" id="list">BACK</a>
        </div>
    </form>
    <%@ include file="/WEB-INF/include/include-body.jspf" %>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#list").on("click", function (e) {
                e.preventDefault();
                fn_openBoardList();
            });

            $("#write").on("click", function (e) {
                e.preventDefault();
                fn_insertBoard();
            })
        });
        function fn_openBoardList() {
            var comSubmit = new ComSubmit();
            comSubmit.setUrl("<c:url value="/BoardSystem/HomeForm"/>")
            comSubmit.submit();
        }
        function fn_insertBoard() {
            var comSubmit = new ComSubmit("frm");
            comSubmit.setUrl("<c:url value="/BoardSystem/Insert"/>");
            comSubmit.submit();
        }
    </script>
</div>
<br>
<br>
</tbody>
</html>
