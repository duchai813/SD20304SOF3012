<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Quản lý sản phẩm</title>
</head>
<body>
<h2>Thêm sản phẩm</h2>
<form action="${pageContext.request.contextPath}/buoi2/hien-thi/them" method="post">
  Tên sản phẩm: <input type="text" name="ten_sp"> <br>
  Số lượng: <input type="number" name="so_luong"> <br>
  Tình trạng:
  <label><input type="radio" value="true" name="tinh_trang"> Còn hàng</label>
  <label><input type="radio" value="false" name="tinh_trang"> Hết hàng</label>
  <br><br>
  <button type="submit">Thêm</button>
</form>

<hr>

<h2>Bảng sản phẩm</h2>
<table border="1" cellspacing="0" cellpadding="5">
  <thead>
  <tr>
    <th>ID</th>
    <th>Tên</th>
    <th>Số lượng</th>
    <th>Tình trạng</th>
    <th>Hành động</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${listSanpham}" var="sp">
    <tr>
      <td>${sp.id}</td>
      <td>${sp.ten_sp}</td>
      <td>${sp.so_luong}</td>
      <td>${sp.tinh_trang ? "Còn hàng" : "Hết hàng"}</td>
      <td>
        <a href="${pageContext.request.contextPath}/buoi2/hien-thi/view-update?id=${sp.id}">Sửa</a>
        |
        <a href="${pageContext.request.contextPath}/buoi2/xoa?id=${sp.id}">Xóa</a>

      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
