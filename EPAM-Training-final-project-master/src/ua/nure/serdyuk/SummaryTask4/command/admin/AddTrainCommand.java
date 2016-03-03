package ua.nure.serdyuk.SummaryTask4.command.admin;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.serdyuk.SummaryTask4.command.Command;
import ua.nure.serdyuk.SummaryTask4.constants.Const;
import ua.nure.serdyuk.SummaryTask4.constants.Path;
import ua.nure.serdyuk.SummaryTask4.db.service.StationService;
import ua.nure.serdyuk.SummaryTask4.db.service.TrainService;
import ua.nure.serdyuk.SummaryTask4.entity.RouteItem;
import ua.nure.serdyuk.SummaryTask4.entity.Station;
import ua.nure.serdyuk.SummaryTask4.entity.Train;
import ua.nure.serdyuk.SummaryTask4.util.DateUtils;

public class AddTrainCommand implements Command {

	private static final Logger LOG = Logger.getLogger(AddTrainCommand.class);

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) {
		String trainTag = req.getParameter("trainTag");
		String price = req.getParameter("trainPrice");

		ServletContext context = req.getServletContext();

		Train train = new Train();
		train.setTag(trainTag);
		train.setPrice(BigDecimal.valueOf(Double.valueOf(price)));

		train.setRouteItems(processRouteItems(req, train.getId()));
		
		TrainService trainService = (TrainService) context
				.getAttribute(Const.TRAIN_SERVICE);
		trainService.create(train);

		return Path.TRAIN_VIEW_COMMAND;
	}

	private List<RouteItem> processRouteItems(HttpServletRequest req,
			int trainId) {
		String[] stations = req.getParameterValues("stationSelect");
		String[] arrTime = req.getParameterValues("arrTime");
		String[] depTime = req.getParameterValues("depTime");

		List<RouteItem> routeItems = new ArrayList<>();
		RouteItem item;
		for (int i = 0; i < stations.length; i++) {
			item = extractRouteItem(req.getServletContext(), arrTime[i],
					depTime[i], stations[i], i, trainId);
			LOG.debug(item);

			routeItems.add(item);
		}

		return routeItems;
	}

	private RouteItem extractRouteItem(ServletContext context, String arrTime,
			String depTime, String stationName, int ordinal, int trainId) {
		StationService stationService = (StationService) context
				.getAttribute(Const.STATION_SERVICE);
		RouteItem item = new RouteItem();
		Date date = DateUtils.extractDate(arrTime, Const.CLIENT_TIME_FORMAT);
		LOG.debug("date ==> " + date);
		item.setArrivalTime(date);
		date = DateUtils.extractDate(depTime, Const.CLIENT_TIME_FORMAT);
		item.setDepartureTime(date);

		Station station = stationService.getByName(stationName);

		item.setOrdinal(ordinal);
		item.setStationId(station.getId());
		item.setTrainId(trainId);

		return item;
	}

}
