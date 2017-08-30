<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Single User</title>
    <spring:url value="/static/css/app.css" var="css" />
    <link href="${css}" rel="stylesheet" />
</head>
<body>
<h1>${user.name}</h1>
<h2>Messages</h2>
<ul>
<c:forEach items="${user.messages}" var="message">
    <li>${message.value}</li>
</c:forEach>
</ul>
</body>
</html>
