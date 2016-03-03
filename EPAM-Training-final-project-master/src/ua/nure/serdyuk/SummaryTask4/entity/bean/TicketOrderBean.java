package ua.nure.serdyuk.SummaryTask4.entity.bean;

import java.io.Serializable;

import ua.nure.serdyuk.SummaryTask4.entity.Carriage;

public class TicketOrderBean implements Serializable {

	private static final long serialVersionUID = -592514764415037535L;

	private String firstName;

	private String lastName;
	
	private String stationFrom;
	
	private String stationTo;

	private TrainBean trainBean;

	private int seatNum;

	private Carriage carriage;
	
	public TrainBean getTrainBean() {
		return trainBean;
	}
	
	public void setTrainBean(TrainBean trainBean) {
		this.trainBean = trainBean;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
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

	public Carriage getCarriage() {
		return carriage;
	}

	public void setCarriage(Carriage carriage) {
		this.carriage = carriage;
	}

	@Override
	public String toString() {
		return "TicketOrderBean [firstName=" + firstName + ", lastName="
				+ lastName + ", trainBean=" + trainBean + ", seatNum=" + seatNum
				+ ", carriage=" + carriage + "]";
	}

}
