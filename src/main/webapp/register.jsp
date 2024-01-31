<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 2024-01-31
  Time: 4:57 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Registration Form</title>
  <link rel="stylesheet" href="style.css">
</head>
<body>

<div align="center">
  <h2>Registration</h2>
  <s:form action="RegisterAction" class="RegistrationForm">
    <s:textfield name="username" label="User Name" class="formTextField"/>
    <s:password name="password" label="Password" class="formTextField"/>
    <s:textfield name="email" label="Email" class="formTextField"/>
    <s:submit value="Register" class="actionBtn"/>
  </s:form>
</div>

</body>
</html>
