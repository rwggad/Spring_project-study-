<%--
  Created by IntelliJ IDEA.
  User: rwgga
  Date: 2018-12-10
  Time: 오후 1:06
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %> <!-- session을 사용하지 않겠다. -->
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1> MEMBER REMOVE OK </h1>

	ID : ${member.memId}<br />
	
	<P>  The time on the server is ${serverTime}. </P>
	
	<a href="${cp}/"> MAIN </a>
</body>
</html>