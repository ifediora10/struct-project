<%--
  Created by IntelliJ IDEA.
  User: Blaze
  Date: 26/01/2024
  Time: 08:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    if (session.getAttribute("loggedInUser") == null){
        response.sendRedirect("login,jsp");
    }
%>

<div class="topnav">
    <a href="welcomeAction">Home</a>
    <a href="addProduct.jsp">Add Product</a>
    <a href="#contact">Contact</a>
    <a href="logoutAction" style="float: right">Logout</a>
</div>

</body>
</html>
