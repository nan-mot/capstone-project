<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>${initiative.title}</title>
</head>
<body>
<div>Title: ${initiative.title}</div>
<br/>
<div>Description: ${initiative.description}</div>
<br/>
<div>Specialization: ${initiative.specialization}</div>
<br/>
<table>
    <thead>
    <tr>
        <th>Participants of the initiative</th>
        <th>District</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${initiative.participants}" var="user">
        <tr>
            <td>${user.fullName}</td>
            <td>${user.district}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br/>
<a href='<c:url value="/initiative/participant/add/${initiative.id}"/>' > Add participants to the initiative </a>
<br/>
<br/>
<a href='<c:url value="/initiative/experts/${initiative.id}"/>' > Generate list of experts </a>
<br/>
<br/>
<a href='<c:url value="/initiative/update/${initiative.id}"/>' >Update </a>
<br/>
<br/>
<a href='<c:url value="/initiative/delete/${initiative.id}"/>' > Delete </a>
</body>
</html>