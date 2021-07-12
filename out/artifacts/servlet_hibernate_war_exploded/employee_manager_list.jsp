<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 5/24/2021
  Time: 6:12 PM
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

<div class="container">
    <h2 style="text-align: right">
        لیست کارمندان و مدیران
    </h2>

    <table class="table table-hover">
        <thead>
        <tr>
            <th>شناسه</th>
            <th>نام</th>
            <th>نام خانوادگی</th>
            <th>کد ملی</th>
            <th>سمت</th>
            <th>شناسه مدیر</th>
            <th>حذف/ویرایش</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>id</td>
            <td>John</td>
            <td>Doe</td>
            <td>john@example.com</td>
            <td>john@example.com</td>
            <td>john@example.com</td>
            <td>
                <a href="save_employee_Form.jsp">Edit</a>

                <a href="">Delete</a>
            </td>

        </tr>
            <c:forEach var="email" items="${employeeList}">
                <tr>
                    <td><c:out value="${email.employeeId}" /></td>
                    <td><c:out value="${email.firstName}" /></td>
                    <td><c:out value="${email.lastName}" /></td>
                    <td><c:out value="${email.nationalCode}" /></td>
                    <td><c:out value="${email.categoryElement.farsiName}" /></td>
                    <td>
                       <c:choose>
                           <c:when test="${empty email.manager }">
                               <c:out value="-" />
                           </c:when>
                           <c:otherwise>
                               <c:out value="${email.manager.employeeId}" />
                           </c:otherwise>
                       </c:choose>
                    </td>
                    <td>
                        <a href="/employee/edit.do?employeeId=<c:out value='${email.employeeId}'/>">Edit</a>
                        <a href="/employee/delete.do?employeeId=<c:out value='${email.employeeId}'/>">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="../save_employee_Form.jsp" class="btn btn-info" role="button">افزودن کاربر</a>
</div>

</body>
</html>
