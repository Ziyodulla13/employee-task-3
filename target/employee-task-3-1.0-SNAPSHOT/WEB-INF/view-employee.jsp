<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 19.09.2022
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Employee list</title>
</head>
<body>
<a href="/employee/get-form">Add new employee</a>
<c:forEach items="${employee}" var="employee" varStatus="loop">
    <h1>${employee.fullName}</h1>
    <p>${employee.positionName}</p>
    <p>${employee.departmentName}</p>
    <a href="/employee/edit/${employee.id}">Edit</a>
    <a href="/employee/delete/${employee.id}">Delete</a>

</c:forEach>
</body>
</html>
