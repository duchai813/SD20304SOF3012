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
    Sua sinh vien:
    <form action="/buoi1/sua" method="post">
        Id: <input type="text" name="id" value="${sinhVien.id}"> <br>
        Ten: <input type="text" name="ten" value="${sinhVien.ten}"> <br>
        Tuoi: <input type="text" name="tuoi" value="${sinhVien.tuoi}"> <br>
        Gioi tinh: Nam <input type="radio" value="true" name="gioiTinh" ${sinhVien.gioiTinh ? "checked" : ""}>
        Nu <input type="radio" value="false" name="gioiTinh" ${!sinhVien.gioiTinh ? "checked" : ""}>
        <br>
        <button>Submit</button>
    </form>
</body>
</html>
