<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: phamn
  Date: 26/08/2025
  Time: 8:56 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<h2>Login</h2>
<form:form action="/auth/login" modelAttribute="userLogin" method="post">
    <form:label path="username">Username</form:label>
    <form:input path="username"/>
    <form:errors path="username" cssClass="error"/>

    <form:label path="password">password</form:label>
    <form:input path="password"/>
    <form:errors path="password" cssClass="error"/>

    <input type="submit" value="login">
</form:form>
</body>
</html>
