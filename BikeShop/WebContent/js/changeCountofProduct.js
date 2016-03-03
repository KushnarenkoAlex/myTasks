$(document).ready(function() {
	$('.increasequantity').click(function(e) {
		e.preventDefault();
		increaseBucket($(this).data("product-id"));
		return false;
	});
	function increaseBucket(itemCode) {
		$.ajax({
			url : 'bucket',
			type : 'POST',
			data : {
				itemId : itemCode,
				command : 'increaseQuantity'
			},
			success : function(response) {
				json = JSON.parse(response);
				quantity = json.quantity;
				$("#countOf" + itemCode).text(quantity);
			}
		});
	}

	$('.decreasequantity').click(function(e) {
		e.preventDefault();
		decreaseBucket($(this).data("product-id"));
		return false;
	});
	function decreaseBucket(itemCode) {
		$.ajax({
			url : 'bucket',
			type : 'POST',
			data : {
				itemId : itemCode,
				command : 'decreaseQuantity'
			},
			success : function(response) {
				json = JSON.parse(response);
				quantity = json.quantity;
				if (quantity < 1) {
					$("#element" + itemCode).fadeOut('slow', function(c) {
						$("#element" + itemCode).remove();
					});
				}
				$("#countOf" + itemCode).text(quantity);

			}
		});
	}

});