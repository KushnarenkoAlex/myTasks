package ua.nure.serdyuk.SummaryTask4.command.view;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.serdyuk.SummaryTask4.command.Command;
import ua.nure.serdyuk.SummaryTask4.constants.Const;
import ua.nure.serdyuk.SummaryTask4.constants.Path;
import ua.nure.serdyuk.SummaryTask4.db.service.StationService;
import ua.nure.serdyuk.SummaryTask4.db.service.TrainBeanService;
import ua.nure.serdyuk.SummaryTask4.entity.Station;
import ua.nure.serdyuk.SummaryTask4.entity.bean.TrainBean;

public class TrainViewCommand implements Command {

	private static final Logger LOG = Logger
			.getLogger(TrainViewCommand.class);

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) {
		StationService stationService = (StationService) req.getServletContext()
				.getAttribute(Const.STATION_SERVICE);

		List<Station> stations = stationService.getAll();
		LOG.info(
				String.format("Stations obtained ==> %s", stations.toString()));

		req.setAttribute("stations", stations);

		TrainBeanService service = (TrainBeanService) req.getServletContext()
				.getAttribute(Const.TRAIN_BEAN_SERVICE);
		List<TrainBean> beans = service.getAll();

		LOG.info(String.format("Trains found ==> %s", beans));

		req.setAttribute("trainBeans", beans);
		
		return Path.TRAIN_VIEW;
	}

}
