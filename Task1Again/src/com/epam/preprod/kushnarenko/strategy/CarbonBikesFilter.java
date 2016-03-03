package com.epam.preprod.kushnarenko.strategy;

import com.epam.preprod.kushnarenko.entity.Bicycle;

public class CarbonBikesFilter implements FilterIterator {

	@Override
	public <E extends Bicycle> boolean correct(E container) {
		return false;
	}

}
