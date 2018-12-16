
<%--
  Created by IntelliJ IDEA.
  User: rwgga
  Date: 2018-12-09
  Time: 오후 4:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  <h2>MAIN!</h2>
  <h6>SeverTime : ${serverTime}</h6>
  <c:if test="${!empty memberSession}">
    <div>
      <table>
        <tr>
          <td>현재 접속 회원 : ${memberSession.memId}</td>
        </tr>
      </table>
      <br>
    </div>
  </c:if>
  <c:choose>
    <c:when test="${empty memberSession}">
      <!-- 로그인 안했을 때-->
      <button onclick="location.href='${cp}/LoginSystem/LoginForm'">Login</button> &nbsp; &nbsp;
      <button onclick="location.href='${cp}/LoginSystem/JoinForm'">Join</button> &nbsp; &nbsp;
    </c:when>
    <c:otherwise>
      <div>
        <button onclick="location.href='${cp}/LoginSystem/Logout'">Logout</button> &nbsp;
        <button onclick="location.href='${cp}/LoginSystem/ModifyForm'">Modify</button> &nbsp;
        <button onclick="location.href='${cp}/LoginSystem/RemoveForm'">Remove</button> &nbsp;
      </div>
      <br>
      <hr/>
      <h3>Functions</h3>
      <br>
      <a href="${cp}/SearchSystem/HomeForm">Find Word System</a>
      <a href="${cp}/BaordSystem/HomeForm">Board System</a>
    </c:otherwise>
  </c:choose>
  </body>
</html>
