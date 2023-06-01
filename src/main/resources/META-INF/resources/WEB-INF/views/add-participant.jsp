<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add participant to the initiative</title>
</head>
<body>
<c:url var="add_participant_url" value="/{initiativeTitle}/addParticipant"/>
<form:form action="${add_participant_url}" method="post" modelAttribute="participant">
    <form:label path="fullName">User full name: </form:label> <form:input type="text" path="fullName"/>
    <input type="submit" value="submit"/>
</form:form>
</body>
</html>