package ua.nure.serdyuk.SummaryTask4.db.service;

import java.util.List;

import ua.nure.serdyuk.SummaryTask4.entity.Carriage;

public interface CarriageService {

	boolean createAll(List<Carriage> carriages);

	List<Carriage> getAll(long routeItemFrom, long routeItemTo, long trainId,
			long routeId);

	List<Carriage> getAll(long trainId);
}
