package com.epam.preprod.kushnarenko.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public abstract class Bicycle implements Serializable {

	private static final long serialVersionUID = 2920166659122080806L;
	private int id;
	private double weight;
	private double height;
	private BigDecimal price;
	private int year;
	private String model;
	private String frameMaterial;

	public Bicycle() {
	}

	public Bicycle(int id, double weight, double height, String frameMaterial, int price, int year, String model) {
		this.id = id;
		this.height = height;
		this.price = new BigDecimal(price);
		this.weight = weight;
		this.frameMaterial = frameMaterial;
		this.year = year;
		this.model = model;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((frameMaterial == null) ? 0 : frameMaterial.hashCode());
		result = prime * result + (int) height;
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + price.intValue();
		result = prime * result + (int) weight;
		result = prime * result + year;
		return result;
	}

	public String getFrameMaterial() {
		return frameMaterial;
	}

	public double getHeight() {
		return height;
	}

	public int getId() {
		return id;
	}

	public String getModel() {
		return model;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public double getWeight() {
		return weight;
	}

	public int getYear() {
		return year;
	}

	public void setFrameMaterial(String frameMaterial) {
		this.frameMaterial = frameMaterial;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Bicycle [id" + id + ", weight=" + weight + ", height=" + height + ", price=" + price + ", year=" + year
				+ ", model=" + model + ", frameMaterial=" + frameMaterial + "]";
	}

}
