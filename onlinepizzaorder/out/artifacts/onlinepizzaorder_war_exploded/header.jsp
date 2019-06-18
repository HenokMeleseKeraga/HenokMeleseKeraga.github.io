<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Fairfield Pizza</title>
    <!-- Custom styles for this template -->
    <link href="<c:url value="resources/css/style.css" />" rel="stylesheet">
    <link rel="stylesheet" href="<c:url value="resources/css/bootstrap.css" />">


</head>
<body>

<div id="firstrow" class="row">
    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom fixed-top shadow-sm p-lg-1 mb-lg-3">
        <div class="left">
            <a class="navbar-brand" href="#">Fairfield Pizza</a>
            <a class="navbar-brand" href="#">About</a>
            <a class="navbar-brand" href="#">Contact</a>
            <div class="right" id="navbarResponsive">
                <ul class="navbar-nav ml-auto">
                    <c:if test="${email == null}">
                        <li class="nav-item active">
                            <a class="nav-link" href="login">Login</a>
                        </li>
                        <li class="nav-item active">
                            <a class="nav-link" href="register">Register</a>
                        </li>
                    </c:if>
                    <c:if test="${email != null}">
                        <li class="nav-item active">
                            <a class="nav-link" href="profile">Profile</a>
                        </li>
                        <li class="nav-item active">
                            <a class="nav-link" href="logout">Logout</a>
                        </li>
                    </c:if>
                </ul>
            </div>
        </div>

    </nav>


<%--</div> <!--firstrow end-->--%>
<%--<!--second row -->--%>
<%--<div id="secondrow" class="row">--%>
<%--    <div class="left" role="listbox">--%>

<%--        <div class="right">--%>

            <h1 class="title">Fairfield Pizza </h1>

<%--            <div class="list-group" class="left">--%>
                <div class=""id="home">
                    <a href="product-list" >Home</a>
                </div>
                <div class="btn btn-info btn-lg">
                    <span class="glyphicon glyphicon-shopping-cart"></span>
                    <a href="shopping-cart" > View Order
                        <span>
<%--                        <i class="shopping-cart"></i>--%>
                        <span id="num-of-items" class="badge badge-primary badge-pill">${numItems}</span>
                    </span>
                    </a>
                </div>


<%--            </div>--%>
<%--        </div>--%>


<%--    </div>--%>


</div><!--secondrow end-->




<%--</body>--%>