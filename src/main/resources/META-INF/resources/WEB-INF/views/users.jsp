<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Users</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>Full name</th>
                    <th>Username</th>
                    <th>District</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td>${user.fullName}</td>
                        <td>${user.userName}</td>
                        <td>${user.district}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <br/>
        <a href='<c:url value="/createUser"/>' > Create new user </a>
        <br/>
        <a href='<c:url value="/createExpert"/>' > Create new expert </a>
    </body>
</html>