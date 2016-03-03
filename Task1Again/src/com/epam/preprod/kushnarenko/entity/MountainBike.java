package com.epam.preprod.kushnarenko.entity;

public class MountainBike extends MechanicBike {

	private int forkMove;

	private boolean diskBrake;

	public MountainBike() {
	}

	public MountainBike(int weight, int height, String frameMaterial, int price, int year, String model,
			int speedNumber, String brakseType, int forkMove, boolean diskBrake) {
		super(weight, height, frameMaterial, price, year, model, speedNumber, brakseType, "Pedal Power");
		this.forkMove = forkMove;
		this.diskBrake = diskBrake;
	}

	@Override
	public String toString() {
		return "MountainBike: model-" + getModel();
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	public int getForkMove() {
		return forkMove;
	}

	public void setForkMove(int forkMove) {
		this.forkMove = forkMove;
	}

	public boolean isDiskBrake() {
		return diskBrake;
	}

	public void setDiskBrake(boolean diskBrake) {
		this.diskBrake = diskBrake;
	}
}
