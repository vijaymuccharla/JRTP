$(document).ready(
		function(event) {
			$("#countryId").change(
					function() {

						$("#stateId").find('option').remove();
						$('<option>').val('').text('-select-').appendTo(
								"#stateId");

						$("#cityId").find('option').remove();
						$('<option>').val('').text('-select-').appendTo(
								"#cityId");

						var countryId = $("#countryId").val();
						$.ajax({
							type : "GET",
							url : "getAllStates?cntryId=" + countryId,
							success : function(res) {
								$.each(res, function(sttId, sttName) {
									$('<option>').val(sttId).text(sttName)
											.appendTo("#stateId");
								});
							}
						});
					});

			$("#stateId").change(
					function() {

						$("#cityId").find('option').remove();
						$('<option>').val('').text('-select-').appendTo(
								"#cityId");

						var stateId = $("#stateId").val();
						$.ajax({
							type : "GET",
							url : "getAllCities?sttId=" + stateId,
							success : function(data) {
								$.each(data, function(ctyId, ctyName) {
									$('<option>').val(ctyId).text(ctyName)
											.appendTo("#cityId");
								});
							}
						});
					});

		});