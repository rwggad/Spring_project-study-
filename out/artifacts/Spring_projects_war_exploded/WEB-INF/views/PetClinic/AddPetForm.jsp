<%--
  Created by IntelliJ IDEA.
  User: rwgga
  Date: 2018-12-18
  Time: 오후 4:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ include file="/WEB-INF/include/include-header.jspf" %>
</head>
<body class="bg-light">
<nav class="navbar navbar-expand-lg navbar-dark bg-dark sticky-top">
    <a class="navbar-brand" href="${cp}/PetClinic/HomeForm">Home</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav nav-pills mr-auto">
            <a class="nav-item nav-link active" href="${cp}/PetClinic/FindForm">FIND OWNERS</a>
            <a class="nav-item nav-link" href="#">VETERINARIANS</a>
            <a class="nav-item nav-link" href="#">ERROR</a>
        </ul>
    </div>
</nav>
<br>
<div class="container">
    <div>
        <p>
        <h4>Owner</h4>
        </p>
        <form:form action="${cp}/PetClinic/AddPet/${owner.id}" method="post" commandName="pet">
            <table class="table" style="margin-left: 10%; width: 80%">
                <tbody>
                <!-- Pet의 Owner 정보 -->
                <tr>
                    <td style="width: 20%;">Owner</td>
                    <td style="width: 80%;">
                        ${owner.firstName} ${owner.lastName}
                    </td>
                </tr>
                <!-- Pet 이름 -->
                <tr>
                    <div class="form-group" style="margin-left: 10%">
                        <td style="width: 20%;">Name</td>
                        <td style="width: 80%;">
                            <form:input path="name" cssStyle="width: 100%;"/>
                        </td>
                    </div>
                </tr>
                <!-- Pet 이름 -->
                <tr>
                    <div class="form-group" style="margin-left: 10%">
                        <td style="width: 20%;">Birth Date</td>
                        <td style="width: 80%;">
                            <form:input path="birthDay" cssStyle="width: 100%;" placeholder="YYYY-MM-DD"/>
                        </td>
                    </div>
                </tr>
                <!-- Pet 타입 -->
                <tr>
                    <div class="form-group" style="margin-left: 10%">
                        <td style="width: 20%;">Type</td>
                        <td style="width: 80%;">
                            <select name="types" multiple="false">
                                <c:forEach items="${petTypes}" var="type">
                                    <option value="${type.id}">${type.name}</option>
                                </c:forEach>
                            </select>
                            <%--<form:select path="petType" multiple="false">
                                <c:forEach items="${petTypes}" var="type">
                                    <form:option value="${type}" label="${type.name}"/>
                                </c:forEach>
                            </form:select>--%>
                        </td>
                    </div>
                </tr>
                </tbody>
            </table>
            <div class="form-group" style="float: right; margin-right: 10%">
                <input class="btn btn-dark" type="submit" value="Add Pet">
            </div>
        </form:form>
    </div>
</div>
<br>
<br>
</body>
</html>
