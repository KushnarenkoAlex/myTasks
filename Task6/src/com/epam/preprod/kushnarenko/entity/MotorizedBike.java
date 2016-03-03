package com.epam.preprod.kushnarenko.entity;

import com.epam.preprod.kushnarenko.annotation.MyAnno;

public abstract class MotorizedBike extends Bicycle {

	private static final long serialVersionUID = -4442642627457148307L;
	private Integer power;
	private Integer chargeTime;

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

	@MyAnno(key = "CHARGE_TIME")
	public Integer getChargeTime() {
		return chargeTime;
	}

	@MyAnno(key = "POWER")
	public Integer getPower() {
		return power;
	}

	@MyAnno(key = "CHARGE_TIME")
	public void setChargeTime(Integer chargeTime) {
		this.chargeTime = chargeTime;
	}

	@MyAnno(key = "POWER")
	public void setPower(Integer power) {
		this.power = power;
	}

	@Override
	public String toString() {
		return "MotorizedBike [id" + getId() + ", power=" + power + ", chargeTime=" + chargeTime + "]";
	}
}
