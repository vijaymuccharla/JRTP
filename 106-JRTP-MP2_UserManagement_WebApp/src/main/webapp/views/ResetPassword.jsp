<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forgot Password</title>
</head>
<body>

	<div align="center">
		<form:form action="resetPassword" modelAttribute="PwdModel" method="POST">
			<table>
				<caption>Password Recovery</caption>
				<thead>
					<tr>
						<th>Enter registered email address</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><form:input type="text" path="registeredEmail"></form:input></td>
					</tr>
					<tr>
						<td><input type="submit" value="Send password"/></td>
					</tr>
				</tbody>
			</table>
		</form:form>
	</div>
</body>
</html>