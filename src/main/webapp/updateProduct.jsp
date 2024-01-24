<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Blaze
  Date: 23/01/2024
  Time: 13:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Product</title>
  <link rel="stylesheet" href="style.css">
</head>
<body>

<div align="center">
  <h2>Update Product</h2>
  <s:form action="updateAction" class="formTable">
    <s:textfield name="productId" label="Product Id" class="formTextField" readonly="true"/>
    <s:textfield name="productName" label="Product Name" class="formTextField"/>
    <s:textfield name="productCategory" label="Product Category" class="formTextField"/>
    <s:textfield name="productPrice" label="Product Price" class="formTextField"/>
    <s:submit value="Update Product" class="actionBtn"/>
  </s:form>

</div>

</body>
</html>
