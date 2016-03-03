$(document).ready(function() {
	$('.my-popup').editable({
		error : function(response, newValue) {
			return errors[lang][response.responseText];
		}
	});
})