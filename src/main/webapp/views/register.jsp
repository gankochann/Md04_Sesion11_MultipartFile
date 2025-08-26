<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: phamn
  Date: 26/08/2025
  Time: 12:59 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
</head>
<body>
<h2>Register</h2>
<form:form action="/auth/register" method="post" modelAttribute="userDto" enctype="multipart/form-data">

    <form:label path="username">UserName</form:label>
    <form:input path="username"/>
    <form:errors path="username" cssClass="error"/>

    <form:label path="password">password</form:label>
    <form:input path="password"/>
    <form:errors path="password" cssClass="error"/>

    <form:label path="email">email</form:label>
    <form:input path="email"/>
    <form:errors path="email" cssClass="error"/>

    <form:label path="image">image</form:label>
    <form:input path="image"/>
    <form:errors path="image" cssClass="error"/>

    <input type="submit" value="Register">
</form:form>
</body>
</html>
