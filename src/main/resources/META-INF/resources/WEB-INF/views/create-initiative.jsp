<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Добавить инициативу</title>
</head>
<body>
<c:if test="${addInitiativeSuccess}">
    <div> Инициатива успешно добавлена : ${savedInitiative.title}</div>
</c:if>
<c:url var="add_initiative_url" value="/api/initiatives/create"/>
<form:form action="${add_initiative_url}" method="post" modelAttribute="initiative">
    <form:label path="title">Название инициативы: </form:label> <form:input type="text" path="title"/>
    <form:label path="description">Описание: </form:label> <form:input path="description"/>
    <input type="submit" value="submit"/>
</form:form>
</body>
</html>