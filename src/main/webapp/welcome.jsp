<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Blaze
  Date: 23/01/2024
  Time: 03:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
  <div align="center">
    <h2>Welcome</h2>

  </div>

<table width="750" class="productTable" align="center">
    <thead>
    <tr>
        <th>Product ID</th>
        <th>Product Name</th>
        <th>Product Category</th>
        <th>Product Price</th>
        <th colspan="3">Actions</th>
    </tr>
    </thead>

    <s:iterator value="products" var="product">
        <tr align="center">

            <td>
                <s:property value="#product.productId"/>
            </td>
            <td>
                <s:property value="#product.productName"/>
            </td>
            <td>
                <s:property value="#product.productCategory"/>
            </td>
            <td>
                <s:property value="#product.productPrice"/>
            </td>
            <td>
                <a href="addProduct.jsp">
                    <button class="actionBtn">Add New Product</button>
                </a>
            </td>
            <td>
                    <a href="updateDataAction?productId=<s:property value="#product.productId"/>">
                        <button class="actionBtn">Update</button>
                    </a>
            </td>
            <td>
                <a href="deleteAction?productId=<s:property value="#product.productId"/>">
                    <button class="actionBtn">Delete</button>
                </a>
            </td>


        </tr>
    </s:iterator>


</table>

</body>
</html>
