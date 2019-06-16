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

<%--    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">--%>
<%--    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>--%>
<%--    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>--%>
</head>
<body>

<div id="firstrow">
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

</div> <!--firstrow end-->

<!--second row -->
<div id="secondrow">
    <div class="left" role="listbox">

        <div class="right">

            <h1 class="">Fairfield Pizza </h1>

            <div class="list-group">
                <div>
                    <a href="/cart" class="">Home</a>
                </div>
                <div>
                    <a href="shopping-cart" class=""> View Order
                        <span>
                        <i class="shopping-cart"></i>
                        <span id="num-of-items" class="badge badge-primary badge-pill">${numItems}</span>
                    </span>
                    </a>
                </div>




            </div>
        </div>

<%--        <div class="carousel-inner" role="listbox">--%>
<%--            <div class="carousel-item active">--%>
<%--                <img class="d-block img-fluid" src="<c:url value="resources/images/bnnr1.jpg" />" alt="First slide">--%>
<%--            </div>--%>
<%--            <div class="carousel-item">--%>
<%--                <img class="d-block img-fluid" src="<c:url value="resources/images/bnnr2.jpg" />" alt="Second slide">--%>
<%--            </div>--%>
<%--            <div class="carousel-item">--%>
<%--                <img class="d-block img-fluid" src="<c:url value="resources/images/bnnr3.jpg" />" alt="Third slide">--%>
<%--            </div>--%>


<%--        </div>--%>


    </div>


</div><!--secondrow end-->

</body>