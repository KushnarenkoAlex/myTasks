package com.epam.preprod.kushnarenko.entity;

import java.math.BigDecimal;
import java.util.Random;

public class MountainBike extends MechanicBike {

	private static final long serialVersionUID = 7424177025282800086L;
	private int forkMove;
	private boolean diskBrake;

	public MountainBike(int id, double weight, double height, String frameMaterial, int price, int year, String model,
			int speedNumber, String brakseType, int forkMove, boolean diskBrake) {
		super(id, weight, height, frameMaterial, price, year, model, speedNumber, brakseType, "Pedal Power");
		this.forkMove = forkMove;
		this.diskBrake = diskBrake;
	}

	public MountainBike() {
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		MountainBike other = (MountainBike) obj;
		return getFrameMaterial().equals(other.getFrameMaterial()) && getSpeedNumber() == other.getSpeedNumber()
				&& getForkMove() == other.getForkMove() && getModel().equals(other.getModel())
				&& getMoveType().equals(other.getMoveType());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (diskBrake ? 1231 : 1237);
		result = prime * result + forkMove;
		return result;
	}

	public int getForkMove() {
		return forkMove;
	}

	public boolean isDiskBrake() {
		return diskBrake;
	}

	public void setDiskBrake(boolean diskBrake) {
		this.diskBrake = diskBrake;
	}

	public void setForkMove(int forkMove) {
		this.forkMove = forkMove;
	}

	@Override
	public String toString() {
		return "MountainBike [id" + getId() + ", weight=" + getWeight() + ", height=" + getHeight() + ", price="
				+ getPrice() + ", year=" + getYear() + ", model=" + getModel() + ", frameMaterial=" + getFrameMaterial()
				+ ", speedNumber=" + getSpeedNumber() + ", brakesType=" + getBrakesType() + ", moveType="
				+ getMoveType() + ", forkMove" + forkMove + ", diskBrake=" + diskBrake + "]";
	}

	@Override
	public void parse(String s) {
		String[] elements = s.split(" ");
		int i = 0;
		this.setId(Integer.parseInt(elements[i++]));
		this.setWeight(Double.parseDouble(elements[i++]));
		this.setHeight(Double.parseDouble(elements[i++]));
		this.setPrice(new BigDecimal(elements[i++]));
		this.setYear(Integer.parseInt(elements[i++]));
		this.setModel(elements[i++]);
		this.setFrameMaterial(elements[i++]);
		this.setSpeedNumber(Integer.parseInt(elements[i++]));
		this.setBrakesType(elements[i++]);
		this.setMoveType(elements[i++]);
		this.setForkMove(Integer.parseInt(elements[i++]));
		this.setDiskBrake(Boolean.parseBoolean(elements[i++]));
	}

	@Override
	public void random() {
		Random r = new Random();
		this.setId(r.nextInt(1000));
		this.setWeight(r.nextDouble());
		this.setHeight(r.nextDouble());
		this.setPrice(new BigDecimal(r.nextInt(10000)));
		this.setYear(r.nextInt(100) + 1915);
		this.setModel("Model" + r.nextInt(100));
		this.setFrameMaterial("Material" + r.nextInt(10));
		this.setSpeedNumber(r.nextInt(10));
		this.setBrakesType("hand");
		this.setMoveType("pedals");
		this.setForkMove(r.nextInt(10));
		this.setDiskBrake(r.nextBoolean());
	}

	@Override
	public String getExample() {
		return "MountainBike [id, weight, height, price, year, model, frameMaterial, speedNumber, brakesType, moveType, forkMove, diskBrake]";
	}

}
