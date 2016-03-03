package com.epam.preprod.kushnarenko.entity;

import java.math.BigDecimal;

public interface IProduct {

	public Integer getId();

	public BigDecimal getPrice();

	public void setId(Integer id);

	public void setPrice(BigDecimal price);

}
