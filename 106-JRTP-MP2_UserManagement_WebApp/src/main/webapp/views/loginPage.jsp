<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>

<style>
table, tr, th, td {
	boder: 2px;
	border-collapse: collapse;
	background-color: silver;
	padding: 10px;
	text-align: center;
}
</style>


<body>
	<div align="center">
		<h5 style="color: red">${loginFailed }</h5>
		<form:form action="userLogin" modelAttribute="loginModel"
			method="POST">

			<table>
				<thead>
					<tr>
						<th colspan="2">Legit Programmers Login Page</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th>Email <br /></th>
						<td><form:input path="userEmail" /></td>
					</tr>
					<tr>
						<th>Password</th>
						<td><form:password path="userPassword" /></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="Login" /></td>
					</tr>
					<tr>
						<td colspan="2">Forgot password? <a href="resetPassword"><i>Reset.</i></a></td>
					</tr>
					<tr>
					<td colspan="2">Don't have an account? <a href="addUser">Register here.</a></td>
					</tr>
				</tbody>
			</table>

		</form:form>

	</div>
</body>
</html>