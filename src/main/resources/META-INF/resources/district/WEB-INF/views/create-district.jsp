<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Create new district</title>
</head>
<body>
<c:if test="${addSDistrictSuccess}">
    <div> The district created successfully : ${savedDistrict.name}</div>
</c:if>
<c:url var="add_district_url" value="/district"/>
<form:form action="${add_district_url}" method="post" modelAttribute="district">
    <form:label path="title">District title: </form:label> <form:input type="text" path="title"/>
    <input type="submit" value="submit"/>
</form:form>
</body>
</html>