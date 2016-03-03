package com.epam.preprod.kushnarenko.entity;

public abstract class MechanicBike extends Bicycle {

	private static final long serialVersionUID = -2191621955136365327L;
	private int speedNumber;
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

	public String getBrakesType() {
		return brakesType;
	}

	public String getMoveType() {
		return moveType;
	}

	public int getSpeedNumber() {
		return speedNumber;
	}

	public void setBrakesType(String brakesType) {
		this.brakesType = brakesType;
	}

	public void setMoveType(String moveType) {
		this.moveType = moveType;
	}

	public void setSpeedNumber(int speedNumber) {
		this.speedNumber = speedNumber;
	}

	@Override
	public String toString() {
		return "MechanicBike [id" + getId() + ", weight=" + getWeight() + ", height=" + getHeight() + ", price="
				+ getPrice() + ", year=" + getYear() + ", model=" + getModel() + ", frameMaterial=" + getFrameMaterial()
				+ "speedNumber=" + speedNumber + ", brakesType=" + brakesType + ", moveType=" + moveType + "]";
	}

}
