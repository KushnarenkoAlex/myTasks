package com.epam.preprod.kushnarenko.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import com.epam.preprod.kushnarenko.annotation.MyAnno;

public abstract class Product implements Serializable {

	private static final long serialVersionUID = 7951278743731453493L;

	private Integer id;
	private BigDecimal price;

	public Product() {
	}

	public Product(Integer id, BigDecimal price) {
		this.id = id;
		this.price = price;
	}

	@MyAnno(key = "ID")
	public Integer getId() {
		return id;
	}

	@MyAnno(key = "PRICE")
	public BigDecimal getPrice() {
		return price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		return result;
	}

	@MyAnno(key = "ID")
	public void setId(Integer id) {
		this.id = id;
	}

	@MyAnno(key = "PRICE")
	public void setPrice(BigDecimal price) {
		this.price = price;
	}


	public abstract String getExample();

	public abstract void parse(String s);

	public abstract void random();

}
