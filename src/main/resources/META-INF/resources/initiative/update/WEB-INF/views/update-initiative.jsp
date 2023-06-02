<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Update initiative</title>
</head>
<body>
<c:if test="${updateInitiativeSuccess}">
    <div> Initiative saved : ${updatedInitiative.id}</div>
</c:if>

<c:url var="update_initiative_url" value="/initiative/update"/>
<form:form action="${update_initiative_url}" method="post" modelAttribute="initiative">
    <form:label path="title">Initiative title: </form:label> <form:input type="text" path="title"/>
    <br/>
    <br/>
    <form:label path="description">Description: </form:label> <form:input path="description"/>
    <form:label path="id" > </form:label> <form:input type="text" path="id" style="visibility:hidden;"/>
    <br/>
    <p>Select a specialization: </p>
    <select name="specializationId">
        <c:forEach items="${specializations}" var="specialization">
            <option value="${specialization.id}">${specialization.name}</option>
        </c:forEach>
    </select>
    <p>Select a district: </p>
    <select name="districtId">
        <c:forEach items="${districts}" var="district">
            <option value="${district.id}">${district.title}</option>
        </c:forEach>
    </select>
    <input type="submit" value="submit"/>
</form:form>
</body>
</html>