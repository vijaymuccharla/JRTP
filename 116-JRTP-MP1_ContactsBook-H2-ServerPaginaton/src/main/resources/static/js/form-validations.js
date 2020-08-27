$(function() {

	$("form[name='contactsForm']").validate({
		// Specify validation rules
		rules : {
			/*
			 * The key name on the left side is the name attribute of an input
			 * field. Validation rules are defined on the right side
			 */

			contactName : "required",

			contactNumber : "required",

			contactEmail : {
				required : true,
				// Specify that email should be validated
				// by the built-in "email" rule
				email : true
			},

		},
		// Specify validation error messages
		messages : {
			contactName : "* Name required!",
			contactNumber : "* Required field!",
			contactEmail : "* Email invalid!"
		},
		// Make sure the form is submitted to the destination defined
		// in the "action" attribute of the form when valid
		submitHandler : function(form) {
			form.submit();
		}
	});
});
