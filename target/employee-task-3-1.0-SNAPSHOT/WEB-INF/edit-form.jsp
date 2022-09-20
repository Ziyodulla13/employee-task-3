<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 19.09.2022
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<form action="/employee/edit" method="post">
    <input name="id" type="number" hidden value="${employee.id}">
    <label for="fullName" >Full Name</label>
    <input  type="text" id="fullName" name="fullName" value="${employee.fullName}">
    <br>
    <label for="positionName" >Position Name</label>
    <input  type="text" id="positionName" name="positionName" value="${employee.positionName}">
    <br>
    <label for="departmentName" >Department Name</label>
    <input  type="text" id="departmentName" name="departmentName" value="${employee.departmentName}">
    <br>
    <button type="submit">Save</button>

</form>
</body>
</html>
