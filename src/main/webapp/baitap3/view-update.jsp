<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: haiba
  Date: 03/12/2025
  Time: 8:32 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<h2>Update Phong</h2>
<form action="/phong/update" method="post">
  ID:
  <input type="text" name="id" value="${ph.id}"><br>
  Số phòng:
  <input type="text" name="soPhong" value="${ph.soPhong}"> <br>

  Loại phòng:
  <input type="text" name="loaiPhong" value="${ph.loaiPhong}"> <br>

  Giá phòng:
  <input type="number" name="giaPhong" value="${ph.giaPhong}"> <br>

  Sức chứa:
  <input type="number" name="sucChua" value="${ph.sucChua}"> <br>

  Trạng thái:
  <label><input type="radio" name="trangThai" value="true "${ph.trangThai==true ?"Checked":""}> Còn trống</label>
  <label><input type="radio" name="trangThai" value="false" ${!ph.trangThai==true ?"Checked":""}> Đã thuê</label>
  <br><br>

  Khách sạn:
  <select name="idKhachSan">
    <c:forEach items="${listKhachSan}" var="ks">
      <option value="${ks.id}">${ks.tenKhachsan} ${ph.khachSan.id==hs.id?"Selected":""}</option>
    </c:forEach>
  </select>
  <br><br>

  <button type="submit">Update</button>

</form>
</body>
</html>
