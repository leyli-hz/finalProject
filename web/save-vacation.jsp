<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 6/2/2021
  Time: 5:54 PM
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


<div class="container">
    <table class="table table-responsive">
        <form class="form-control" action="/vacation/save.do">
            <thead>
            <tr>
                <th>
                    <div align="center">
                        <label for="startDate">از تاریخ</label>
                    </div>
                </th>
                <th>
                    <div align="center">
                        <label for="endDate">تا تاریخ</label>
                    </div>
                </th>
                <th>
                    <div align="center">
                        <label for="startTime">از ساعت</label>
                    </div>
                </th>
                <th>
                    <div align="center">
                        <label for="endTime">تا ساعت</label>
                    </div>
                </th>
                <th>
                    <div align="center">
                        <label for="employeeNationalCode">کدملی کارمند</label>
                    </div>
                </th>
                <th>
                    <div align="center">
                        <label for="vacationType">نوع مرخصی</label>
                    </div>
                </th>
                <th>
                    <div align="center">
                        <label for="expression">توضیحات</label>
                    </div>
                </th>
            </tr>
            </thead>
            <tbody>
            <tr>

                <td>
                    <div class="form-group">
                        <input id="startDate" type="date" name="startDate" class="form-control">
                    </div>
                </td>
                <td>
                    <div class="form-group">
                        <input id="endDate" type="date" name="endDate" class="form-control">
                    </div>
                </td>
                <td>
                    <div class="form-group">
                        <input id="startTime" type="time" pattern="HH:MM:SS" name="startTime" class="form-control">
                    </div>
                </td>
                <td>
                    <div class="form-group">
                        <input id="endTime" type="time" name="endTime" class="form-control">
                    </div>
                </td>
                <td>
                    <div class="form-group">
                        <input id="employeeNationalCode" type="text" name="employeeNationalCode" class="form-control">
                    </div>
                </td>

                <td>
                    <div class="form-group">
                        <select class="form-control" name="vacationType" id="vacationType">
                            <c:forEach var="vacationTypeCtg" items="${sessionScope.vacationTypeCtgElm}">
                                <option value="${vacationTypeCtg.categoryElementId}">${vacationTypeCtg.farsiName}</option>
                            </c:forEach>
                        </select>
                    </div>
                </td>

                <td>
                    <div class="form-group">
                        <textarea id="expression" name="expression" rows="3" class="form-control"></textarea>
                    </div>
                </td>
                <td>
                    <button type="submit" class="btn btn-primary" name="submit">ارسال درخواست</button>
                    <a href="/vacation_controller.jsp" class="btn btn-danger " role="button"> لغو درخواست </a>
                </td>

            </tr>
            </tbody>
            <c:forEach var="vacationStatusCtgElm" items="${sessionScope.vacationStatusCtgElms}">
                <c:if test="${vacationStatusCtgElm.farsiName.equals('در انتظار')}">
                    <input type="hidden"  name="vacationStatus" value="${vacationStatusCtgElm.categoryElementId}">
                </c:if>
            </c:forEach>
        </form>
    </table>

</div>
</body>
</html>
