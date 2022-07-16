<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ntamq
  Date: 7/16/2022
  Time: 11:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h3 style="display: flex; align-items: center">Danh sách tờ khai</h3>
    <table class="table">
        <tr>
            <th>Họ tên</th>
            <th>Năm sinh</th>
            <th>Cmnd</th>
            <th>Update</th>
        </tr>
        <c:forEach items="${list}" var="item">
        <tr>
            <td>${item.name}</td>
            <td>${item.yearOfDate}</td>
            <td>${item.idCard}</td>
            <td><a href="/update?id=${item.id}">
                <button>update</button>
            </a></td>
        </tr>
        </c:forEach>
    </table>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
