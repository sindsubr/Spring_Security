<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
<title>Welcome</title>
</head>
<body>
	<h1>Welcome to our Company</h1>
	<h2>Welcome <security:authentication property="principal.username"/></h2>
	<security:authorize access="hasRole('ROLE_ADMIN')">
	<a href="">Admin</a></security:authorize>
	
	
	<form:form action="${pageContext.request.contextPath}/logout">
		<button type="submit">Logout</button>
	</form:form>
</body>
</html>