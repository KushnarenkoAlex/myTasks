package ua.nure.serdyuk.SummaryTask4.entity;

import java.io.Serializable;
import java.sql.Date;

public class Route implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;

	private Date date;

	private long trainId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return (Date) date.clone();
	}

	public void setDate(Date date) {
		this.date = (Date) date.clone();
	}

	public long getTrainId() {
		return trainId;
	}

	public void setTrainId(long trainId) {
		this.trainId = trainId;
	}

	@Override
	public String toString() {
		return "Route [id=" + id + ", date=" + date + ", trainId=" + trainId
				+ "]";
	}
}
