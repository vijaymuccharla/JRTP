<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>

<!-- date picker -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>jQuery UI Datepicker - Display month &amp; year menus</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>


</head>
<script>
	$(document).ready(function() {
		$(function() {
			$("#dob").datepicker({
				changeMonth : true,
				changeYear : true
			});
		});
	});

	$(document).ajaxComplete(function() {
		$(function() {
			$("#dob").datepicker({
				changeMonth : true,
				changeYear : true
			});
		});
	});
</script>

<!-- unique email validation -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
	
</script>

<script>
	$(document)
			.ready(
					function(e) {
						$("#userEmail")
								.blur(
										function(event) {
											$("#dupEmail").html("");
											var emailId = $("#userEmail").val();
											$
													.ajax({
														url : 'validateEmail?email='
																+ emailId,
														success : function(
																emailExists) {
															if (emailExists == "duplicate") {
																$("#dupEmail")
																		.html(
																				"* That email is taken. Try another.");
																$("#userEmail")
																		.focus();
															}
														}
													});
										});
					});
</script>



<!-- dropdowns -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="./js/dropdowns.js"></script>

<body>
	<div align="center">
	<h2 style="color: green" >${addedMsg }</h2>
	<h2 style="color: red" >${failedMsg}</h2>
		<form:form action="addUser" modelAttribute="userModel" method="POST">
			<table>
				<thead>
					<tr>
						<th colspan="2"><h2 style="color: darkblue">New User
								Registration</h2></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th>First Name :</th>
						<td><form:input path="firstName" /></td>
					</tr>
					<tr>
						<th>Last Name :</th>
						<td><form:input path="lastName" /></td>
					</tr>
					<tr>
						<th>Email Address :</th>
						<td><form:input path="userEmail" /> <font color='red'>
								<div id="dupEmail"></div>
						</font></td>
					</tr>
					<tr>
						<th>Phone Number :</th>
						<td><form:input path="userPhone" /></td>
					</tr>
					<tr>
						<th>D.O.B. :</th>
						<td><form:input path="userDob" id="dob" /></td>
					</tr>
					<tr>
						<th>Gender :</th>
						<td><form:radiobutton path="userGender" value="M" id="gender" />
							Male &nbsp;<form:radiobutton path="userGender" value="F"
								id="gender" />Female</td>
					</tr>
					<tr>
						<th>Counrty :</th>
						<td><form:select path="countryId">
								<form:option value=""> -select- </form:option>
								<form:options items="${countriesMap }" />
							</form:select></td>
					</tr>
					<tr>
						<th>State :</th>
						<td><form:select path="stateId">
								<form:option value=""> -select- </form:option>
							</form:select></td>
					</tr>
					<tr>
						<th>City :</th>
						<td><form:select path="cityId">
								<form:option value=""> -select- </form:option>
							</form:select></td>
					</tr>
					<tr>
						<td><input type="reset" value="Reset"></td>
						<td><input type="submit" value="Register"></td>
					</tr>
				</tbody>
			</table>
		</form:form>
	</div>
</body>
</html>