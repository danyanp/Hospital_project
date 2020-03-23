<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sddn
  Date: 2020/2/22
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>全部用户</title>
</head>
<body>
    <h1>全部用户</h1>
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
            <c:forEach var="user" items="${list}">
                <tr>
                    <th>${user.id}</th>
                    <th>${user.username}</th>
                    <th>${user.password}</th>
                    <th>${user.sex}</th>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
