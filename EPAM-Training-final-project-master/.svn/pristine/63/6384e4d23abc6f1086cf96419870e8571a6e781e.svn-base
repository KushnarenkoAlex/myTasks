package ua.nure.serdyuk.SummaryTask4.db.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import ua.nure.serdyuk.SummaryTask4.db.dao.CarriageDao;
import ua.nure.serdyuk.SummaryTask4.db.dao.CarriageTypeDao;
import ua.nure.serdyuk.SummaryTask4.db.service.CarriageService;
import ua.nure.serdyuk.SummaryTask4.entity.Carriage;
import ua.nure.serdyuk.SummaryTask4.entity.CarriageType;

public class CarriageServiceImpl implements CarriageService {

	private static final Logger LOG = Logger
			.getLogger(CarriageServiceImpl.class);

	private CarriageDao carriageDao;

	private CarriageTypeDao carriageTypeDao;

	public CarriageServiceImpl(CarriageDao carriageDao,
			CarriageTypeDao carriageTypeDao) {
		this.carriageDao = carriageDao;
		this.carriageTypeDao = carriageTypeDao;
	}

	@Override
	public List<Carriage> getAll(long routeItemFrom, long routeItemTo,
			long trainId, long routeId) {
		List<Carriage> carriages = carriageDao.getAllByTrainIdRouteItems(
				trainId, routeId, routeItemFrom, routeItemTo);
		List<CarriageType> types = carriageTypeDao.getAll();

		List<Integer> list = null;
		Map<Integer, Boolean> seats = null;
		CarriageType tmp;
		for (Carriage item : carriages) {
			tmp = new CarriageType();
			tmp.setId(item.getCarTypeId());

			item.setType(types.get(types.indexOf(tmp)));

			list = item.getSeatsTaken();
			seats = new HashMap<Integer, Boolean>();

			for (int k : list) {
				seats.put(k, true);
			}
			item.setSeats(seats);
		}
		return carriages;
	}

	@Override
	public boolean createAll(List<Carriage> carriages) {
		return carriageDao.createAll(carriages);
	}

	@Override
	public List<Carriage> getAll(long trainId) {
		List<Carriage> carriages = carriageDao.getAllByTrainId(trainId);
		List<CarriageType> types = carriageTypeDao.getAll();

		CarriageType tmp;
		for (Carriage item : carriages) {
			tmp = new CarriageType();
			tmp.setId(item.getCarTypeId());

			item.setType(types.get(types.indexOf(tmp)));
		}
		return carriages;
	}
}
