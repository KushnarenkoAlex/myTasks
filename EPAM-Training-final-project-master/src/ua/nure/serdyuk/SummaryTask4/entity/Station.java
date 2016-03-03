package ua.nure.serdyuk.SummaryTask4.entity;

import java.io.Serializable;

import ua.nure.serdyuk.SummaryTask4.constants.Const;
import ua.nure.serdyuk.SummaryTask4.validation.Validation;

public class Station implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;

	@Validation(regex = Const.REGEX_NAME, message = "message.name_not_valid")
	private String name;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Station [id=" + id + ", name=" + name + "]";
	}
}
