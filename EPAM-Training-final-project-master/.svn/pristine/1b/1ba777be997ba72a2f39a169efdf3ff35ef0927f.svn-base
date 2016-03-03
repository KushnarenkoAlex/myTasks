package ua.nure.serdyuk.SummaryTask4.db.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ua.nure.serdyuk.SummaryTask4.db.dao.StationDao;
import ua.nure.serdyuk.SummaryTask4.db.service.StationService;
import ua.nure.serdyuk.SummaryTask4.entity.Station;

public class StationServiceMySql implements StationService {

	// private static final Logger LOG = Logger
	// .getLogger(StationServiceMySql.class);

	private StationDao stationDao;

	public StationServiceMySql(StationDao stationDao) {
		this.stationDao = stationDao;
	}

	@Override
	public List<Station> getAll() {
		return stationDao.getAll(null);
	}

	@Override
	public List<Station> getAll(String filter) {
		return stationDao.getAll(filter);
	}

	@Override
	public Station getByName(String name) {
		return stationDao.getByName(name);
	}

	@Override
	public List<Station> getByRouteItems(long routeItemId1, long routeItemId2) {
		return stationDao.getByRouteItems(routeItemId1, routeItemId2);
	}

	@Override
	public boolean create(Station station) {
		return stationDao.create(station);
	}

	@Override
	public boolean update(Station station) {
		return stationDao.update(station);
	}

	@Override
	public boolean delete(long id) {
		return stationDao.delete(id);
	}

	@Override
	public Map<String, Station> getStations(String stationFrom,
			String stationTo) {
		Map<String, Station> stations = new HashMap<>();

		stations.put(stationFrom, getByName(stationFrom));
		stations.put(stationTo, getByName(stationTo));

		return stations;
	}
}
