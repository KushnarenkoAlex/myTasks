package ua.nure.serdyuk.SummaryTask4.command.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import ua.nure.serdyuk.SummaryTask4.command.Command;
import ua.nure.serdyuk.SummaryTask4.constants.Const;
import ua.nure.serdyuk.SummaryTask4.constants.Path;
import ua.nure.serdyuk.SummaryTask4.db.service.RouteService;
import ua.nure.serdyuk.SummaryTask4.entity.Route;
import ua.nure.serdyuk.SummaryTask4.entity.bean.TrainBean;

public class GetRoutesCommand implements Command {

	private static final Logger LOG = Logger.getLogger(GetRoutesCommand.class);

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) {
		String dateFrom = req.getParameter("dateFrom");
		String dateTo = req.getParameter("dateTo");

		HttpSession session = req.getSession();
		ServletContext context = req.getServletContext();
		
		session.setAttribute("dateFrom", dateFrom);
		session.setAttribute("dateTo", dateTo);

		RouteService routeService = (RouteService) context
				.getAttribute(Const.ROUTE_SERVICE);
		List<Route> routes = routeService.getAllByDates(dateFrom, dateTo);

		LOG.info("Routes obtained ==> " + routes);

		@SuppressWarnings("unchecked")
		List<TrainBean> trainBeans = (List<TrainBean>) req.getSession()
				.getAttribute("trainBeans");
		List<TrainBean> trainBeans2 = new ArrayList<>();

		TrainBean tmp;
		for (Route item : routes) {
			tmp = new TrainBean();
			tmp.setTrainId(item.getTrainId());
			TrainBean att = trainBeans.get(trainBeans.indexOf(tmp));
			tmp.setRouteId(item.getId());
			tmp.setDepDate(item.getDate());
			tmp.setTrainTag(att.getTrainTag());
			tmp.setStationFrom(att.getStationFrom());
			tmp.setStationTo(att.getStationTo());

			trainBeans2.add(tmp);
		}

		session.setAttribute("routes", trainBeans2);
		session.setAttribute(Const.ROUTE_ADD_MES, null);
		session.setAttribute(Const.ROUTE_ADD_ERR, null);

		return Path.ROUTE_VIEW_COMMAND;
	}

}
