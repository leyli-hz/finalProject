<%@ page import="com.me.model.entity.Category" %><%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 5/22/2021
  Time: 10:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Company Management</title>
    <link rel="stylesheet" href="../assets/bootstrap.min.css">
    <script src="../assets/jquery.min.js"></script>
    <script src="../assets/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">

        <ul class="nav navbar-nav">
            <li >
                <a href="/index.jsp">خانه</a>
            </li>
             <li>
                 <a href="/save_employee_Form.jsp">وارد کردن مشخصات فردی </a>
             </li>
        </ul>
    </div>
</nav>

<c:import url="/category/save.do">
    <c:param name="roleType" value="roleType"/>
</c:import>

<h2 align="right">لطفا انواع سمت ها را تعریف کنید</h2>
<c:set var="categoryObj" value="${requestScope.CategoryObject}"/>
<c:out value="${categoryObj}"/>

<form action="/categoryElement/save.do">
    <div class="form-group">
        <div class="form-group" align="right">
            <label for="farsiName">: لیست سمت ها </label>
            <select class="form-control" name="farsiName" id="farsiName">
                <option>برنامه نویس</option>
                <option>برنامه نویس ارشد</option>
                <option>آزمون کننده</option>
                <option>طراحUI</option>
            </select>
            <br>
            <div align="left">
                <button type="submit" class="btn btn-info" name="submit">انتخاب</button>
            </div>
        </div>
    </div>
</form>


</body>
</html>
