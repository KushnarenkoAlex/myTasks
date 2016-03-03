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
						console.log("carriage ==> " + id);
						$('#carriageId').val(id);
						$('div[id=' + id + ']').slideToggle('slow');
					});
					$('.seat').click(function() {
						// $(this).blur();
						var idVal = $(this).html().trim();
						console.log('seat num==> ' + idVal);
						$('#seatNum').val(idVal);
					});

					$('#addStationDiv').hide();
					$('#addNewStation').click(function(event) {
						event.preventDefault();
						$('#addStationDiv').toggle();
						$('#stationName').focus();
					});
//					$.fn.datepicker.dates['ru'] = {
//						days : [ "Воскресенье", "Понедельник", "Вторник",
//								"Среда", "Четверг", "Пятница", "Суббота" ],
//						daysShort : [ "Вос", "Mon", "Tue", "Wed", "Thu", "Fri",
//								"Sat" ],
//						daysMin : [ "Вс", "Пн", "Вт", "Ср", "Чт", "Пт", "Сб" ],
//						months : [ "Январь", "Февраль", "Март", "Апрель",
//								"Май", "Июнь", "Июль", "Август", "Сентябрь",
//								"Октябрь", "Ноябрь", "Декабрь" ],
//						monthsShort : [ "Янв", "Фев", "Мар", "Апр", "Май",
//								"Июн", "Июл", "Авг", "Сен", "Окт", "Ноя", "Дек" ],
//						today : "Сегодня",
//						clear : "Очистить",
//						format : "mm/dd/yyyy",
//						titleFormat : "MM yyyy", /*
//													 * Leverages same syntax as
//													 * 'format'
//													 */
//						weekStart : 1
//					};
//
//					$('.datepicker').datepicker({
//						startDate : '0',
//						language : lang
//					// ,todayBtn: "linked"
//					});

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
