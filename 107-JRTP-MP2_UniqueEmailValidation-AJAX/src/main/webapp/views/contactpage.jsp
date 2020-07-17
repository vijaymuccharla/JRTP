<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Unique Email</title>
</head>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
	
</script>

<script>
	$(document).ready(function(e) {
		$("#contactEmail").blur(function(event) {
			$("#dupEmail").html("");
			var emailId = $("#contactEmail").val();
			$.ajax({
				url : 'validateEmail?email=' + emailId,
				success : function(emailExists) {
					if (emailExists == "duplicate") {
						$("#dupEmail").html("Email already registered");
						$("#contactEmail").focus();
					}
				}
			});
		});
	});
</script>

<!-- $.ajax({
    type : 'GET',
    url  : 'validateEmail',
    data  : {
        'email' : $('#emailId').val( );   
    },
   
    success : funcation(data){ 

    }
}); -->

<body>
	<div align="center">
		<h2 style="color: red">${failedMsg }</h2>
		<h2 style="color: green">${savedMsg }</h2>
		<form:form action="saveContact" method="POST" modelAttribute="contact">
			<table>
				<tr>
					<th colspan="2">
						<h2>Contact</h2>
					</th>
				</tr>
				<tr>
					<th>Name</th>
					<th><form:input path="contactName" /></th>
				</tr>
				<tr>
					<th>Email</th>
					<th><form:input path="contactEmail" /> <font color='red'>
							<div id="dupEmail"></div>
					</font></th>
				</tr>
				<tr>
					<th>Number</th>
					<th><form:input path="contactNumber" /></th>
				</tr>
				<tr>
					<th><input type="reset" value="Clear" /></th>
					<th><input type="submit" value="Save" /></th>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>