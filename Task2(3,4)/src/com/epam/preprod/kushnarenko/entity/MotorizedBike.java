package com.epam.preprod.kushnarenko.entity;

public abstract class MotorizedBike extends Bicycle {

	private static final long serialVersionUID = -4442642627457148307L;
	private int power;
	private int chargeTime;

	public MotorizedBike() {
	}

	public MotorizedBike(int id, double weight, double height, String frameMaterial, int price, int year, String model,
			int power, int chargeTime) {
		super(id, weight, height, frameMaterial, price, year, model);
		this.power = power;
		this.chargeTime = chargeTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + chargeTime;
		result = prime * result + power;
		return result;
	}

	public int getChargeTime() {
		return chargeTime;
	}

	public int getPower() {
		return power;
	}


	public void setChargeTime(int chargeTime) {
		this.chargeTime = chargeTime;
	}

	public void setPower(int power) {
		this.power = power;
	}

	@Override
	public String toString() {
		return "MotorizedBike [id" + getId() + ", power=" + power + ", chargeTime=" + chargeTime + "]";
	}
}
