package ua.nure.serdyuk.SummaryTask4.command.user;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.serdyuk.SummaryTask4.command.Command;
import ua.nure.serdyuk.SummaryTask4.constants.Const;
import ua.nure.serdyuk.SummaryTask4.constants.Path;
import ua.nure.serdyuk.SummaryTask4.db.service.UserService;
import ua.nure.serdyuk.SummaryTask4.entity.Role;
import ua.nure.serdyuk.SummaryTask4.entity.User;
import ua.nure.serdyuk.SummaryTask4.exception.AppException;
import ua.nure.serdyuk.SummaryTask4.exception.ValidationException;
import ua.nure.serdyuk.SummaryTask4.validation.Validator;

public class SignUpCommand implements Command {

	private static final Logger LOG = Logger.getLogger(SignUpCommand.class);

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) {
		String email = req.getParameter(Const.EMAIL);
		String password = req.getParameter(Const.PASSWORD);
		String repPassword = req.getParameter(Const.PASSWORD_REPEAT);
		String role = req.getParameter(Const.ROLE);
		String path = Path.ERROR_VIEW;

		req.setAttribute(Const.EMAIL, email);

		List<String> errors = new ArrayList<>();
		req.setAttribute(Const.ERRORS, errors);

		// validate
		if (repPassword == null || !repPassword.equals(password)) {
			errors.add("message.passwords_not_equal");
			 //throw new ValidationException();
		}

		User user = validate(email, repPassword, role, errors);
		if(!errors.isEmpty()){
			throw new ValidationException();
		}
		
		UserService service = (UserService) req.getServletContext()
				.getAttribute(Const.USER_SERVICE);
		if (service.create(user)) {
			errors = null;
			LOG.info("User was successfully created");
			path = Path.LOGIN_VIEW_COMMAND;
		} else {
			LOG.error("User creation failed");
			throw new AppException("User creation failed");
		}

		return path;
	}

	private User validate(String email, String password, String role,
			List<String> errors) {
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		user.setRole(Role.ADMIN.name().equals(role) ? Role.ADMIN : Role.USER);

		errors.addAll(Validator.validate(user));
		if (!errors.isEmpty()) {
			LOG.error(String.format("Validation failed -- %s",
					errors.toString()));
		}

		return user;
	}

}
