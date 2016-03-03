package com.epam.preprod.kushnarenko.entity;

public abstract class MechanicBike extends Bicycle {

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
		return "MechanicBike [weight=" + getWeight() + ", height=" + getHeight() + ", price=" + getPrice() + ", year="
				+ getYear() + ", model=" + getModel() + ", frameMaterial=" + getFrameMaterial() + "speedNumber="
				+ speedNumber + ", brakesType=" + brakesType + ", moveType=" + moveType + "]";
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
