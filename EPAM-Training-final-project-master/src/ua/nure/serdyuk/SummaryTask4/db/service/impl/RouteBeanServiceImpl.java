package ua.nure.serdyuk.SummaryTask4.db.service.impl;

import java.util.List;

import ua.nure.serdyuk.SummaryTask4.db.dao.RouteBeanDao;
import ua.nure.serdyuk.SummaryTask4.db.service.RouteBeanService;
import ua.nure.serdyuk.SummaryTask4.entity.bean.RouteBean;

public class RouteBeanServiceImpl implements RouteBeanService {
	
	private RouteBeanDao routeInfoDao;
	
	public RouteBeanServiceImpl(RouteBeanDao routeInfoDao) {
		this.routeInfoDao = routeInfoDao;
	}

	@Override
	public List<RouteBean> getAllByTrainId(long trainId) {
		return routeInfoDao.getAllByTrainId(trainId);
	}

}
