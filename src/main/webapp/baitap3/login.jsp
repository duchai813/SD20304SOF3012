<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: haiba
  Date: 29/11/2025
  Time: 1:10 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Đăng nhập</title>
</head>
<body>
<h2>Đăng nhập</h2>
<form action="/login" method="post">

  Tên đăng nhập: <input type="text" name="username" required><br><br>
  Mật khẩu: <input type="password" name="password" required><br><br>
  <input type="submit" value="Đăng nhập">
</form>
<c:if test="${not empty error}">
  <p style="color:red">${error}</p>
</c:if>
</body>
</html>
