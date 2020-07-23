<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>

<!-- date picker -->
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<!-- <script>
	$(function() {
		$("#dob").datepicker({
			altFormat : "mm-dd-yy",
			changeYear : true,
			changeMonth : true,
			dateFormat : "mm-dd-yy",
			yearRange : '1940:2030'
		});
	});
</script> -->

</head>


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


<style>
table, tr, th, td {
	boder: 2px;
	border-collapse: collapse;
	background-color: darkgrey;
	padding: 10px;
	text-align: center;
}
</style>
<style>
body{
  background: url(images/img1.jpg);
  background-repeat: no-repeat;
  background-size:  1800px;
}

</style>

	<body background="images/img2.jpg">
	<div align="center" >
		<form:form action="addUser" modelAttribute="userModel" method="POST"
			name="userForm">
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
					<tr>
						<td colspan="2">Already have an account? <a href="userLogin"><i>Login.</i></a></td>
					</tr>
				</tbody>
			</table>
		</form:form>
	</div>
</body>
</html>