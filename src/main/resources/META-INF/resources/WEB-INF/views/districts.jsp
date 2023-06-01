<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Districts</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>District</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${districts}" var="district">
                    <tr>
                        <td>${district.title}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <br/>
        <a href='<c:url value="/createDistrict"/>' > Create new district </a>
    </body>
</html>