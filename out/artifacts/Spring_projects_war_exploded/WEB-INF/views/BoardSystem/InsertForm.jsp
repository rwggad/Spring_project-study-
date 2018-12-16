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
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${cp}/resources/css/normal.css">
</head>

<tbody>
<h2>Insert Word</h2>
<h6>SeverTime : ${serverTime}</h6>
<div>
    <form:form action="${cp}/BoardSystem/Insert" method="post" commandName="board">
        <form:hidden path="boardWriter" value="${tryMember.memId}"/>
        <form:hidden path="boardDate" value="${serverTime}"/>
        <table>
            <tbody>
            <tr>
                <td>Word</td>
                <td><form:input path="boardTitle"/></td>
            </tr>
            <tr>
                <td>Content</td>
                <td><form:textarea path="boardContent"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Insert">
                </td>
            </tr>
            </tbody>
        </table>
    </form:form>
</div>
<br>
<a href="${cp}/BoardSystem/HomeForm"> BACK </a>
</tbody>
</html>
