package ua.nure.serdyuk.SummaryTask4.command.train;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import ua.nure.serdyuk.SummaryTask4.command.Command;
import ua.nure.serdyuk.SummaryTask4.constants.Const;
import ua.nure.serdyuk.SummaryTask4.constants.Path;
import ua.nure.serdyuk.SummaryTask4.db.service.StationService;
import ua.nure.serdyuk.SummaryTask4.entity.Carriage;
import ua.nure.serdyuk.SummaryTask4.entity.Station;
import ua.nure.serdyuk.SummaryTask4.entity.bean.TicketOrderBean;
import ua.nure.serdyuk.SummaryTask4.entity.bean.TrainBean;

public class OrderTicketViewCommand implements Command {

	private static final Logger LOG = Logger
			.getLogger(OrderTicketViewCommand.class);

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) {
		String carriageIdStr = req.getParameter("carriageId");
		String seatNumStr = req.getParameter("seatNum");

		long carriageId = Long.valueOf(carriageIdStr);
		int seatNum = Integer.valueOf(seatNumStr);
		long routeId = (long) req.getSession().getAttribute(Const.ROUTE_ID);

		HttpSession session = req.getSession();

		String redirect = String.format("%s?%s", req.getServletPath(),
				req.getQueryString());
		LOG.info("redirect ==> " + redirect);
		session.setAttribute(Const.REDIRECT, redirect);

		TrainBean trainBean = getTrainBean(session, routeId);
		Carriage carriage = getCarriage(trainBean, carriageId);

		StationService stationService = (StationService) req.getServletContext()
				.getAttribute(Const.STATION_SERVICE);
		List<Station> stations = stationService.getByRouteItems(
				trainBean.getRouteItemIdFrom(), trainBean.getRouteItemIdTo());

		TicketOrderBean ticketBean = new TicketOrderBean();
		ticketBean.setSeatNum(seatNum);
		ticketBean.setCarriage(carriage);
		ticketBean.setTrainBean(trainBean);
		ticketBean.setStationFrom(stations.get(0).getName());
		ticketBean.setStationTo(stations.get(1).getName());

		session.setAttribute(Const.TICKET_ORDER_BEAN, ticketBean);

		return Path.ORDER_TICKET_VIEW;
	}

	private TrainBean getTrainBean(HttpSession session, long routeId) {
		@SuppressWarnings("unchecked")
		List<TrainBean> trainBeans = (List<TrainBean>) session
				.getAttribute(Const.TRAIN_INFO_BEANS);
		TrainBean trainBean = new TrainBean();
		trainBean.setRouteId(routeId);
		trainBean = trainBeans.get(trainBeans.indexOf(trainBean));

		LOG.info("Train bean ==> " + trainBean);

		return trainBean;
	}

	private Carriage getCarriage(TrainBean trainBean, long carriageId) {
		Carriage carriage = new Carriage();
		carriage.setId(carriageId);
		carriage = trainBean.getCarriages()
				.get(trainBean.getCarriages().indexOf(carriage));

		LOG.info("Carriage ==> " + carriage);

		return carriage;

	}

}
