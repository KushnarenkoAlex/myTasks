package main.java.com.epam.preprod.kushnarenko.dao;

import main.java.com.epam.preprod.kushnarenko.dao.impl.UserDAOImpl;

public class DAOFactory {

    public UserDAO getUserDAO() {
        return new UserDAOImpl();
	}

}
