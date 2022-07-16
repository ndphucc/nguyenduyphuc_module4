<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ntamq
  Date: 7/14/2022
  Time: 10:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="email" method="post" action="/update">
    <table cellpadding="10px">
        <tr>
            <td></td>
        </tr>
        <tr>
            <th>Languages</th>
            <td colspan="2"><form:select path="language" items="${languages}"/>
        </tr>
        <tr>
            <th>Page size</th>
            <td colspan="2">show <form:select path="pageSize">
                <form:options items="${pageSizes}"/>
            </form:select>
            emails per page
            </td>
        </tr>
        <tr>
            <th>Spams filter</th>
            <td colspan="2"><form:checkbox path="spamsFilter"/> Enable spams filter</td>
        </tr>
        <tr>
            <th>Signature</th>
            <td colspan="2"><form:textarea path="signature"/></td>
        </tr>
        <tr>
            <td></td>
            <td><form:button>Update</form:button></td>
            <td><form:button>Cancel</form:button></td>
        </tr>
    </table>
</form:form>
</body>
</html>
