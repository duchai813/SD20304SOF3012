<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quản lý Giảng Viên</title>
</head>
<body>
<h2>Thêm Giảng Viên</h2>

<form action="/giang-vien/add" method="post">
    Tên:
    <input type="text" name="ten_giang_vien" required> <br>

    Tuổi:
    <input type="number" name="tuoi" min="18" max="100" required> <br>

    Giới tính:
    Nam <input type="radio" name="gioi_tinh" value="true" checked>
    Nữ <input type="radio" name="gioi_tinh" value="false">
    <br>

    Tên trường:
    <select name="id_truong" required>
        <option value="">-- Chọn trường --</option>
        <c:forEach items="${listTruongHoc}" var="th">
            <option value="${th.id}"
                ${giangVien.truongHoc.id == th.id ? 'selected' : ''}>
                    ${th.ten_truong}
            </option>
        </c:forEach>
    </select>
    <button type="submit">Submit</button>
</form>

<hr>

<h2>Danh Sách Giảng Viên</h2>
<table border="1" cellpadding="5" cellspacing="0">
    <thead>
    <tr>
        <th>ID</th>
        <th>Tên Giảng Viên</th>
        <th>Tuổi</th>
        <th>Giới Tính</th>
        <th>Tên Trường</th>
        <th>Hành Động</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listGiangVien}" var="gv">
        <tr>
            <td>${gv.id}</td>
            <td>${gv.ten_giang_vien}</td>
            <td>${gv.tuoi}</td>
            <td><c:out value="${gv.gioi_tinh ? 'Nam' : 'Nữ'}"/></td>
            <td>${gv.truongHoc.ten_truong}</td>
            <td>
                <a href="/giang-vien/xoa?id=${gv.id}">Xóa</a> |
                <a href="/giang-vien/view-update?id=${gv.id}">Sửa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
