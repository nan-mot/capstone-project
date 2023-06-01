<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Specializations</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>Specialization</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${specializations}" var="specialization">
                    <tr>
                        <td>${specialization.name}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <br/>
        <a href='<c:url value="/specialization/create"/>' > Create new specialization </a>
    </body>
</html>