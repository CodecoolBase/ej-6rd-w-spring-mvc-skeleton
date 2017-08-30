<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>All Users</title>
    <spring:url value="/static/css/app.css" var="css" />
    <link href="${css}" rel="stylesheet" />
</head>
<body>
<h1>All Users</h1>
<ul>
<c:forEach items="${users}" var="user">
    <li><a href="users/<c:out value="${user.id}"/>">${user.name}</a></li>
</c:forEach>
</ul>
</body>
</html>
