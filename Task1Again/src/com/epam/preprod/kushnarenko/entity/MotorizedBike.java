package com.epam.preprod.kushnarenko.entity;

public class MotorizedBike extends Bicycle {
	private int power;
	private int chargeTime;

	public MotorizedBike() {
	}

	public MotorizedBike(int weight, int height, String frameMaterial, int price, int year, String model, int power,
			int chargeTime) {
		super(weight, height, frameMaterial, price, year, model);
		this.power = power;
		this.chargeTime = chargeTime;
	}

	@Override
	public String toString() {
		return "Motorized Bike: model-" + getModel();
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getChargeTime() {
		return chargeTime;
	}

	public void setChargeTime(int chargeTime) {
		this.chargeTime = chargeTime;
	}
}
