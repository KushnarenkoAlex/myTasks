package com.epam.preprod.kushnarenko.entity;

public class MechanicBike extends Bicycle {

	private int speedNumber;

	private String brakesType;

	private String moveType;

	public MechanicBike() {
	}

	public MechanicBike(int weight, int height, String frameMaterial, int price, int year, String model,
			int speedNumber, String brakseType, String moveType) {
		super(weight, height, frameMaterial, price, year, model);
		this.speedNumber = speedNumber;
		this.brakesType = brakseType;
		this.moveType = moveType;
	}

	@Override
	public String toString() {
		return "MechanicBike: model-" + getModel();
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	public int getSpeedNumber() {
		return speedNumber;
	}

	public void setSpeedNumber(int speedNumber) {
		this.speedNumber = speedNumber;
	}

	public String getBrakesType() {
		return brakesType;
	}

	public void setBrakesType(String brakesType) {
		this.brakesType = brakesType;
	}

	public String getMoveType() {
		return moveType;
	}

	public void setMoveType(String moveType) {
		this.moveType = moveType;
	}

}
