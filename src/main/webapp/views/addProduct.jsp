<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: phamn
  Date: 02/09/2025
  Time: 8:18 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Product</title>
</head>
<body>
<h3>Form Add Product</h3>
<form:form modelAttribute="productDto" enctype="multipart/form-data" method="post" action="/product/add">
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


    <input type="submit" value="Add">
    
</form:form>

</body>
</html>
