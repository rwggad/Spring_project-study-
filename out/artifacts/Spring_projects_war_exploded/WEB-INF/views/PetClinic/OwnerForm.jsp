<%--
  Created by IntelliJ IDEA.
  User: rwgga
  Date: 2018-12-18
  Time: 오후 4:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
            integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
            integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
            crossorigin="anonymous"></script>
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
                    <td>${Owner.firstName} ${Owner.lastName}</td>
                </tr>
                <tr>
                    <td>Address</td>
                    <td>${Owner.address}</td>
                </tr>
                <tr>
                    <td>City</td>
                    <td>${Owner.city}</td>
                </tr>
                <tr>
                    <td>Telephone</td>
                    <td>${Owner.phoneNUmber}</td>
                </tr>
                </tbody>
            </table>
            <br>
            <div>
                <a class="btn btn-dark" href="#">Edit Owner</a>
                <a class="btn btn-dark" href="#">Add New pet</a>
            </div>
            <br>
            <div>
                <table class="table">
                    <tbody>
                    <c:forEach items="${Owner.pets}" var="pet">
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
