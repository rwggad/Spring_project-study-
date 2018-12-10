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
	<%--<h1> memJoinOk </h1>
	ID : ${memId}<br />
	PW : ${memPw}<br />
	Mail : ${memMail} <br />
	Phone : ${memPhone} <br />--%>

	<!-- 커맨드 객체 활용 했을 때 -->
	<h1> memJoinOk </h1>
	ID : ${mem.memId}<br />
	PW : ${mem.memPw}<br />
	Mail : ${mem.memMail} <br />
	Phone : ${mem.memPhone1} - ${mem.memPhone2} - ${mem.memPhone3} <br />
	
	<a href="/resources/html/memJoin.html"> Go MemberJoin </a>
</body>
</html>


