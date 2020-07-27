$(function() {

	$("form[name='PwdResetForm']")
			.validate(
					{
						rules : {
							registeredEmail : {
								required : true,
								email : true
							},
						},
						messages : {
							registeredEmail : "<font style='color:red'>* Invalid email.</font>",
						},
						submitHandler : function(form) {
							form.submit();
						}
					});
});
