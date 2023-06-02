<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Experts</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>Full name</th>
                    <th>Username</th>
                    <th>District</th>
                    <th>Specialization</th>
                    <th>Experience</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${experts}" var="user">
                    <tr>
                        <td>${user.fullName}</td>
                        <td>${user.userName}</td>
                        <td>${user.district}</td>
                        <td>${user.specialization}</td>
                        <td>${user.experience}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>