<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body {
	font-family: Helvetica;
	-webkit-font-smoothing: antialiased;
	background: fuchsia;
}
</style>
<link rel="stylesheet" href="css/style.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"></script>
<script src="./js/form-validation.js"></script>
</head>
<!-- <script type="text/javascript">
	//Wait for the DOM to be ready
	$(function() {
		// Initialize form validation on the registration form.
		// It has the name attribute "registration"
		$("form[name='12']").validate({
			// Specify validation rules
			rules : {
				// The key name on the left side is the name attribute
				// of an input field. Validation rules are defined
				// on the right side
				contactName : "required",
				contactPhNo : "required",
				contactEmail : {
					required : true,
					// Specify that email should be validated
					// by the built-in "email" rule
					email : true
				},

			},
			// Specify validation error messages
			messages : {
				contactName : "Please enter your contactname",
				contactPhNo : "Please enter your contactnumber",

				contactEmail : "Please enter a valid email address"
			},
			// Make sure the form is submitted to the destination defined
			// in the "action" attribute of the form when valid
			submitHandler : function(form) {
				form.submit();
			}
		});
	});
</script> -->

<body>
	<h1 style="color: blue; text-align: center;">SaveContact</h1>
	<div class="container">
		<form:form action="savecontact" modelAttribute="contact"
			name="registration" method="post">
			<form:hidden path="contactId" />

			<label for="ContactName">ContactName</label>
			<form:input path="contactName" />
			<label for="contactEmail">Email</label>
			<form:input path="contactEmail" />
			<label for="contactPhNo">contactNumber</label>
			<form:input type="number" path="contactPhNo" />
			<button type="submit">save</button>
			<button type="reset">reset</button>
		</form:form>
	</div>


	<p style="color: blue; text-align: center; font-size: 20px">${succmssg}</p>
	<p style="color: red; text-align: center; font-size: 20px">${failedmssg}</p>
	<p style="color: blue; text-align: center; font-size: 20px">${updatesuccmssg}</p>
	<p style="color: red; text-align: center; font-size: 20px">${updatefailedmssg}</p>
	<a href="viewallcontacts"
		style="color: maroon; font-size: 30px; font-style: italic;">viewallcontacts</a>
</body>
</html>