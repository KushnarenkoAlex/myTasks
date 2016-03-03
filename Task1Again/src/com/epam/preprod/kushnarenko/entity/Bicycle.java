package com.epam.preprod.kushnarenko.entity;

public class Bicycle {

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
		return "Bicycle: model-" + getModel();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	

	@Override
	public int hashCode() {
		return super.hashCode();
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
