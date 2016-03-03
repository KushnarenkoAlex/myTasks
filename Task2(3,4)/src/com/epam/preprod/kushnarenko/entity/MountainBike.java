package com.epam.preprod.kushnarenko.entity;

public class MountainBike extends MechanicBike {

	private static final long serialVersionUID = 7424177025282800086L;
	private int forkMove;
	private boolean diskBrake;

	public MountainBike() {
	}

	public MountainBike(int id, double weight, double height, String frameMaterial, int price, int year, String model,
			int speedNumber, String brakseType, int forkMove, boolean diskBrake) {
		super(id, weight, height, frameMaterial, price, year, model, speedNumber, brakseType, "Pedal Power");
		this.forkMove = forkMove;
		this.diskBrake = diskBrake;
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
}
