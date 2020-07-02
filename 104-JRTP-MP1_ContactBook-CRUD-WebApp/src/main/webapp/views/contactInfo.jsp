<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contacts Book App</title>
</head>

<style>
table, tr, th, td {
	boder: 2px;
	border-collapse: collapse;
	background-color: lightgreen;
	padding: 10px;
	text-align: center;
}
</style>

<body>
	<div align="center">

		<form:form action="/saveContact" methodParam="contact"  method="POST">
			<table>
				<tr>
					<th colspan="2">Contact Book App</th>
				</tr>

				<tr>
					<td>Name :</td>
					<td><form:input path="contactName" /></td>
				</tr>

				<tr>
					<td>Phone Number :</td>
					<td><form:input path="contactNumber" /></td>
				</tr>

				<tr>
					<td>Email Address :</td>
					<td><form:input path="contactEmail" /></td>
				</tr>

				<tr>
					<td><input type="reset" value="Clear" /></td>
					<td><input type="submit" value="Save" /></td>
				</tr>

			</table>
		</form:form>
	</div>
</body>
</html>