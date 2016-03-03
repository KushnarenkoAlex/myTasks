package main.java.com.epam.preprod.kushnarenko.utils;

import main.java.com.epam.preprod.kushnarenko.bean.RegistrationUserBean;
import main.java.com.epam.preprod.kushnarenko.entity.User;

public class Transformer {

	public User getUser(RegistrationUserBean rub) {
		User u = new User();
		u.setFirstName(rub.getFirstName());
		u.setLastName(rub.getLastName());
		u.setPassword(rub.getPassword());
		u.setEmail(rub.getEmail());
		u.setPhoneNumber(rub.getPhoneNumber());
		Boolean b = (rub.getSpam() == null) ? false : true;
		u.setSpam(b);
		return u;
	}

}
