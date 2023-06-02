<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add participant to the initiative</title>
</head>
<body>
<c:url var="add_participant_url" value="/initiative/${initiative.id}/participant"/>
<form:form action="${add_participant_url}" method="post" modelAttribute="participant">
    <p>Select new participant:</p>
    <select name="participantId">
        <c:forEach items="${users}" var="participant">
            <option value="${participant.id}">${participant.fullName}</option>
        </c:forEach>
    </select>
    <input type="submit" value="submit"/>
</form:form>
</body>
</html>