<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: phamn
  Date: 02/09/2025
  Time: 8:22 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>updateProduct</title>
</head>
<body>
<h3>Form Update Product</h3>
<form:form modelAttribute="productUpdateDto" enctype="multipart/form-data" method="post" action="/product/update">
    <form:input path="id" style = "hidden"/>

    <form:label path="productname">productname</form:label>
    <form:input path="productname" />
    <form:errors path="productname"/><br>

    <form:label path="price">price</form:label>
    <form:input path="price" />
    <form:errors path="price"/><br>

    <form:label path="stock">stock</form:label>
    <form:input path="stock" />
    <form:errors path="stock"/><br>

    <form:label path="image">image</form:label>
    <input type="file" id="image" name="image"><br>

    <label for="status"> Status</label>
    <input type="radio" name="status" value="true"/><label>True</label>
    <input type="radio" name="status" value="false"/><label>False</label>

    <img src="${productUpdateDto.oldUrl}" alt="${productUpdateDto.productname}">
    <form:hidden path="oldUrl"/>

    <input type="submit" value="Update">

</form:form>
</body>
</html>
