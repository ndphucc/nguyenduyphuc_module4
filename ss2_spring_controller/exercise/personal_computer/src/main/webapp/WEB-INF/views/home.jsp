<%--
  Created by IntelliJ IDEA.
  User: ntamq
  Date: 7/13/2022
  Time: 10:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div>
    <form action="/calculator" method="post">
        <table>
            <tr>
                <td colspan="2"><input type="text" name="numberFirst"></td>
                <td colspan="2"><input type="text" name="numberSecond"></td>
            </tr>
            <tr>
                <td>
                    <button name="calculation" value="+">Addition(+)</button>
                </td>
                <td>
                    <button name="calculation" value="-">Subtraction(-)</button>
                </td>
                <td>
                    <button name="calculation" value="*">Multiplication(X)</button>
                </td>
                <td>
                    <button name="calculation" value="/">Division(/)</button>
                </td>
            </tr>
            <c:if test="${result!=null}">
                <tr>
                    <td>
                        result = ${result}
                    </td>
                </tr>
            </c:if>

        </table>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
