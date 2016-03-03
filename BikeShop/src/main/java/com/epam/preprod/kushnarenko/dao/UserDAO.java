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

    List<User> getAll(Connection con);

    User getEntityById(Integer id, Connection con);

    /**
     * This method allows to check existing of user by email(1 email - 1 user).
     * 
     * @param email
     *            - email of checked User.
     * @param con
     * @return
     */
    boolean userExists(String email, Connection con);

    /**
     * Find User in database by email.
     * 
     * @param email
     *            - of User to find.
     * @param con
     * @return
     */
    User getEntityByEmail(String email, Connection con);

    User update(User entity, Connection con);

    boolean delete(Integer id, Connection con);

    boolean add(User u, Connection con);

    /**
     * Allows to update count of times when user tried to login.
     * 
     * @param userId
     *            - id of user to update
     * @param unsuccessLoginTriesCount
     *            - count of tries that user executed to login awry
     * @param con
     */
    void updateUnsuccessLoginTriesCount(Integer userId, Integer unsuccessLoginTriesCount, Connection con);

    /**
     * Allows to update times when blocked user must be unblocked.
     * 
     * @param l
     *            - time when user can be unblock in milliseconds
     * @param userId
     *            - id of user to update
     * @param con
     */
    void updateUnblockingTime(Long l, Integer userId, Connection con);

}