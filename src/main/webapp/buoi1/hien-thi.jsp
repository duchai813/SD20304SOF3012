<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 11/6/2025
  Time: 1:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Them sinh vien:
    <form action="/buoi1/them" method="post">
        Ten: <input type="text" name="ten"> <br>
        Tuoi: <input type="text" name="tuoi"> <br>
        Gioi tinh: Nam <input type="radio" value="true" name="gioiTinh">
                   Nu <input type="radio" value="false" name="gioiTinh">
        <br>
        <button>Submit</button>
    </form>
    Bang thong tin
    <table>
        <thead>
            <tr>
                <th>Id</th>
                <th>Ten</th>
                <th>Tuoi</th>
                <th>Gioi tinh</th>
                <th>Hanh dong</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${listSinhVien}" var="sv">
                <tr>
                    <td>${sv.id}</td>
                    <td>${sv.ten}</td>
                    <td>${sv.tuoi}</td>
                    <td>${sv.gioiTinh ? "Nam" : "Nu"}</td>
                    <td>
                        <a href="/buoi1/view-update?id=${sv.id}">View update</a>
                        <a href="/buoi1/xoa?id=${sv.id}">Xoa</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
