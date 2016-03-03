//checks form on sidn_up.html
document.addEventListener("DOMContentLoaded", function(event) {

	var form = document.getElementById("signUpForm");
	form.addEventListener("submit", function(event) {
		if (!validate(this)) {
			event.preventDefault();
		}
	});

	function validate(form) {
		var map = {
			"firstName" : /(\d|\w){1,}/,
			"lastName" : /(\d|\w){1,}/,
			"password" : /(\d|\w){4,200}/,
			"email" : /.*@.*/,
			"phoneNumber" : /\(\d{3}\)\s\d{3}\s\d{2}\s\d{2}/
		};

		var errors = {
			"firstName" : "First Name is incorrect",
			"lastName" : "Last Name is incorrect",
			"password" : "Password must have more then 4 symbols",
			"email" : "Email must contain @",
			"phoneNumber" : "(xxx) xxx xx xx"
		};

		var flag = true;
		var key;
		var formElements = form.elements;
		var errorSpans = document.getElementsByClassName("error-message");
		for (key in map) {
			var el = document.getElementById(key + "Error");
			var regex = new RegExp(map[key]);
			var input = document.getElementById(key);
			var value = input.value;
			if (!regex.test(value)) {
				el.innerHTML = errors[key];
				flag = false;
			} else {
				el.innerHTML = "";
			}
		}
		return flag;
	}
});