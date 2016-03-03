package main.java.com.epam.preprod.kushnarenko.service;

import main.java.com.epam.preprod.kushnarenko.entity.User;

public interface UserService {

    boolean create(User entity);

    /**
     * Checks if User exists.
     * 
     * @param entity
     */
    boolean exists(User entity);

    /**
     * This method get user from database and checks if password is correct. If
     * its OK - returns User, else returns null.
     * 
     * @param email
     * @param password
     */
    User login(String email, String password);
}