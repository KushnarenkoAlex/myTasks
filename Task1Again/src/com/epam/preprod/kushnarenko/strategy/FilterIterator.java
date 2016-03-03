package com.epam.preprod.kushnarenko.strategy;

import com.epam.preprod.kushnarenko.entity.Bicycle;

public interface FilterIterator {
	public <E extends Bicycle> boolean correct(E container);
}
