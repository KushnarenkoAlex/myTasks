package ua.nure.serdyuk.SummaryTask4.entity.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import ua.nure.serdyuk.SummaryTask4.entity.Carriage;

public class TrainBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private long trainId;

	private long routeId;

	private long routeItemIdFrom;

	private long routeItemIdTo;

	private String trainTag;

	private String stationFrom;

	private String stationTo;

	private Date depDate;

	private Date arrDate;

	private Date duration;

	private List<RouteBean> routes;

	private List<Carriage> carriages;

	public String getTrainTag() {
		return trainTag;
	}

	public void setTrainTag(String trainTag) {
		this.trainTag = trainTag;
	}

	public long getRouteItemIdFrom() {
		return routeItemIdFrom;
	}

	public void setRouteItemIdFrom(long routeItemIdFrom) {
		this.routeItemIdFrom = routeItemIdFrom;
	}

	public long getRouteItemIdTo() {
		return routeItemIdTo;
	}

	public void setRouteItemIdTo(long routeItemIdTo) {
		this.routeItemIdTo = routeItemIdTo;
	}

	public String getStationFrom() {
		return stationFrom;
	}

	public void setStationFrom(String stationFrom) {
		this.stationFrom = stationFrom;
	}

	public String getStationTo() {
		return stationTo;
	}

	public void setStationTo(String stationTo) {
		this.stationTo = stationTo;
	}

	public Date getDepDate() {
		return (Date) depDate.clone();
	}

	public void setDepDate(Date depDate) {
		this.depDate = (Date) depDate.clone();
	}

	public Date getArrDate() {
		return (Date) arrDate.clone();
	}

	public void setArrDate(Date arrDate) {
		this.arrDate = (Date) arrDate.clone();
	}

	public Date getDuration() {
		return (Date) duration.clone();
	}

	public void setDuration(Date duration) {
		this.duration = (Date) duration.clone();
	}

	public long getTrainId() {
		return trainId;
	}

	public void setTrainId(long trainId) {
		this.trainId = trainId;
	}

	public long getRouteId() {
		return routeId;
	}

	public void setRouteId(long routeId) {
		this.routeId = routeId;
	}

	public List<Carriage> getCarriages() {
		return carriages;
	}

	public void setCarriages(List<Carriage> carriages) {
		this.carriages = carriages;
	}

	public List<RouteBean> getRoutes() {
		return routes;
	}

	public void setRoutes(List<RouteBean> routes) {
		this.routes = routes;
	}

	@Override
	public String toString() {
		return "TrainBean [trainId=" + trainId + ", routeId=" + routeId
				+ ", routeItemIdFrom=" + routeItemIdFrom + ", routeItemIdTo="
				+ routeItemIdTo + ", trainTag=" + trainTag + ", stationFrom="
				+ stationFrom + ", stationTo=" + stationTo + ", depDate="
				+ depDate + ", arrDate=" + arrDate + ", duration=" + duration
				+ ", routes=" + routes + ", carriages=" + carriages + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (routeId ^ (routeId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		TrainBean other = (TrainBean) obj;
		if (routeId != other.routeId) {
			return false;
		}
		return true;
	}
}
