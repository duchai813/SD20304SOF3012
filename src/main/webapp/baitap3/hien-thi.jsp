<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quản lý Phòng</title>
</head>
<body>
<h2> Tim Kiem</h2>
<form action="/phong/tim-kiem" method="get">
    Giá từ: <input type="number" name="min" value="${min}">
    đến: <input type="number" name="max" value="${max}">
    <button type="submit">Tìm</button>
</form>

<h2>Thêm phòng</h2>
<form action="/phong/add" method="post">

    Tên phòng:
    <input type="text" name="soPhong"> <br>

    Loại phòng:
    <input type="text" name="loaiPhong"> <br>

    Giá phòng:
    <input type="number" name="giaPhong"> <br>

    Sức chứa:
    <input type="number" name="sucChua"> <br>

    Trạng thái:
    <label><input type="radio" name="trangThai" value="true"> Còn trống</label>
    <label><input type="radio" name="trangThai" value="false"> Đã thuê</label>
    <br><br>

    Khách sạn:
    <select name="idKhachSan">
        <c:forEach items="${listKhachSan}" var="ks">
            <option value="${ks.id}">${ks.tenKhachsan}</option>
        </c:forEach>
    </select>
    <br><br>

    <button type="submit">Thêm</button>
</form>


<hr>

<h2>Danh sách phòng</h2>
<table border="1" cellspacing="0" cellpadding="5">
    <thead>
    <tr>
        <th>ID</th>
        <th>Số phòng</th>
        <th>Loại phòng</th>
        <th>Giá phòng</th>
        <th>Sức chứa</th>
        <th>Trạng thái</th>
        <th>Khách sạn</th>
        <th>Hành động</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${listPhong}" var="ph">
        <tr>
            <td>${ph.id}</td>
            <td>${ph.soPhong}</td>
            <td>${ph.loaiPhong}</td>
            <td>${ph.giaPhong}</td>
            <td>${ph.sucChua}</td>
            <td>${ph.trangThai ? "Còn trống" : "Đã thuê"}</td>
            <td>${ph.khachSan.tenKhachsan}</td>
            <td>
                <a href="/phong/view-update?id=${ph.id}">Sửa</a> |
                <a href="/phong/delete?id=${ph.id}" onclick="return confirm('Bạn có chắc muốn xóa phòng ${ph.id}?')">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/phong/phan-trang?pageNumber=${pageNumber-1}">Prev</a>
<a href="/phong/phan-trang?pageNumber=${pageNumber+1}">Next</a>
</body>
</html>
