<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin</title>
</head>
<body>
<h1>Welcome Admin <br></h1>
 Username:<security:authentication property="principal.username"/>
<br><br>
<a href="${pageContext.request.contextPath}/">back</a>
</body>
</html>