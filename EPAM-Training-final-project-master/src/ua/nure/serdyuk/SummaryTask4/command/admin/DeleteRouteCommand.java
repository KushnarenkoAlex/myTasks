package ua.nure.serdyuk.SummaryTask4.command.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.serdyuk.SummaryTask4.command.Command;
import ua.nure.serdyuk.SummaryTask4.constants.Const;
import ua.nure.serdyuk.SummaryTask4.constants.Message;
import ua.nure.serdyuk.SummaryTask4.constants.Path;
import ua.nure.serdyuk.SummaryTask4.db.service.RouteService;
import ua.nure.serdyuk.SummaryTask4.exception.DbException;

public class DeleteRouteCommand implements Command {

	private static final Logger LOG = Logger
			.getLogger(DeleteRouteCommand.class);

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) {
		String routeIdStr = req.getParameter("routeId");
		long routeId = Long.valueOf(routeIdStr);

		RouteService service = (RouteService) req.getServletContext()
				.getAttribute(Const.ROUTE_SERVICE);

		List<String> errors = new ArrayList<>();
		boolean result = false;
		try {
			result = service.delete(routeId);

			if (!result) {
				errors.add(Message.SERVER_ERROR);
				LOG.error(String.format("Error while deleting route id=%d",
						routeId));
			} else {
				LOG.info(String.format("Successfully deleted route id=%d",
						routeId));
			}
		} catch (DbException e) {
			errors.add(Message.SERVER_ERROR);
			LOG.error(String.format("DbException while deleting route id=%d",
					routeId));
		}
		req.getSession().setAttribute(Const.ERRORS, errors);

		return Path.ROUTE_VIEW_COMMAND;
	}

}
