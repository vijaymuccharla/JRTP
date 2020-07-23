<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<body>

	<!-- Navigation Block -->
	<div class="bloc l-bloc" id="nav-bloc" align="center">
		<div class="container">
			<nav class="navbar row">
				<div class="navbar-header">
					<h1 style="color: white">Legit Programmers</h1>
					<hr />
				</div>

			</nav>
		</div>
	</div>

</body>

<meta charset="ISO-8859-1">
<title>Login</title>
</head>

<style>
table, tr, th, td {
	boder: 2px;
	border-collapse: collapse;
	background-color: grey;
	padding: 10px;
	text-align: center;
}
</style>


<body background="images/img3.jpg">
	<div align="right">
		<h5 style="color: red">${loginFailed }</h5>
		<form:form action="userLogin" modelAttribute="loginModel"
			method="POST">

			<table>
				<thead>
					<tr>
						<th colspan="2">Login to your account</th>
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
						<td colspan="2"><input type="submit" value="Sign-in" /></td>
					</tr>
					<tr>
						<td>Don't have an account? <a href="addUser"><b>Signup
									here.</b></a></td>
						<td>Forgot password? <a href="resetPassword"><b><i>Reset.</i></b></a></td>
					</tr>
				</tbody>
			</table>

		</form:form>

	</div>
</body>
<hr />
<!-- Site footer -->
<footer>
	<p><h5 style="color:white">Copyright &copy; 2020 All Rights Reserved by <b>Legit Programmers</b></h5></p>

</footer>
</html>