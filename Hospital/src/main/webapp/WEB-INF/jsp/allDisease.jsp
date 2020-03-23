<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sddn
  Date: 2020/2/23
  Time: 21:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <table border="1">
    <thead>
    <tr>
        <th>用户ID</th>
        <th>用户名</th>
        <th>用户密码</th>
        <th>性别</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="disease" items="${list}">
        <tr>
            <th>${disease.id}</th>
            <th>${disease.diseaseName}</th>
            <th>${disease.subCategory}</th>
            <th>${disease.category}</th>
        </tr>
    </c:forEach>
    </tbody>
</table>
</head>
<body>

</body>
</html>
