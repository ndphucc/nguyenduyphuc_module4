<%--
  Created by IntelliJ IDEA.
  User: ntamq
  Date: 7/14/2022
  Time: 11:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table cellpadding="10px">
    <tr>
        <th>Languages</th>
        <td>${email.language}</td>
    </tr>
    <tr>
        <th>Page size</th>
        <td>${email.pageSize}</td>
    </tr>
    <tr>
        <th>Spam filter</th>
        <td>${email.spamsFilter}</td>
    </tr>
    <tr>
        <th>Signature</th>
        <td>${email.signature}</td>
    </tr>
    <tr>
        <td><a href="/home">
            <button>back to home</button>
        </a></td>
    </tr>

</table>
</body>
</html>
