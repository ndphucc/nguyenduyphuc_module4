<%--
  Created by IntelliJ IDEA.
  User: ntamq
  Date: 7/13/2022
  Time: 1:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="get" action="/current">
    <table>
        <tr>
            <td>USD</td>
            <td><input type="text" name="usd" value="${usd}"></td>
        </tr>
        <tr>
            <td>VND</td>
            <td><input type="text" value="${result}"></td>
        </tr>
        <tr>
            <button>Tính</button>
        </tr>
    </table>
</form>

</body>
</html>
