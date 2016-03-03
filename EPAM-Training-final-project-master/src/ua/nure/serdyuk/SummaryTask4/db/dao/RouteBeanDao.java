package ua.nure.serdyuk.SummaryTask4.db.dao;

import java.util.List;

import ua.nure.serdyuk.SummaryTask4.entity.bean.RouteBean;

public interface RouteBeanDao extends GenericDao<RouteBean> {
	
	List<RouteBean> getAllByTrainId(long trainId);

}
