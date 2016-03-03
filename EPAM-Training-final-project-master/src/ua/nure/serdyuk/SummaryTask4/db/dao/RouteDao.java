package ua.nure.serdyuk.SummaryTask4.db.dao;

import java.sql.Date;
import java.util.List;

import ua.nure.serdyuk.SummaryTask4.entity.Route;

public interface RouteDao extends GenericDao<Route> {

	List<Route> getAllByStationsAndDate(long stationFromId, long stationToId,
			java.sql.Date date);

	List<Route> getAllByDates(Date from, Date to);
}
