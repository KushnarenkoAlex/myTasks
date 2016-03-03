package com.epam.preprod.kushnarenko.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import com.epam.preprod.kushnarenko.annotation.MyAnno;

public abstract class Bicycle extends Product implements Serializable {

	private static final long serialVersionUID = 2920166659122080806L;

	private Double weight;
	private Double height;
	private Integer year;
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

	@MyAnno(key = "FRAME_MATERIAL")
	public String getFrameMaterial() {
		return frameMaterial;
	}

	@MyAnno(key = "HEIGHT")
	public Double getHeight() {
		return height;
	}

	@MyAnno(key = "MODEL")
	public String getModel() {
		return model;
	}

	@MyAnno(key = "WEIGHT")
	public Double getWeight() {
		return weight;
	}

	@MyAnno(key = "YEAR")
	public Integer getYear() {
		return year;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((frameMaterial == null) ? 0 : frameMaterial.hashCode());
		result = prime * result + height.intValue();
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + weight.intValue();
		result = prime * result + year;
		return result;
	}

	@MyAnno(key = "FRAME_MATERIAL")
	public void setFrameMaterial(String frameMaterial) {
		this.frameMaterial = frameMaterial;
	}

	@MyAnno(key = "HEIGHT")
	public void setHeight(Double d) {
		this.height = d;
	}

	@MyAnno(key = "MODEL")
	public void setModel(String model) {
		this.model = model;
	}

	@MyAnno(key = "WEIGHT")
	public void setWeight(Double d) {
		this.weight = d;
	}

	@MyAnno(key = "YEAR")
	public void setYear(Integer year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Bicycle [id" + getId() + ", weight=" + weight + ", height=" + height + ", price=" + getPrice()
				+ ", year=" + year + ", model=" + model + ", frameMaterial=" + frameMaterial + "]";
	}

}
