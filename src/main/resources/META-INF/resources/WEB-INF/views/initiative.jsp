<head>
    <title>${initiative.title}</title>
</head>
<body>
<div>${initiative.title}</div>
<br/>
<div>${initiative.description}</div>
<br/>
<div>Specialization: ${initiative.specialization}</div>
<br/>
<table>
    <thead>
    <tr>
        <th>Participants of the initiative</th>
        <th>District</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${initiative.participants}" var="user">
        <tr>
            <td>${user.fullName}</td>
            <td>${user.district}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br/>
<a href='<c:url value="/${initiative.title}/addParticipant"/>' > Take part in the initiative </a>
<br/>
<a href='<c:url value="/${initiative.title}/experts"/>' > Generate list of experts </a>
<br/>
</body>
</html>