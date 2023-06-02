<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Initiatives</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>Initiative</th>
                    <th>Description</th>
                    <th>Specialization</th>
                    <th>District</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${initiatives}" var="initiative">
                    <tr>
                        <td>${initiative.title}</td>
                        <td>${initiative.description}</td>
                        <td>${initiative.specialization}</td>
                        <td>${initiative.district}</td>
                        <td><a href='<c:url value="${initiative.id}"/>' > Read more </a> </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <br/>
        <a href='<c:url value="/initiative/create"/>' > Create new initiative </a>
    </body>
</html>