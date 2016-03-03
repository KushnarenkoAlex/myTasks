package com.epam.preprod.kushnarenko.entity;

import com.epam.preprod.kushnarenko.annotation.MyAnno;

public abstract class MechanicBike extends Bicycle {

	private static final long serialVersionUID = -2191621955136365327L;

	private Integer speedNumber;
	private String brakesType;
	private String moveType;

	public MechanicBike() {
	}

	public MechanicBike(int id, double weight, double height, String frameMaterial, int price, int year, String model,
			int speedNumber, String brakseType, String moveType) {
		super(id, weight, height, frameMaterial, price, year, model);
		this.speedNumber = speedNumber;
		this.brakesType = brakseType;
		this.moveType = moveType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((brakesType == null) ? 0 : brakesType.hashCode());
		result = prime * result + ((moveType == null) ? 0 : moveType.hashCode());
		result = prime * result + speedNumber;
		return result;
	}

	@MyAnno(key = "BRAKES_TYPE")
	public String getBrakesType() {
		return brakesType;
	}

	@MyAnno(key = "MOVE_TYPE")
	public String getMoveType() {
		return moveType;
	}

	@MyAnno(key = "SPEED_NUMBER")
	public Integer getSpeedNumber() {
		return speedNumber;
	}

	@MyAnno(key = "BRAKES_TYPE")
	public void setBrakesType(String brakesType) {
		this.brakesType = brakesType;
	}

	@MyAnno(key = "MOVE_TYPE")
	public void setMoveType(String moveType) {
		this.moveType = moveType;
	}

	@MyAnno(key = "SPEED_NUMBER")
	public void setSpeedNumber(Integer speedNumber) {
		this.speedNumber = speedNumber;
	}

	@Override
	public String toString() {
		return "MechanicBike [id" + getId() + ", weight=" + getWeight() + ", height=" + getHeight() + ", price="
				+ getPrice() + ", year=" + getYear() + ", model=" + getModel() + ", frameMaterial=" + getFrameMaterial()
				+ "speedNumber=" + speedNumber + ", brakesType=" + brakesType + ", moveType=" + moveType + "]";
	}

}
