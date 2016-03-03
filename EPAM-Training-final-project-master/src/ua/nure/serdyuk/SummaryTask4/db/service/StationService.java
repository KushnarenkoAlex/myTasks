package ua.nure.serdyuk.SummaryTask4.db.service;

import java.util.List;
import java.util.Map;

import ua.nure.serdyuk.SummaryTask4.entity.Station;

public interface StationService {

	boolean create(Station station);

	boolean update(Station station);

	boolean delete(long id);

	Station getByName(String name);

	/**
	 * Returns all stations in db, sorted ascending by name.
	 * 
	 * @return
	 */
	List<Station> getAll();

	/**
	 * Returns all stations in db, sorted ascending by name that starts with
	 * {@code filter}.
	 * 
	 * @return
	 */
	List<Station> getAll(String filter);

	List<Station> getByRouteItems(long routeItemId1, long routeItemId2);

	Map<String, Station> getStations(String stationFrom, String stationTo);
}
