<%--
  Created by IntelliJ IDEA.
  User: rwgga
  Date: 2018-12-10
  Time: 오후 1:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1> memJoinOk </h1>
	
	ID : ${member.memId} <br />
	PW : ${member.memPw} <br />
	Mail : ${member.memMail} <br />
	PHONE1 : ${member.memPhones[0].memPhone1} - ${member.memPhones[0].memPhone2} - ${member.memPhones[0].memPhone3} <br />
	PHONE2 : ${member.memPhones[1].memPhone1} - ${member.memPhones[1].memPhone2} - ${member.memPhones[1].memPhone3} <br />
	AGE : ${member.memAge} <br />
	ADULT : ${member.memAdult} <br />
	GENDER : ${member.memGender} <br />
	FAVORITE SPORT : 
	<c:forEach var="fSport" items="${member.memFSports}">
		${fSport}, 
	</c:forEach> <br />
	
	<P>  The time on the server is ${serverTime}. </P>
	
	<a href="/lec19/resources/html/memJoin.html"> Go MemberJoin </a>
</body>
</html>
