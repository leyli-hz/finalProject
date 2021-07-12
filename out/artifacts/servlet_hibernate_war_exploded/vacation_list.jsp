<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 6/7/2021
  Time: 9:24 AM
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
<c:choose>
    <c:when test="${empty vacationList}">
        <h1 align="center" style="color: #8c8c8c"> .هنوز هیچ درخواستی ثبت نشده است</h1>
    </c:when>
    <c:otherwise>
        <div class="container">
            <h2 style="text-align: right">
                لیست درخواست های ثبت شده
            </h2>

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


                </tr>
                </thead>
                <tbody>
                    <%--<%List<Vacation> vacations = (List<Vacation>) session.getAttribute("vacationList") ; %>
                    <% for (Vacation vacation : vacations) {%>--%>
                <c:forEach var="vacation" items="${vacationList}">
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
                            <%--<td><%=vacation.getVacationId()%></td>
                               <td><%=vacation.getStartDate()%></td>
                               <td><%=vacation.getEndDate()%></td>
                               <td><%=vacation.getStartTime()%></td>
                               <td><%=vacation.getEndTime()%></td>
                               <td><%=vacation.getExpression()%></td>
                               <td><%=vacation.getEmployee().getFirstName()%></td>--%>


                            <%--<%Iterator<CategoryElement> elementIterator = vacation.getCategoryElements().iterator();%>
                                 <td><%= elementIterator.next().getFarsiName() %>/<%= elementIterator.next().getFarsiName() %></td>
                             <%}%>--%>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>
    </c:otherwise>
</c:choose>
</body>
</html>
