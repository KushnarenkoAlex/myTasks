package ua.nure.serdyuk.SummaryTask4.db.dao;

import java.math.BigDecimal;

import ua.nure.serdyuk.SummaryTask4.entity.bean.TrainBean;

public interface TrainBeanDao extends GenericDao<TrainBean> {

	TrainBean getFullInfo(long trainId, long stFromId, long stToId,
			long routeId);
	
	BigDecimal getPrice(long trainId, int carTypeId, int ordinalFrom,
			int ordinalTo);

}
