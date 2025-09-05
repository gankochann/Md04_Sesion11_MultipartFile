<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h3>Chao mung ban den voi chung toi</h3>
<h4>Vui long an linh duoi day de chuyen sang trang dang ki!</h4>
<a href="<%=request.getContextPath()%>/user/register">REGISTER</a>
<hr>
<h4>Ban da co tai khoan? Vui long an dang nhap!</h4>
<a href="<%=request.getContextPath()%>/user/login">Login</a>
</body>
</html>