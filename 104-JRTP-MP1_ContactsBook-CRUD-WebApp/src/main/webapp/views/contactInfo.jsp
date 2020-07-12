<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Phone Book</title>
<link rel="stylesheet" href="css/style.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"></script>
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
<script src="js/form-validations.js"></script>
<body>
	<div align="center">
		<h2 style="color: darkgreen">${savedMsg }</h2>
		<h2 style="color: red">${failedMsg }</h2>
		<h2 style="color: darkgreen">${updateMsg }</h2>
		<h2 style="color: red">${updateFailMsg }</h2>
		<form:form action="loadForm" modelAttribute="contact" method="POST"
			name="contactsForm">
			<table>
				<form:hidden path="contactId" />
				<tr>
					<th colspan="2">Phone Book</th>
				</tr>

				<tr>
					<th>Name :</th>
					<td><form:input path="contactName" /></td>
				</tr>

				<tr>
					<th>Phone Number :</th>
					<td><form:input path="contactNumber" /></td>

				</tr>

				<tr>
					<th>Email Address :</th>
					<td><form:input path="contactEmail" /></td>

				</tr>

				<tr>
					<td><input type="reset" value="Clear" /></td>
					<td><input type="submit" value="Save" /></td>
				</tr>
				<tr>
					<td colspan="2"><h2>
							<a href="displayAllContacts"> View Contacts</a>
						</h2></td>
				</tr>

			</table>
		</form:form>
	</div>
</body>
</html>