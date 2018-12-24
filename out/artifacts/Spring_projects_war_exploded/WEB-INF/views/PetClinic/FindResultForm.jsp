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
<body>
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
        <h4>Owners</h4>
        </p>
        <div>
            <table class="table table-hover table-striped">
                <thead class="table-dark">
                <tr>
                    <td>Name</td>
                    <td>Address</td>
                    <td>City</td>
                    <td>Telephone</td>
                    <td>Pets</td>
                </tr>
                </thead>
                <tbody>
                <c:choose>
                    <c:when test="${empty selections}">
                        <tr>
                            <td colspan="5">Empty Owners..</td>
                        </tr>
                    </c:when>
                    <c:otherwise>
                        <c:forEach items="${selections}" var="owner">
                            <tr>
                                <td>
                                    <a href="${cp}/PetClinic/OwnerDetail/${owner.id}">${owner.firstName} ${owner.lastName}</a>
                                </td>
                                <td>${owner.address}</td>
                                <td>${owner.city}</td>
                                <td>${owner.phoneNUmber}</td>
                                <td>${owner.pets.get(0).name}</td>
                            </tr>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
                </tbody>
            </table>
        </div>
    </div>
</div>
<br>
<br>
</body>
</html>
