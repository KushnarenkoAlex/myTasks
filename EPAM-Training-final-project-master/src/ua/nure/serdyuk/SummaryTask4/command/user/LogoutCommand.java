package ua.nure.serdyuk.SummaryTask4.command.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.serdyuk.SummaryTask4.command.Command;
import ua.nure.serdyuk.SummaryTask4.constants.Const;
import ua.nure.serdyuk.SummaryTask4.constants.Path;

public class LogoutCommand implements Command {

	private static final Logger LOG = Logger.getLogger(LogoutCommand.class);

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) {
		req.getSession().setAttribute(Const.CURRENT_USER, null);
		LOG.info("Logged out");
		
		return Path.INDEX_VIEW;
	}

}
