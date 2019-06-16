
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Footer -->
<footer class="">
    <div class="">
        <p class="">Copyright &copy; Fairfield Pizza 2019</p>
    </div>
    <!-- /.container -->
</footer>

<script src="<c:url value="resources/js/jquery.min.js" />"></script>
<script src="<c:url value="resources/js/script.js"/>"></script>

<c:if test="${pageContext.request.servletPath.contains(\"shopping-cart\")}">
    <script src="<c:url value="resources/js/shopping-cart.js"/>"></script>
</c:if>

<c:if test="${pageContext.request.servletPath.contains(\"checkout\")}">
    <script src="<c:url value="resources/js/checkout.js"/>"></script>
</c:if>
</body>

</html>