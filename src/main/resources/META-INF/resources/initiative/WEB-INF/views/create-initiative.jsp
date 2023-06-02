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
<c:url var="add_initiative_url" value="/initiative"/>
<form:form action="${add_initiative_url}" method="post" modelAttribute="initiative">
    <form:label path="title">Initiative title: </form:label> <form:input type="text" path="title"/>
    <form:label path="description">Description: </form:label> <form:input path="description"/>
        <br/>
        <br/>
    <p>Select a specialization:</p>
    <select name="specializationId">
        <c:forEach items="${specializations}" var="specialization">
            <option value="${specialization.id}">${specialization.name}</option>
        </c:forEach>
            <br/>
            <br/>
    </select>
    <p>Select a district:</p>
    <select name="districtId">
        <c:forEach items="${districts}" var="district">
            <option value="${district.id}">${district.title}</option>
        </c:forEach>
    </select>
    <input type="submit" value="submit"/>
</form:form>
</body>
</html>