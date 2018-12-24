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
        <h4>Owners</h4>
        </p>
        <div>
            <table class="table table-hover table-striped">
                <tbody>
                <tr>
                    <td>Name</td>
                    <td>${owner.firstName} ${owner.lastName}</td>
                </tr>
                <tr>
                    <td>Address</td>
                    <td>${owner.address}</td>
                </tr>
                <tr>
                    <td>City</td>
                    <td>${owner.city}</td>
                </tr>
                <tr>
                    <td>Telephone</td>
                    <td>${owner.phoneNUmber}</td>
                </tr>
                </tbody>
            </table>
            <br>
            <div>
                <table>
                    <tbody>
                        <tr>
                            <td>
                                <form:form action="${cp}/PetClinic/EditOwner/${owner.id}" method="post" commandName="owner">
                                    <input class="btn btn-dark" type="submit" value="Edit Owner"/>
                                </form:form>
                            </td>
                            <td>
                                <form:form action="${cp}/PetClinic/AddPetForm/${owner.id}" method="post" commandName="owner">
                                    <input class="btn btn-dark" type="submit" value="Add New pet"/>
                                </form:form>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <br>
            <div>
                <table class="table">
                    <tbody>
                    <c:forEach items="${owner.pets}" var="pet">
                    <tr>
                        <td valign="top">
                            <dl>
                                <dt>Name</dt>
                                <dd>${pet.name}</dd>
                                </dd>
                                <dt>Birth Date</dt>
                                <dd>${pet.birthDay}</dd>
                                </dd>
                                <dt>Type</dt>
                                <dd>${pet.petType.name}</dd>
                                </dd>
                            </dl>
                        </td>
                        <td valign="top">
                            <table class="table">
                                <thead>
                                <tr>
                                    <th>Visit Date</th>
                                    <th>Description</th>
                                </tr>
                                </thead>
                                <tr>
                                    <td><a href="#">Edit Pet</a></td>
                                    <td><a href="#">Add Visit</a></td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<br>
<br>
</body>
</html>
