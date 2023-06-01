<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Create new specialization</title>
</head>
<body>
<c:if test="${addSpecializationSuccess}">
    <div> The specialization created successfully : ${savedSpecialization.name}</div>
</c:if>
<c:url var="add_specialization_url" value="/specialization"/>
<form:form action="${add_specialization_url}" method="post" modelAttribute="specialization">
    <form:label path="name">Specialization title: </form:label> <form:input type="text" path="name"/>
    <input type="submit" value="submit"/>
</form:form>
</body>
</html>