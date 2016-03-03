package ua.nure.serdyuk.SummaryTask4.entity.bean;

import java.io.Serializable;
import java.util.Date;

public class RouteBean implements Serializable {

	private static final long serialVersionUID = 7584579995712772109L;

	private String trainTag;

	// create inner class here

	private String stationName;

	private Date arrTime;

	private Date depTime;

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public Date getDepTime() {
		return (Date) depTime.clone();
	}

	public void setDepTime(Date depDate) {
		this.depTime = depDate != null ? (Date) depDate.clone() : depDate;
	}

	public Date getArrTime() {
		return (Date) arrTime.clone();
	}

	public void setArrTime(Date arrDate) {
		this.arrTime = arrDate != null ? (Date) arrDate.clone() : arrDate;
	}

	public String getTrainTag() {
		return trainTag;
	}

	public void setTrainTag(String trainTag) {
		this.trainTag = trainTag;
	}

	@Override
	public String toString() {
		return "RouteInfoBean [stationName=" + stationName + ", arrTime="
				+ arrTime + ", depTime=" + depTime + "]";
	}
}