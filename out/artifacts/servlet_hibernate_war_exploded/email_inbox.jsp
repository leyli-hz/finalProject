<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 5/30/2021
  Time: 4:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Company Management</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../assets/bootstrap.min.css">
    <script src="../assets/jquery.min.js"></script>
    <script src="../assets/bootstrap.min.js"></script>
</head>
<body>
<form action="/employee/show.do/findOne">
    <div class="form-group" align="center">
        <label for="employeeId"> : شناسه کاربری خود را وارد کنید </label>
        <input type="text" class="form-control"  name="employeeId" id="employeeId">
    </div>
    <div class="form-group"align="center">
        <label for="nationalCode"> : کدملی خود را وارد کنید</label>
        <input type="text" class="form-control" name="nationalCode" id="nationalCode">
    </div>

    <button type="submit" class="btn btn-default">تایید</button>
</form>
</body>
</html>
