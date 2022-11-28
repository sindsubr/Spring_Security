<%@ page isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html> 
<head>
<title>company portal access</title>
</head>
<body>
	<h2>Welcome to our Company portal</h2>
	
	
	<form:form action="${pageContext.request.contextPath}/logout">
		<button type="submit">Logout</button>
	</form:form>
</body>
</html>
