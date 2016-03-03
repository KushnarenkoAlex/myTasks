$(document).ready(function() {
	$('.addtobucket').click(function(e) {
		e.preventDefault();
		addToBucket($(this).data("product-id"));
		return false;
	});
	function addToBucket(itemCode) {
		$.ajax({
			url : 'bucket',
			type : 'POST',
			data : {
				itemId : itemCode,
				command : 'addToBucket'
			},
			success : function(response) {
				json = JSON.parse(response);
				summ = json.summ;
				$("#quantity").text(summ);
			}
		});
	}

});