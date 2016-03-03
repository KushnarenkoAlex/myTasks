$(document)
		.ready(
				function() {
					var lang = $('body').attr('lang');
					// index.jsp
					$('#swapStations').click(function(event) {
						var text1 = $('#stationFrom').val();
						var text2 = $('#stationTo').val();
						$('#stationFrom').val(text2);
						$('#stationTo').val(text1);
					});

					// displayFreeSeats
					$('.seat-container').css('display', 'none');
					$('.carriage-item').click(function() {
						var id = $(this).attr('id');
						$('#carriageId').val(id);
						$('div[id=' + id + ']').slideToggle('slow');
					});
					$('.seat').click(function() {
						// $(this).blur();
						var idVal = $(this).html().trim();
						$('#seatNum').val(idVal);
					});

					$('#addStationDiv').hide();
					$('#addNewStation').click(function(event) {
						event.preventDefault();
						$('#addStationDiv').toggle();
						$('#stationName').focus();
					});

				});

function toggleButton(button) {
	console.log($(button).attr('id'));
	$(button).toggleClass('focus');
};

function addStationSelect(event) {
	event.preventDefault();
	var html = $('#selectStation').html();
	$('#stationContainer').append(html);
};

function addCarriageSelect(event) {
	event.preventDefault();
	var html = $('#selectCarriage').html();
	$('#carriageContainer').append(html);
};
