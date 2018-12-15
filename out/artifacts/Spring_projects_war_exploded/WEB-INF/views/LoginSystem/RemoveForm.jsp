<%--
  Created by IntelliJ IDEA.
  User: rwgga
  Date: 2018-12-12
  Time: 오후 5:48
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${cp}/resources/css/normal.css">
</head>

<tbody>
    <h2>Remove</h2>
    <h6>SeverTime : ${serverTime}</h6>
    <form:form action="${cp}/LoginSystem/Remove" method="post" commandName="member">
        <form:hidden path="memId" value="${removeMember.memId}"/>
        <table>
            <tr>
                <td>ID</td>
                <td>${removeMember.memId}</td>
            </tr>
            <tr>
                <td>PW</td>
                <td><form:password path="memPw"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Remove" >
                </td>
            </tr>
        </table>
    </form:form>

    <a href="${cp}/"> GO MAIN </a>
</tbody>
</html>
