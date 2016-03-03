package ua.nure.serdyuk.SummaryTask4.entity.bean;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import ua.nure.serdyuk.SummaryTask4.entity.Carriage;
import ua.nure.serdyuk.SummaryTask4.entity.CarriageType;

public class CarriageListBean {

	private List<Carriage> carriages;

	public CarriageListBean(List<Carriage> carriages) {
		this.carriages = carriages;
	}

	public Set<CarriageType> getTypes() {
		Set<CarriageType> types = new TreeSet<>();
		for (Carriage c : carriages) {
			types.add(c.getType());
		}
		return types;
	}

	public List<Carriage> getCarriages() {
		return carriages;
	}

	@Override
	public String toString() {
		return "CarriageListBean [carriages=" + carriages + "]";
	}
}
