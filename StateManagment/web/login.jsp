<%--
  Created by IntelliJ IDEA.
  User: Henok Melese
  Date: 6/12/2019
  Time: 2:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Cookie[] cookies=request.getCookies();
    String userName = "",rememberVal="";
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("cookuser")) {
                userName = cookie.getValue();
            }
            if(cookie.getName().equals("cookrem")){
                rememberVal = cookie.getValue();
            }
        }
    }
%>


<fieldset style="width: 600px; margin: auto;">
    <legend>Login</legend>


<form action="<%=request.getContextPath()%>/login" method="post">
    UserName: <input type="text" name="username" value="<%=userName%>"/></br>
    password :<input type="password" name="password" value=""/></br>
    Remember Me: <input type="checkbox" name="remember"
                        value="1"<%= "1".equals(rememberVal) ? "checked": "" %>/> </br>
    <input type="submit"/>
</form>
    <%if(session.getAttribute("msg")!=null){out.print(session.getAttribute("msg"));}%>

</fieldset>
</body>
</html>
