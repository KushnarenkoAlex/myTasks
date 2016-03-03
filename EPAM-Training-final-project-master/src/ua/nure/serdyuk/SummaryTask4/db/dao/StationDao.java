package ua.nure.serdyuk.SummaryTask4.db.dao;

import java.util.List;

import ua.nure.serdyuk.SummaryTask4.entity.Station;

public interface StationDao extends GenericDao<Station> {
	
	List<Station> getAll(String filter);
	
	Station getByName(String name);
	
	List<Station> getByRouteItems(long routeItemId1, long routeItemId2);
}
