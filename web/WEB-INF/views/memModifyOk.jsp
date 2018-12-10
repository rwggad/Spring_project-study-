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
	<h1> memModifyOk </h1>
	
	<h3> memBef </h3>
	ID : ${memBef.memId} <br />
	PW : ${memBef.memPw} <br />
	Mail : ${memBef.memMail} <br />
	PHONE1 : ${memBef.memPhones[0].memPhone1} - ${memBef.memPhones[0].memPhone2} - ${memBef.memPhones[0].memPhone3} <br />
	PHONE2 : ${memBef.memPhones[1].memPhone1} - ${memBef.memPhones[1].memPhone2} - ${memBef.memPhones[1].memPhone3} <br />
	AGE : ${memBef.memAge} <br />
	ADULT : ${memBef.memAdult} <br />
	GENDER : ${memBef.memGender} <br />
	FAVORITE SPORT : 
	<c:forEach var="fSport" items="${memBef.memFSports}">
		${fSport}, 
	</c:forEach> <br />
	
	<h3> memAft </h3>
	ID : ${memAft.memId} <br />
	PW : ${memAft.memPw} <br />
	Mail : ${memAft.memMail} <br />
	PHONE1 : ${memAft.memPhones[0].memPhone1} - ${memAft.memPhones[0].memPhone2} - ${memAft.memPhones[0].memPhone3} <br />
	PHONE2 : ${memAft.memPhones[1].memPhone1} - ${memAft.memPhones[1].memPhone2} - ${memAft.memPhones[1].memPhone3} <br />
	AGE : ${memAft.memAge} <br />
	ADULT : ${memAft.memAdult} <br />
	GENDER : ${memAft.memGender} <br />
	FAVORITE SPORT : 
	<c:forEach var="fSport" items="${memAft.memFSports}">
		${fSport}, 
	</c:forEach> <br />
	
	<P>  The time on the server is ${serverTime}. </P>
	
	<a href="/lec19/resources/html/index.html"> Go Main </a>
</body>
</html>
