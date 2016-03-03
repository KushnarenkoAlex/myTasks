package ua.nure.serdyuk.SummaryTask4.command.view;

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
import ua.nure.serdyuk.SummaryTask4.db.service.TrainBeanService;
import ua.nure.serdyuk.SummaryTask4.entity.Route;
import ua.nure.serdyuk.SummaryTask4.entity.bean.TrainBean;

public class RouteViewCommand implements Command {

	private static final Logger LOG = Logger.getLogger(RouteViewCommand.class);

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) {
		TrainBeanService service = (TrainBeanService) req.getServletContext()
				.getAttribute(Const.TRAIN_BEAN_SERVICE);
		List<TrainBean> beans = service.getAll();

		LOG.info(String.format("Trains found ==> %s", beans));

		HttpSession session = req.getSession();
		session.setAttribute("trainBeans", beans);

		String dateFrom = req.getParameter(Const.DATE_FROM);
		String dateTo = req.getParameter(Const.DATE_TO);
		if (dateFrom == null) {
			dateFrom = (String) session.getAttribute(Const.DATE_FROM);
		}
		if (dateTo == null) {
			dateTo = (String) session.getAttribute(Const.DATE_TO);
		}

		if (dateFrom != null && dateTo != null) {
			getRoute(req.getServletContext(), session, dateFrom, dateTo);
		}

		return Path.ROUTE_VIEW;
	}

	private void getRoute(ServletContext context, HttpSession session,
			String dateFrom, String dateTo) {
		session.setAttribute(Const.DATE_FROM, dateFrom);
		session.setAttribute(Const.DATE_TO, dateTo);

		RouteService routeService = (RouteService) context
				.getAttribute(Const.ROUTE_SERVICE);
		List<Route> routes = routeService.getAllByDates(dateFrom, dateTo);

		LOG.info("Routes obtained ==> " + routes);

		@SuppressWarnings("unchecked")
		List<TrainBean> trainBeans = (List<TrainBean>) session
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

	}

}
