<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Blaze
  Date: 23/01/2024
  Time: 03:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Form</title>
  <link rel="stylesheet" href="style.css">
</head>
<body>

<div align="center">
  <h2>Login</h2>
  <s:form action="LoginAction" class="LoginForm">
    <s:textfield name="username" label="User Name" class="formTextField"/>
    <s:password name="password" label="Password" class="formTextField"/>
    <s:submit value="Login" class="actionBtn"/>
  </s:form>
</div>

</body>
</html>
