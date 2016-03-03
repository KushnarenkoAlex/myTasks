package ua.nure.serdyuk.SummaryTask4.db.service.impl;

import java.util.List;

import ua.nure.serdyuk.SummaryTask4.db.dao.CarriageTypeDao;
import ua.nure.serdyuk.SummaryTask4.db.service.CarriageTypeService;
import ua.nure.serdyuk.SummaryTask4.entity.CarriageType;

public class CarriageTypeServiceImpl implements CarriageTypeService {

	private CarriageTypeDao carriageTypeDao;

	public CarriageTypeServiceImpl(CarriageTypeDao carriageTypeDao) {
		this.carriageTypeDao = carriageTypeDao;
	}

	@Override
	public List<CarriageType> getAll() {
		return carriageTypeDao.getAll();
	}

}
