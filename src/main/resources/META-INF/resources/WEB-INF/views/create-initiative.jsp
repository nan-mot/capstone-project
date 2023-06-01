<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Create new initiative</title>
</head>
<body>
<c:if test="${addInitiativeSuccess}">
    <div> The initiative created successfully : ${savedInitiative.title}</div>
</c:if>
<c:url var="add_initiative_url" value="/createInitiative"/>
<form:form action="${add_initiative_url}" method="post" modelAttribute="initiative">
    <form:label path="title">Initiative title: </form:label> <form:input type="text" path="title"/>
    <form:label path="description">Description: </form:label> <form:input path="description"/>
    <form:label path="specialization">Specialization: </form:label> <form:input path="specialization"/>
    <form:label path="district">District: </form:label> <form:input path="district"/>
    <input type="submit" value="submit"/>
</form:form>
</body>
</html>