<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"></jsp:include>

<div class="row">

    <c:forEach items="${products}" var="product">

        <div class="mainbody">
            <div class="">
                <a href="product?id=${product.id}">
                    <img class="" src="<c:url value="resources/images/${product.image}" />" alt="">
                </a>
                <div class="">
                    <h4 class="">
                    <a class="" href="product?id=${product.id}"> ${product.name}</a>
                   </h4>
                    <p class="card-text">${product.shortDescription}</p>
                    <p class="card-text"> $ ${product.price}</p>
                </div>
                <div class="">
                    <a href="shopping-cart?productId=${product.id}" class="btn btn-danger bt active addToCart" role="button"
                       aria-pressed="true">Add order</a>
                </div>
            </div>
        </div>
    </c:forEach>

</div>


<jsp:include page="footer.jsp"></jsp:include>
