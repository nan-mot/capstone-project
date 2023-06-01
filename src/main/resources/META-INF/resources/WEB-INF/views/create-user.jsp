<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Create new user</title>
</head>
<body>
<c:if test="${addUserSuccess}">
    <div> User created successfully : ${savedUser.fullName}</div>
</c:if>
<c:url var="add_user_url" value="/createUser"/>
<form:form action="${add_user_url}" method="post" modelAttribute="user">
    <form:label path="fullName">User full name: </form:label> <form:input type="text" path="fullName"/>
    <form:label path="userName">UserName: </form:label> <form:input path="userName"/>
    <select name="districtId">
        <c:forEach items="${districts}" var="district">
            <option value="${district.id}">${district.title}</option>
        </c:forEach>
    </select>
    <input type="submit" value="submit"/>
</form:form>
</body>
</html>