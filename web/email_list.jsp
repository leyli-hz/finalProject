<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 5/29/2021
  Time: 4:48 PM
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
    <c:when test="${empty emailList}">
        <h1 align="center" style="color: #8c8c8c"> .هنوز هیچ پیامی ارسال نشده است</h1>
    </c:when>
    <c:otherwise>
        <div class="container">
            <h2 style="text-align: right">
                لیست پیام های ارسال شده
            </h2>

            <table class="table table-hover">
                <thead>
                <tr>
                    <th>شناسه پیام</th>
                    <th>زمان ارسال</th>
                    <th>عنوان پیام</th>
                    <th>متن پیام</th>
                    <th>شناسه فرستنده</th>

                </tr>
                </thead>
                <tbody>
                <c:forEach var="email" items="${emailList}">
                    <tr>
                        <td><c:out value="${email.emailId}"/></td>
                        <td><c:out value="${email.dateTime}"/></td>
                        <td><c:out value="${email.subject}"/></td>
                        <td><c:out value="${email.content}"/></td>
                        <td><c:out value="${email.senderID.employeeId}"/></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>

    </c:otherwise>
</c:choose>

</body>
</html>
