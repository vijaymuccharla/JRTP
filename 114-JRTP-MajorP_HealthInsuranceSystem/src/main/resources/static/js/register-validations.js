$(function() {

	$("form[name='userForm']").validate({
		// Specify validation rules
		rules : {
			/*
			 * The key name on the left side is the name attribute of an input
			 * field. Validation rules are defined on the right side
			 */

			firstName : "required",

			lastName : "required",

			userGender : "required",
			
			userRole : "required"
			userEmail : {
				required : true,
				// Specify that email should be validated
				// by the built-in "email" rule
				email : true
			},

		},
		// Specify validation error messages
		messages : {
			firstName : "* Required.",
			lastName : "* Required field.",
			userGender : "* Please select gender.",
			userEmail : "* Email invalid!",
			userRole : "* Please select a role"
		},
		// Make sure the form is submitted to the destination defined
		// in the "action" attribute of the form when valid
		submitHandler : function(form) {
			form.submit();
		}
	});
});
