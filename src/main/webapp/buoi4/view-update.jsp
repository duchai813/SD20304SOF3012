<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Update Giảng Viên</title>
</head>
<body>
<h2>Update giảng viên:</h2>

<form action="/giang-vien/update" method="post">
    ID:
    <input type="text" name="id" value="${giangVien.id}" readonly><br>

    Tên:
    <input type="text" name="ten_giang_vien" value="${giangVien.ten_giang_vien}" required><br>

    Tuổi:
    <input type="number" name="tuoi" value="${giangVien.tuoi}" required><br>

    Giới tính:
    Nam <input type="radio" name="gioi_tinh" value="true" ${giangVien.gioi_tinh ? 'checked' : ''}>
    Nữ <input type="radio" name="gioi_tinh" value="false" ${!giangVien.gioi_tinh ? 'checked' : ''}>
    <br>

    Tên trường:
    <select name="truong_id" required>
        <option value="">-- Chọn trường --</option>
        <c:forEach items="${listTruongHoc}" var="th">
            <option value="${th.id}"
                ${giangVien.truongHoc.id == th.id ? 'selected' : ''}>
                    ${th.ten_truong}
            </option>
        </c:forEach>
    </select>

    <br>
    <button type="submit">Submit</button>
</form>

</body>
</html>
