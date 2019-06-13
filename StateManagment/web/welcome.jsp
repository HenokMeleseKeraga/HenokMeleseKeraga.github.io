<%--
  Created by IntelliJ IDEA.
  User: Henok Melese
  Date: 6/12/2019
  Time: 7:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<fieldset style="width: 600px; margin: auto;">
    <p>
        Welcome,
        <%=session.getAttribute("username")%>
        ! You have successfully logged in. Thank you. &nbsp; &nbsp;

    </p>

    <form action="logout" method="get">
        <input type="submit" value="Logout">
    </form>
    <%if(session.getAttribute("msg")!=null){out.print(session.getAttribute("msg"));}%>

</fieldset>
</body>
</html>
