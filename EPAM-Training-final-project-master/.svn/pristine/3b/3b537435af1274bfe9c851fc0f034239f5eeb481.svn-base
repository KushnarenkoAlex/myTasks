var errors = {
	'en' : {
		"email" : "Email is not valid",
		"password" : "Password should contain at least 4 symbols",
		"repPassword" : "Passwords should match",
		"notEmpty" : "Cannot be empty",
		'message.name_not_valid' : "Name should start with upper-case letter",
		'message.try_again' : "Try again later"
	},
	'ru' : {
		"email" : "Email не валидный",
		"password" : "Пароль должен содержать не менее 4 символов",
		"repPassword" : "Пароли должны совпадать",
		"notEmpty" : "Заполните поле",
		'message.name_not_valid' : 'Имя не может быть пустым и должно начинаться с заглавной буквы',
		'message.try_again' : "Попробуйте позже"
	}
}

$(document).ready(function() {
	console.log("ready!!");
	var lang = $('body').attr('lang');
	//$('#errorDiv').hide();

	$('#signUpForm').submit(function(event) {
		event.preventDefault();
		var map = {
			"email" : /\w+@\w+\.\w+/,
			"password" : /\w{4,50}/

		};

		var proceed = true;
		var $sel, $err, div;
		for (key in map) {
			$sel = $('#' + key);
			div = $sel.parent();
			var regex = new RegExp(map[key]);
			$err = $('#' + key + "Error");

			if (!regex.test($sel.val())) {
				proceed = false;
				$err.html(errors[lang][key]);
			} else {
				$err.html('');
			}
		}
		var key = 'repPassword';
		var $sel = $('#' + key);
		$err = $('#' + key + 'Error');
		if ($sel.val() != $('#password').val()) {
			$err.html(errors[lang][key]);
			proceed = false;
		}

		if (proceed) {
			$(this).off("submit");
			this.submit();
		}
	});

	$('.input-not-empty').submit(function(event) {
		event.preventDefault();
		var proceed = true;
		var items = $(this).find('.form-control');

		for (var i = 0; i < items.length; i++) {
			var id = $(items[i]).attr('id');
			if ($(items[i]).val() == '') {
				$('#' + id + 'Error').html(errors[lang]['notEmpty']);
				proceed = false;
			} else {
				$('#' + id + 'Error').html('');
			}
		}
		if (proceed) {
			$(this).off("submit");
			this.submit();
		}
	});

});

function getStations(input) {
	$.ajax({
		url : "serv?command=getStations&filter=" + $(input).val(),
		type : "get",
		async : true,
		success : function(data) {
			var stations = JSON.parse(data).stations;

			var names = new Array();
			for (var i = 0; i < stations.length; i++) {
				names.push(stations[i].name);
			}

			// console.log(names);
			$(input).autocomplete({
				source : names
			});
		}
	});
};

function addRoute() {
	$.ajax({
		url : "serv?command=addRoute&trainId=" + $('#trainSelect').val()
				+ "&date=" + $('#date').val(),
		type : "post",
		async : true,
		error : function(data) {
			$('#mesDiv').hide();
			$('#errorDiv').show();
			$('#errorDiv p').html(data.statusText);
		},
		success : function(data) {
			$('#errorDiv').hide();
			$('#mesDiv').show();
			$('#mesDiv p').html(data);
		}
	});
}

function updateStation(select) {
	var optName = $(select).find(":selected").text();
	console.log(optName);
	var carTypeId = $(select).find(":selected").val();
	console.log(carTypeId);
	var id = $(select).attr('accesskey');
	console.log(id);

	$.ajax({
		url : "serv?command=updateCarriage&typeId=" + carTypeId + "&id=" + id
				+ "&name=carType",
		type : "post",
		async : true,
		error : function(data) {
			$('#mesDiv').hide();
			$('#errorDiv').show();
			$('#errorDiv p').html(data.statusText);
		},
		success : function(data) {
			$('#errorDiv').hide();
			$('#mesDiv').show();
			$('#mesDiv p').html(data);
		}
	});
}
