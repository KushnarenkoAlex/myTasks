package ua.nure.serdyuk.SummaryTask4.command.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import ua.nure.serdyuk.SummaryTask4.command.Command;
import ua.nure.serdyuk.SummaryTask4.constants.Const;
import ua.nure.serdyuk.SummaryTask4.constants.Message;
import ua.nure.serdyuk.SummaryTask4.constants.Path;
import ua.nure.serdyuk.SummaryTask4.db.service.UserService;
import ua.nure.serdyuk.SummaryTask4.entity.User;

public class LoginCommand implements Command {

	private static final Logger LOG = Logger.getLogger(LoginCommand.class);

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) {
		UserService service = (UserService) req.getServletContext()
				.getAttribute(Const.USER_SERVICE);
		String email = req.getParameter(Const.EMAIL);
		String password = req.getParameter(Const.PASSWORD);

		HttpSession session = req.getSession();

		User user = service.auth(email, password);
		if (user != null) {
			session.setAttribute(Const.CURRENT_USER, user);
			LOG.info("Login successful");
			String redirect = (String) session.getAttribute(Const.REDIRECT);
			return redirect == null ? Path.INDEX_VIEW : redirect;
		}

		LOG.info(String.format("Login failed for email %s", email));

		req.setAttribute(Const.EMAIL, email);
		session.setAttribute("loginError",
				Message.INVALID_USER_NAME_OR_PASSWORD);

		return Path.LOGIN_VIEW_COMMAND;
	}

}
