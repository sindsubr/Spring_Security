<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manager</title>
</head>
<body>
<h1>Welcome Team Lead <br></h1>
 Username:<security:authentication property="principal.username"/>
<br><br>
<a href="${pageContext.request.contextPath}/">back</a>
</body>
</html>