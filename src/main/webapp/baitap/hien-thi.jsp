<%--
  Created by IntelliJ IDEA.
  User: haiba
  Date: 11/15/2025
  Time: 1:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Quan Li Nhan Vien</title>
</head>
<body>
<h2>Tim Kiem theo ten</h2>
<form action="/nhan-vien/search" method="get">
    Ten:
    <input type="text" name="tenNhanvien">
    <br>
    <button>Search</button>
</form>
<h2>Them Nhan Vien</h2>
<form action="/nhan-vien/add" method="post">
    Ten:
    <input type="text" name="tenNhanvien"><br>
    Tuoi:
    <input type="text" name="tuoi"><br>
    GioiTinh:Nam<input type="radio" name="gioiTinh" value="true">
    Nu<input type="radio" name="gioiTinh" value="false"><br>
    Ten Cong Ty:
    <select name="idCongty">
        <c:forEach items="${listCongty}" var="ct">
            <option value="${ct.id}" label="${ct.tenCongty}"></option>
        </c:forEach>
    </select>
    <br>
    <button type="submit">Button</button>

</form>
<br>
<h2>Bang Nhan Vien</h2>

    <table border="1" cellpadding="5" cellspacing="0" style="border-collapse: collapse;">
    <thead>
    <tr>
        <th>ID</th>
        <th>Ten Nhan Vien</th>
        <th>Tuoi</th>
        <th>Gioi Tinh</th>
        <th>Hanh Dong</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listNhanvien}" var="nv">
        <tr>
            <td>${nv.id}</td>
            <td>${nv.tenNhanvien}</td>
            <td>${nv.tuoi}</td>
            <td>${nv.gioiTinh==true?"Nam":"Nu"}</td>
            <td>${nv.congTy.tenCongty}</td>
            <td>
                <a href="/nhan-vien/view-update?id=${nv.id}">Update</a>
                <a href="/nhan-vien/delete?id=${nv.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>
<a href="/nhan-vien/paging?pageNumber=${pageNumber - 1}">Previous</a>
<a href="/nhan-vien/paging?pageNumber=${pageNumber + 1}">Next</a>

</body>
</html>
