<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 11/6/2025
  Time: 1:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Sua san pham:
    <form action="/buoi2/sua" method="post">
        Id: <input type="text" name="id" value="${sanPham.id}"> <br>
        Ten San Pham: <input type="text" name="ten" value="${sanPham.ten_sp}"> <br>
        So Luong: <input type="text" name="tuoi" value="${sanPham.so_luong}"> <br>
      Tinh trang: Con Hang <input type="radio" value="true" name="tinhTrang" ${sanPham.tinh_trang? "checked" : ""}>
        Het Hang <input type="radio" value="false" name="gioiTinh" ${!sanPham.tinh_trang ? "checked" : ""}>
        <br>
        <button>Submit</button>
    </form>
</body>
</html>
