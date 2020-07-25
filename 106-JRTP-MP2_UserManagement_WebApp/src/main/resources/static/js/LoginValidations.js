$(function() {

	$("form[name='LoginForm']").validate({
		rules : {
			userEmail : {
				required : true,
				email : true
			},
			userPassword : "required",
		},
		messages : {
			userEmail : "* Invalid email.",
			userPassword : "* Password required."
		},
		submitHandler : function(form) {
			form.submit();
		}
	});
});
