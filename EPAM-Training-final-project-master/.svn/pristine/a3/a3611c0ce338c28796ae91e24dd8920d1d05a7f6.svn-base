package ua.nure.serdyuk.SummaryTask4.command.train;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.serdyuk.SummaryTask4.command.Command;
import ua.nure.serdyuk.SummaryTask4.constants.Const;
import ua.nure.serdyuk.SummaryTask4.constants.Path;
import ua.nure.serdyuk.SummaryTask4.db.service.RouteBeanService;

public class ShowRouteInfoCommand implements Command {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) {
		String trainIdStr = req.getParameter("trainId");
		long trainId = Long.valueOf(trainIdStr);

		RouteBeanService service = (RouteBeanService) req.getServletContext()
				.getAttribute(Const.ROUTE_INFO_SERVICE);
		req.setAttribute(Const.ROUTE_INFO_BEANS,
				service.getAllByTrainId(trainId));

		return Path.ROUTE_INFO_VIEW;
	}

}
