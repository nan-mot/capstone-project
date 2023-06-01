<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Create new user-expert</title>
</head>
<body>
<c:if test="${addExpertSuccess}">
    <div> Expert created successfully : ${savedExpert.fullName}</div>
</c:if>
<c:url var="add_expert_url" value="/createExpert"/>
<form:form action="${add_expert_url}" method="post" modelAttribute="expert">
    <form:label path="fullName">User full name: </form:label> <form:input type="text" path="fullName"/>
    <form:label path="userName">UserName: </form:label> <form:input path="userName"/>
    <form:label path="experience">Experience: </form:label> <form:input path="experience"/>

    <p>Select a specialization:</p>
    <select name="specializationId">
        <c:forEach items="${specializations}" var="specialization">
            <option value="${specialization.id}">${specialization.name}</option>
        </c:forEach>
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