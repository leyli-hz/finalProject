<%@ page import="java.sql.Timestamp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 5/27/2021
  Time: 11:03 AM
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
<nav class="navbar navbar-inverse">
    <div class="container-fluid">

        <ul class="nav navbar-nav">
            <li href="#">
                <a href="/index.jsp">خانه</a>
            </li>
        </ul>
    </div>
</nav>


<h2 align="center" style=""></h2>
<form action="/email/save.do" method="post" enctype="multipart/form-data">

    <div class="form-group" align="right">
        <label for="subject" style="margin-right :8px"> عنوان</label>
        <input type="text" class="form-control" name="subject" id="subject">
    </div>

    <div class="form-group" align="right">
        <label for="content" style=" margin-right :8px"> متن پیام</label>
        <input type="text" class="form-control " name="content" id="content">
    </div>

    <div class="form-group" align="right">
        <label for="senderId" style="margin-right :8px"> شناسه فرستنده</label>
        <input type="text" class="form-control" name="senderId" id="senderId">
    </div>

    <div class="form-group" align="right">
        <label for="uploadFile" style=" margin-right :8px"> فایل مورد نظر خود را ضمیمه کنید</label>
        <input type="file" class="form-control " name="uploadFile" id="uploadFile">
    </div>


    <div class="form-group" align="right">
        <label for="receiverEmployee" style=" margin-right :8px">گیرنده ی پیام را مشخص کنید </label>
        <select multiple class="form-control" name="receiverEmployee" id="receiverEmployee">
            <c:forEach var="employee" items="${sessionScope.employeeList}">
                <option value="${employee.employeeId}"
                        style="margin-right: 8px">${employee.firstName} ${employee.lastName}</option>
            </c:forEach>
        </select>
    </div>


    <button type="submit" class="btn btn-primary " name="submit">ارسال پیام</button>

    <a href="/email_controller.jsp" class="btn btn-danger "  role="button"> لغو پیام </a>
</form>


</body>
</html>
