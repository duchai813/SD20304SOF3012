<%--
  Created by IntelliJ IDEA.
  User: haiba
  Date: 11/17/2025
  Time: 5:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Nhan Vien</title>
</head>
<body>
<h2>Update Nhan Vien</h2>
<form action="/nhan-vien/update" method="post">
    ID:
    <input type="text" name="id" value="${nv.id}" readonly><br>
    Ten:
    <input type="text" name="tenNhanvien" value="${nv.tenNhanvien}"><br>
    Tuoi:
    <input type="text" name="tuoi" value="${nv.tuoi}"><br>
    GioiTinh:Nam<input type="radio" name="gioiTinh" value="true" ${nv.gioiTinh ?"checked" : ""}>
    Nu<input type="radio" name="gioiTinh" value="false" ${!nv.gioiTinh ?  "checked" : ""}><br>
    Ten Cong Ty:
    <select name="idCongty">
        <c:forEach items="${listCongty}" var="ct">
            <option value="${ct.id}" label="${ct.tenCongty}"></option>
        </c:forEach>
    </select>
    <br>
    <button type="submit">Button</button>
</form>



</body>
</html>
