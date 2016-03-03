package ua.nure.serdyuk.SummaryTask4.db.service.impl;

import java.util.List;

import ua.nure.serdyuk.SummaryTask4.db.dao.RouteItemDao;
import ua.nure.serdyuk.SummaryTask4.db.service.RouteItemService;
import ua.nure.serdyuk.SummaryTask4.entity.RouteItem;

public class RouteItemServiceMySql implements RouteItemService {

	private RouteItemDao routeItemDao;

	public RouteItemServiceMySql(RouteItemDao routeItemDao) {
		this.routeItemDao = routeItemDao;
	}

	@Override
	public List<RouteItem> getAll() {
		return routeItemDao.getAll();
	}
}
