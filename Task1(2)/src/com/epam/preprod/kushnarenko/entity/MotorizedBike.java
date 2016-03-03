package com.epam.preprod.kushnarenko.entity;

public abstract class MotorizedBike extends Bicycle {
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
		return "MotorizedBike [power=" + power + ", chargeTime=" + chargeTime + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + chargeTime;
		result = prime * result + power;
		return result;
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
