<%--
  Created by IntelliJ IDEA.
  User: ntamq
  Date: 7/13/2022
  Time: 3:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/find" method="get">
    <table>
        <tr>
            <td><input type="text" name="english"></td>
            <td>${result}</td>
        </tr>
        <tr>
            <td><button>tìm</button></td>
        </tr>
    </table>
</form>
</body>
</html>
