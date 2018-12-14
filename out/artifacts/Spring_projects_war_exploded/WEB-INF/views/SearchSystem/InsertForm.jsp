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
    <h2>Insert Word</h2>
    <h6>SeverTime : ${serverTime}</h6>
    <div>
        <form:form action="${cp}/SearchSystem/Insert" method="post" commandName="wordSet">
            <table>
                <tr>
                    <td>Word</td>
                    <td><form:input path="wordKey"/></td>
                </tr>
                <tr>
                    <td>Content</td>
                    <td><form:input path="wordValue"/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Insert" >
                    </td>
                </tr>
            </table>
        </form:form>
    </div>
    <a href="${cp}/SearchSystem/HomeForm"> BACK </a>
</tbody>
</html>
