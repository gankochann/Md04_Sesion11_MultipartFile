<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: phamn
  Date: 01/09/2025
  Time: 10:01 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>home</title>
</head>
<body>
<h3>List Product</h3>
<form method="get" action="<%=request.getContextPath()%>/product/search">
    <input placeholder="search" name="search">
    <button type="submit">Search</button>
</form>
    <a href="<%=request.getContextPath()%>/product/add">Add Product</a>
<table border="1px">
    <thead>
    <tr>
        <th>Ten</th>
        <th>Gia</th>
        <th>So luong</th>
        <th>Hinh anh</th>
        <th>Trang thai</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listProduct}" var="product">
       <tr>
        <td>${product.id}</td>
        <td>${product.productname}</td>
        <td>${product.stock}</td>
        <td>
            <img src="${product.image}" alt="${product.productname}" style="width: 80px ; height: 40px">
        </td>
        <td>${product.status}</td>
        <td>
            <a href="<%=request.getContextPath()%>/product/update?id=${product.id}">Update</a>
            <a href="<%=request.getContextPath()%>/product/delete?id=${product.id}" onclick="return confirm('ban co chac muon xoa khong?')">Delete</a>
        </td>
       </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
