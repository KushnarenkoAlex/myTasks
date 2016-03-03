package ua.nure.serdyuk.SummaryTask4.db.service;

import java.util.List;

import ua.nure.serdyuk.SummaryTask4.entity.bean.TrainBean;

public interface TrainBeanService {

	List<TrainBean> getAll();

	TrainBean getFullInfo(long trainId, long stFromId, long stToId,
			long routeId);
}
