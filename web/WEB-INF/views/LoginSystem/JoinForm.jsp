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
    <link rel="stylesheet" type="text/css" href="/WEB-INF/resources/css/normal.css" />
</head>

<tbody>
    <h2>Join</h2>
    <h6>SeverTime : ${serverTime}</h6>
    <form:form action="${cp}/LoginSystem/Join" method="post" commandName="member">
        <table>
            <tr>
                <td>ID</td>
                <td><form:input path="memId"/></td>
            </tr>
            <tr>
                <td>PW</td>
                <td><form:password path="memPw"/></td>
            </tr>
            <tr>
                <td>MAIL</td>
                <td><form:input path="memMail"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="JOIN" >
                </td>
            </tr>
        </table>
    </form:form>

    <a href="${cp}/"> GO MAIN </a>
</tbody>
</html>
