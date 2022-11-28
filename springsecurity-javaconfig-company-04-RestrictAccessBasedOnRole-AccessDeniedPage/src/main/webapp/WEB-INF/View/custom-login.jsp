<%@page isELIgnored = "false" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Form</title>
<style type="text/css">
.error{
color:red;
}
</style>
</head>
<body>

<h1>Login Form</h1>
	<form:form
		action="${pageContext.request.contextPath}/authenticateTheUser"
		method="POST">
		
		<c:if test = "${param.error!=null }">
		<i class="error"> Bad Credentials</i>
		</c:if>
		
<table>
<tr><th>
UserName:</th><td>
 <input type="text" id="username" name="username" />
		<br>
		<br></td></tr>
		<tr><th>
Password: </th><td><input type="text" id="password" name="password" />
		<br>
		<br></td></tr>
		<tr><td></td><td>
		<button type="submit" name="submit" value="submit">Submit</button>
		</td></tr>
		</table>
	</form:form>

</body>
</html>