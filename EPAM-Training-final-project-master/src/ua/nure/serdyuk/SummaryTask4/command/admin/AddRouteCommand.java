package ua.nure.serdyuk.SummaryTask4.command.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import ua.nure.serdyuk.SummaryTask4.command.Command;
import ua.nure.serdyuk.SummaryTask4.constants.Const;
import ua.nure.serdyuk.SummaryTask4.constants.Path;
import ua.nure.serdyuk.SummaryTask4.db.service.RouteService;
import ua.nure.serdyuk.SummaryTask4.entity.Route;
import ua.nure.serdyuk.SummaryTask4.util.DateUtils;

public class AddRouteCommand implements Command {

	private static final Logger LOG = Logger.getLogger(AddRouteCommand.class);

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) {
		String trainIdStr = req.getParameter("trainSelect");
		String date = req.getParameter("date");

		int trainId = Integer.valueOf(trainIdStr);

		HttpSession session = req.getSession();

		RouteService service = (RouteService) req.getServletContext()
				.getAttribute(Const.ROUTE_SERVICE);
		Route route = new Route();
		route.setTrainId(trainId);
		route.setDate(DateUtils.extractDate(date, Const.CLIENT_DATE_FORMAT));

		if (service.create(route)) {
			session.setAttribute(Const.ROUTE_ADD_MES, "message.route_added");
			session.setAttribute(Const.ROUTE_ADD_ERR, null);
			LOG.info(String.format("New route added ==> %s", route.toString()));
		} else {
			session.setAttribute(Const.ROUTE_ADD_ERR,
					"message.route_add_error");
			session.setAttribute(Const.ROUTE_ADD_MES, null);
			LOG.error("Failed to create route");
		}
		return Path.ROUTE_VIEW_COMMAND;
	}

}
