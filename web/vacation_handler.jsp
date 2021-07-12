<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 6/12/2021
  Time: 12:12 AM
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
</head>
<body>
<H3 align="center">مدیریت مرخصی ها </H3>

<h4 align="right"> لطفا جهت مشاهده ی درخواست های زیر مجموعه خود ابتدا شناسه ی مدیریتی خود را وارد کنید </h4>
<form action="/vacation/show.do/controlling">
    <div class="form-group" align="center">
        <input type="text" class="form-control" name="managerId">
    </div>
    <button type="submit" class="btn btn-default">تایید</button>
</form>
<c:if test="${!empty vacations}">
    <%--<div class="container">--%>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>شناسه درخواست</th>
                <th>از تاریخ</th>
                <th>تا تاریخ</th>
                <th>از ساعت</th>
                <th>تا ساعت</th>
                <th>توضیحات</th>
                <th>نام در خواست کننده</th>
                <th>نوع مرخصی</th>
                <th> وضعیت مرخصی</th>
                <th>رد یا تائیید</th>


            </tr>
            </thead>
            <tbody>
            <c:forEach var="vacation" items="${vacations}">
                <tr>
                    <td><c:out value="${vacation.vacationId}"/></td>
                    <td><c:out value="${vacation.startDate}"/></td>
                    <td><c:out value="${vacation.endDate}"/></td>
                    <td><c:out value="${vacation.startTime}"/></td>
                    <td><c:out value="${vacation.endTime}"/></td>
                    <td><c:out value="${vacation.expression}"/></td>
                    <td><c:out value="${vacation.employee.firstName} ${vacation.employee.lastName}"/></td>
                    <c:forEach var="vacationCategory" items="${vacation.categoryElements}">
                        <td><c:out value="${vacationCategory.farsiName}"/></td>
                    </c:forEach>
                    <td>
                        <a href="/vacation/update.do/reject?vacationId=<c:out value='${vacation.vacationId}'/>&vacationStatId=9" class="btn btn-danger" role="button">
                            رد درخواست
                        </a>
                        <a href="/vacation/update.do/accept?vacationId=<c:out value='${vacation.vacationId}'/>&vacationStatId=8" class="btn btn-success" role="button">
                            تایید درخواست
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
<%--
    </div>
--%>
</c:if>
</body>
</html>
