$(document)
		.ready(
				function() {
					var lang = $('body').attr('lang');
					console.log(lang);


					$.fn.datepicker.dates['ru'] = {
						days : [ "Воскресенье", "Понедельник", "Вторник",
								"Среда", "Четверг", "Пятница", "Суббота" ],
						daysShort : [ "Вос", "Mon", "Tue", "Wed", "Thu", "Fri",
								"Sat" ],
						daysMin : [ "Вс", "Пн", "Вт", "Ср", "Чт", "Пт", "Сб" ],
						months : [ "Январь", "Февраль", "Март", "Апрель",
								"Май", "Июнь", "Июль", "Август", "Сентябрь",
								"Октябрь", "Ноябрь", "Декабрь" ],
						monthsShort : [ "Янв", "Фев", "Мар", "Апр", "Май",
								"Июн", "Июл", "Авг", "Сен", "Окт", "Ноя", "Дек" ],
						today : "Сегодня",
						clear : "Очистить",
						format : "mm/dd/yyyy",
						titleFormat : "MM yyyy", /*
													 * Leverages same syntax as
													 * 'format'
													 */
						weekStart : 1
					};

					$('#date').datepicker({
						startDate : '0',
						language : lang
						// ,todayBtn: "linked"
					});
				});