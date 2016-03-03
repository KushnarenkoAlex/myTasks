package main.java.com.epam.preprod.kushnarenko.dao;

import java.sql.Connection;
import java.util.List;

import main.java.com.epam.preprod.kushnarenko.entity.User;

/**
 * This interface represents DAO that extend GenericDAP and parametrise it with
 * User entity.
 * 
 * @author Oleksandr_Kushnarenk
 *
 */
public interface UserDAO extends GenericDAO<User, Integer> {

    /**
     * This method allows to get list of all users.
     */
    List<User> getAll(Connection con);

    /**
     * This method allows to get user by his ID.
     */
    User getEntityById(Integer id, Connection con);

    /**
     * This method allows to check existing of user by email(1 email - 1 user).
     */
    boolean userExists(String email, Connection con);

    User getEntityByEmail(String email, Connection con);

    User update(User entity, Connection con);

    boolean delete(Integer id, Connection con);

    boolean add(User u, Connection con);

}