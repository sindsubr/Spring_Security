<%@ page isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<html> 
<head>
<title>company portal access</title>
</head>
<body>
	<h2>Welcome to our Company portal</h2>
	Hi 
	<security:authentication property = "principal.username"></security:authentication>
	<security:authentication property = "principal.authorities"></security:authentication>
	<br><br>
	
	<security:authorize access="hasRole('manager')">
	<a href="${pageContext.request.contextPath}/showLeader">Manager link</a>
	</security:authorize>
	<security:authorize access="hasRole('admin')">
	<a href="${pageContext.request.contextPath}/showAdmin">admin link</a>
	</security:authorize>
	<br><br>
	<form:form action="${pageContext.request.contextPath}/logout">
		<button type="submit">Logout</button>
	</form:form>
</body>
</html>
