<%@ taglib prefix="Form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: phamn
  Date: 30/08/2025
  Time: 10:51 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>login</title>
  </head>
  <body>
  <h3>Trang Login</h3>
  <Form:form modelAttribute="userloginDto" method="post" action="/user/login" enctype="multipart/form-data">
    <form:label path="username">User name:</form:label>
    <form:input path="username"/>
    <form:errors path="username" cssClass="errors"/>

    <form:label path="password">User password:</form:label>
    <form:input path="password"/>
    <form:errors path="password" cssClass="errors"/>


    <input type="submit" value="login"/>
  </Form:form>
  </body>
</html>
