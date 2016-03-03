package ua.nure.serdyuk.SummaryTask4.db.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import ua.nure.serdyuk.SummaryTask4.db.dao.RouteItemDao;
import ua.nure.serdyuk.SummaryTask4.db.dao.TrainBeanDao;
import ua.nure.serdyuk.SummaryTask4.db.service.TrainBeanService;
import ua.nure.serdyuk.SummaryTask4.entity.RouteItem;
import ua.nure.serdyuk.SummaryTask4.entity.bean.TrainBean;
import ua.nure.serdyuk.SummaryTask4.util.DateUtils;

public class TrainBeanServiceImpl implements TrainBeanService {

	private static final Logger LOG = Logger
			.getLogger(TrainBeanServiceImpl.class);

	private TrainBeanDao trainInfoDao;

	private RouteItemDao routeItemDao;

	public TrainBeanServiceImpl(TrainBeanDao trainInfoDao,
			RouteItemDao routeItemDao) {
		this.trainInfoDao = trainInfoDao;
		this.routeItemDao = routeItemDao;
	}

	@Override
	public TrainBean getFullInfo(long trainId, long stFromId, long stToId,
			long routeId) {
		TrainBean bean = trainInfoDao.getFullInfo(trainId, stFromId, stToId,
				routeId);
		bean.setTrainId(trainId);
		bean.setRouteId(routeId);
		Date depDate = bean.getDepDate();
		Date arrDate = getArrivalDate(bean.getArrDate(), depDate, trainId,
				stFromId, stToId);

		bean.setArrDate(arrDate);
		bean.setDuration(DateUtils.getDuration(depDate, arrDate));

		return bean;
	}

	private Date getArrivalDate(Date arrTime, Date depDate, long routeId,
			long stFromId, long stToId) {
		List<RouteItem> routeItems = routeItemDao.getAllByStations(routeId,
				stFromId, stToId);

		Calendar cal = Calendar.getInstance();
		cal.setTime(arrTime);
		Calendar calFrom = Calendar.getInstance();
		calFrom.setTime(depDate);

		cal.set(Calendar.DATE, calFrom.get(Calendar.DATE));
		cal.set(Calendar.MONTH, calFrom.get(Calendar.MONTH));
		cal.set(Calendar.YEAR, calFrom.get(Calendar.YEAR));

		Date arrDate = cal.getTime();
		int days = 0;

		for (int i = 0; i < routeItems.size() - 1; i++) {
			Date dTime = routeItems.get(i).getDepartureTime();
			Date aTime = routeItems.get(i + 1).getArrivalTime();

			if (dTime.after(aTime)) {
				days++;
			}
		}

		if (days > 0) {
			DateUtils.increaseDays(arrDate, days);
		}

		return arrDate;
	}

	@Override
	public List<TrainBean> getAll() {
		return trainInfoDao.getAll();
	}
}
