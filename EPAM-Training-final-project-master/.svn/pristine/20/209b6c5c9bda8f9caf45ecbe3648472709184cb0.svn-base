package ua.nure.serdyuk.SummaryTask4.db.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import ua.nure.serdyuk.SummaryTask4.constants.Const;
import ua.nure.serdyuk.SummaryTask4.db.dao.RouteDao;
import ua.nure.serdyuk.SummaryTask4.db.service.RouteService;
import ua.nure.serdyuk.SummaryTask4.entity.Route;
import ua.nure.serdyuk.SummaryTask4.util.DateUtils;

public class RouteServiceImpl implements RouteService {

	private static final Logger LOG = Logger.getLogger(RouteServiceImpl.class);

	private RouteDao routeDao;

	public RouteServiceImpl(RouteDao routeDao) {
		this.routeDao = routeDao;
	}

	@Override
	public List<Route> getAllByStationsAndDate(long stationFromId,
			long stationToId, java.sql.Date date) {
		return routeDao.getAllByStationsAndDate(stationFromId, stationToId,
				date);
	}

	@Override
	public boolean create(Route item) {
		return routeDao.create(item);
	}

	@Override
	public List<Route> getAllByDates(String from, String to) {
		return routeDao.getAllByDates(
				DateUtils.extractDate(from, Const.CLIENT_DATE_FORMAT),
				DateUtils.extractDate(to, Const.CLIENT_DATE_FORMAT));
	}

	@Override
	public boolean delete(long id) {
		return routeDao.delete(id);
	}
}
