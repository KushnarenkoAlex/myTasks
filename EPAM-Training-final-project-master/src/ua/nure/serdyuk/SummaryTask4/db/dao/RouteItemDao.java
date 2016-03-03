package ua.nure.serdyuk.SummaryTask4.db.dao;

import java.util.List;

import ua.nure.serdyuk.SummaryTask4.entity.RouteItem;

public interface RouteItemDao extends GenericDao<RouteItem> {

	/**
	 * Returns list of RouteItem in the specified route, sorted by ordinal.
	 * 
	 * @param routeId
	 * @return
	 */
	List<RouteItem> getAll(long trainId);
	
	List<RouteItem> getAllByStations(long routeId, long stFromId, long stToId);

}
