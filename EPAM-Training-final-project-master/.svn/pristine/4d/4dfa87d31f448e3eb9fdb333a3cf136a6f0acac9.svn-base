package ua.nure.serdyuk.SummaryTask4.db.dao;

import java.util.List;

import ua.nure.serdyuk.SummaryTask4.entity.Carriage;

public interface CarriageDao extends GenericDao<Carriage> {
	
	boolean createAll(List<Carriage> carriages);

	List<Carriage> getAllByTrainIdRouteItems(long trainId, long routeId,
			long routeItemFrom, long routeItemTo);
	
	List<Carriage> getAllByTrainId(long trainId);

}
