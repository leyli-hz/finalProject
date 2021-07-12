<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 5/25/2021
  Time: 7:53 PM
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
            <li >
                <a href="/index.jsp">خانه</a>
            </li>
            <%-- <li>
                 <a href="/employeeAccess.jsp"></a>
             </li>--%>
        </ul>
    </div>
</nav>


<form action="../employee/update.do">
    <div class="form-group" align="right">
        <label for="employeeFname" style="margin-right :8px">: شناسه کاربر</label>
        <input type="text"  class="form-control" name="employeeId" value="<c:out value="${employee.employeeId}"/>" id="employeeId"readonly>
    </div>
    <div class="form-group" align="right">
        <label for="employeeFname" style="margin-right :8px">: نام</label>
        <input type="text" class="form-control" name="employeeFname" value="<c:out value="${employee.firstName}"/>" id="employeeFname">
    </div>
    <div class="form-group" align="right">
        <label for="employeeLname" style="margin-right :8px">: نام خانوادگی</label>
        <input type="text" class="form-control" name="employeeLname" value="<c:out value="${employee.lastName}"/>" id="employeeLname">
    </div>
    <div class="form-group" align="right">
        <label for="nationalCode" style="margin-right :8px">: کدملی</label>
        <input type="text" class="form-control" name="nationalCode"value="<c:out value="${employee.nationalCode}"/>" id="nationalCode">
    </div>

    <div class="form-group" align="right">
        <label for="managerId"style="margin-right :8px">: شناسه ی مدیر</label>
        <input type="text" class="form-control" name="managerId"value="<c:out value="${employee.manager.employeeId}"/>" id="managerId">
    </div>

    <div class="form-group" align="right">
        <label for="roleId" style="margin-right :8px"> : سمت رسمی</label>
        <select class="form-control" name="roleId" id="roleId">
            <c:forEach var="categoryElement" items="${sessionScope.roleTypeCtgElm}">
                <option>${categoryElement.farsiName}</option>
            </c:forEach>
        </select>
    </div>
    <button type="submit" class="btn btn-default"  name="submit">تایید</button>
</form>
</body>
</html>
