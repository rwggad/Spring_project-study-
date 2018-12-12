<%--
  Created by IntelliJ IDEA.
  User: rwgga
  Date: 2018-12-10
  Time: 오후 1:06
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="/resources/css/normal.css" />
</head>
<body>
	
	<h1>MEMBER REMOVE</h1>
	<form:form action="${cp}/member/remove" method="post" commandName="member">
		<input type="hidden" name="memId" value="${sessionMember.memId}">
		<table>
			<tr>
				<td>ID</td>
				<td>${sessionMember.memId}</td
			</tr>
			<tr>
				<td>PW</td>
				<td><form:password path="memPw" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Remove" ></td>
			</tr>
		</table>
	</form:form>
	
	<a href="${cp}/">MAIN</a>
</body>
</html>