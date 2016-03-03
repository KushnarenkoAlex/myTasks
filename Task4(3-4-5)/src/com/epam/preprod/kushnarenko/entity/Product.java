package com.epam.preprod.kushnarenko.entity;

import java.lang.reflect.Proxy;
import java.math.BigDecimal;

public class Product implements IProduct {

	private Integer id;
	private BigDecimal price;

	public Product() {
		id = 0;
		price = new BigDecimal(0);
	}

	public Product(Integer id, BigDecimal price) {
		this.id = id;
		this.price = price;
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public BigDecimal getPrice() {
		return price;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public IProduct getProxy() {
		return (IProduct) Proxy.newProxyInstance(IProduct.class.getClassLoader(), new Class[] { IProduct.class },
				new MyHanler(this));
	}
}
