package com.epam.preprod.kushnarenko.entity;

public abstract class Bicycle {

	private int weight;
	private int height;
	private int price;
	private int year;
	private String model;
	private String frameMaterial;

	public Bicycle() {
	}

	public Bicycle(int weight, int height, String frameMaterial, int price, int year, String model) {
		this.height = height;
		this.price = price;
		this.weight = weight;
		this.frameMaterial = frameMaterial;
		this.year = year;
		this.model = model;
	}

	@Override
	public String toString() {
		return "Bicycle [weight=" + weight + ", height=" + height + ", price=" + price + ", year=" + year + ", model="
				+ model + ", frameMaterial=" + frameMaterial + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((frameMaterial == null) ? 0 : frameMaterial.hashCode());
		result = prime * result + height;
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + price;
		result = prime * result + weight;
		result = prime * result + year;
		return result;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getFrameMaterial() {
		return frameMaterial;
	}

	public void setFrameMaterial(String frameMaterial) {
		this.frameMaterial = frameMaterial;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

}
