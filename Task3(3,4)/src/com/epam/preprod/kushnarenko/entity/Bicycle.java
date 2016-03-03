package com.epam.preprod.kushnarenko.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public abstract class Bicycle extends Product implements Serializable {

	private static final long serialVersionUID = 2920166659122080806L;
	private double weight;
	private double height;
	private int year;
	private String model;
	private String frameMaterial;

	public Bicycle() {
	}

	public Bicycle(int id, double weight, double height, String frameMaterial, int price, int year, String model) {
		super(id, new BigDecimal(price));
		this.height = height;
		this.weight = weight;
		this.frameMaterial = frameMaterial;
		this.year = year;
		this.model = model;
	}

	public String getFrameMaterial() {
		return frameMaterial;
	}

	public double getHeight() {
		return height;
	}

	public String getModel() {
		return model;
	}

	public double getWeight() {
		return weight;
	}

	public int getYear() {
		return year;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((frameMaterial == null) ? 0 : frameMaterial.hashCode());
		result = prime * result + (int) height;
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + (int) weight;
		result = prime * result + year;
		return result;
	}

	public void setFrameMaterial(String frameMaterial) {
		this.frameMaterial = frameMaterial;
	}

	public void setHeight(double d) {
		this.height = d;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setWeight(double d) {
		this.weight = d;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Bicycle [id" + getId() + ", weight=" + weight + ", height=" + height + ", price=" + getPrice()
				+ ", year=" + year + ", model=" + model + ", frameMaterial=" + frameMaterial + "]";
	}

}
