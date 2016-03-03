package ua.nure.serdyuk.SummaryTask4.command.ajax;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.serdyuk.SummaryTask4.command.Command;

public class UpdateCarriageCommand implements Command {

	private static final Logger LOG = Logger
			.getLogger(UpdateCarriageCommand.class);

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) {
		String key = req.getParameter("pk");
		String value = req.getParameter("value");
		String name = req.getParameter("name");

		long id = Long.valueOf(key);

		LOG.debug("value=" + value);
		LOG.debug("name=" + name);
		return "message.try_again";
	}

}
