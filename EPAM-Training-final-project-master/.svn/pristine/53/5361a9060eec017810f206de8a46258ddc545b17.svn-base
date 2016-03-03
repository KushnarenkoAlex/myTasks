package ua.nure.serdyuk.SummaryTask4.command.train;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.serdyuk.SummaryTask4.command.Command;
import ua.nure.serdyuk.SummaryTask4.constants.Const;
import ua.nure.serdyuk.SummaryTask4.constants.Path;
import ua.nure.serdyuk.SummaryTask4.db.service.CarriageService;
import ua.nure.serdyuk.SummaryTask4.entity.Carriage;
import ua.nure.serdyuk.SummaryTask4.entity.bean.CarriageListBean;
import ua.nure.serdyuk.SummaryTask4.entity.bean.TrainBean;

public class GetFreeSeatsCommand implements Command {

	private static final Logger LOG = Logger
			.getLogger(GetFreeSeatsCommand.class);

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) {
		String routeIdStr = req.getParameter("routeId");
		long routeId = Long.valueOf(routeIdStr);

		@SuppressWarnings("unchecked")
		List<TrainBean> trainInfoBeans = (List<TrainBean>) req.getSession()
				.getAttribute(Const.TRAIN_INFO_BEANS);
		TrainBean temp = new TrainBean();
		temp.setRouteId(routeId);

		LOG.debug("beans ==> " + trainInfoBeans);

		TrainBean bean = trainInfoBeans.get(trainInfoBeans.indexOf(temp));
		List<Carriage> carriages = getCarriageList(req, bean);
		bean.setCarriages(carriages);

		req.setAttribute(Const.CARRIAGE_LIST, new CarriageListBean(carriages));
		req.setAttribute(Const.ROUTE_ID, routeId);

		return Path.FREE_SEATS_VIEW;
	}
	
	private List<Carriage> getCarriageList(HttpServletRequest req, TrainBean bean){
		CarriageService carriageService = (CarriageService) req
				.getServletContext().getAttribute(Const.CARRIAGE_SERVICE);
		List<Carriage> carriages = carriageService.getAll(
				bean.getRouteItemIdFrom(), bean.getRouteItemIdTo(),
				bean.getTrainId(), bean.getRouteId());
		
		LOG.debug("carriages found ==> " + carriages);
		
		return carriages;
	}

}
