package main.java.com.epam.preprod.kushnarenko.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import main.java.com.epam.preprod.kushnarenko.constants.Const;
import main.java.com.epam.preprod.kushnarenko.constants.Path;
import main.java.com.epam.preprod.kushnarenko.dao.UserDAO;
import main.java.com.epam.preprod.kushnarenko.entity.User;

/**
 * Implementation for UserDAO
 * 
 * @author Oleksandr_Kushnarenk
 *
 */
public class UserDAOImpl implements UserDAO {

    private final static Logger logger = Logger.getLogger(UserDAOImpl.class);
    private static final ResourceBundle RES_BUN = ResourceBundle.getBundle(Path.SQL_RESOURCES);

    /**
     * Unsupported for this implementation.
     */
    @Override
    public List<User> getAll(Connection con) {
        throw new UnsupportedOperationException();
    }

    /**
     * Unsupported for this implementation.
     */
    @Override
    public User getEntityById(Integer id, Connection con) {
        throw new UnsupportedOperationException();
    }

    /**
     * This method finds and returns User by email. If there is no user with
     * current email. Returns null value;
     * 
     */
    @Override
    public User getEntityByEmail(String email, Connection con) {
        logger.debug(String.format("Getting entity by email: %s", email));
        User user = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(RES_BUN.getString(Const.FIND_USER_BY_EMAIL));
            pstmt.setString(1, email);
            logger.debug("Executing of query " + pstmt);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                user = extractUser(rs);
            }
        } catch (SQLException e) {
            logger.error("SQL exception in getEntityByEmail");
        }
        logger.info(String.format("Returned user %s", user));
        return user;
    }

    /**
     * Unsupported for this implementation.
     */
    @Override
    public User update(User entity, Connection con) {
        throw new UnsupportedOperationException();
    }

    /**
     * Unsupported for this implementation.
     */
    @Override
    public boolean delete(Integer id, Connection con) {
        throw new UnsupportedOperationException();
    }

    /**
     * Adds new user to database and returns true if user was successfully
     * inserted.
     * 
     */
    @Override
    public boolean add(User u, Connection con) {
        logger.info(String.format("Adding new user %s", u));
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement(RES_BUN.getString(Const.INSERT_USER));
            String s = u.getFirstName();
            pstmt.setString(1, s);
            pstmt.setString(2, u.getLastName());
            pstmt.setString(3, u.getPassword());
            pstmt.setString(4, u.getEmail());
            pstmt.setString(5, u.getPhoneNumber());
            pstmt.setBoolean(6, u.getSpam());
            pstmt.setString(7, u.getPicture());
            pstmt.executeUpdate();
            if (pstmt.executeUpdate() > 0) {
                {
                    ResultSet rs = pstmt.getGeneratedKeys();
                    if (rs.next()) {
                        u.setId(rs.getInt(1));
                    }
                }
            }
        } catch (SQLException e) {
            logger.error("SQL exception in add method");
            logger.info("User wasnt added");
            return false;
        }
        logger.info("New user was added");
        return true;
    }

    @Override
    public boolean userExists(String email, Connection con) {
        logger.debug(String.format("checking existing of user with email %s was called", email));
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int res = 0;
        try {
            pstmt = con.prepareStatement(RES_BUN.getString(Const.SQL_USER_EXISTS));
            pstmt.setString(1, email);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                res = rs.getInt(1);
            }
        } catch (SQLException e) {
            logger.error("SQL exception in userExists");
        }
        return res != 0;
    }

    public User extractUser(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setFirstName(rs.getString("firstName"));
        user.setLastName(rs.getString("lastName"));
        user.setPassword(rs.getString("password"));
        user.setEmail(rs.getString("email"));
        user.setPhoneNumber(rs.getString("phoneNumber"));
        user.setSpam(rs.getBoolean("spam"));
        user.setPicture(rs.getString("picture"));
        user.setRole(rs.getString("role"));
        user.setUnblockingTime(rs.getTimestamp("unblockingTime"));
        user.setUnsuccessTriesCount(rs.getInt("unsuccessTriesCount"));
        return user;
    }

    @Override
    public void updateUnsuccessLoginTriesCount(Integer userId, Integer unsuccessLoginTriesCount, Connection con) {
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement(RES_BUN.getString(Const.SQL_UPDATE_UNSUCCESS_TRIES_COUNT));
            pstmt.setInt(1, unsuccessLoginTriesCount);
            pstmt.setInt(2, userId);
            logger.info(pstmt);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            logger.error("SQL exception in updateUnsuccessLoginTriesCount");
        }
    }

    @Override
    public void updateUnblockingTime(Long l, Integer userId, Connection con) {
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement(RES_BUN.getString(Const.SQL_UPDATE_UNBLOCKING_TIME));
            pstmt.setTimestamp(1, new Timestamp(l));
            pstmt.setInt(2, userId);
            logger.info(pstmt);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            logger.error("SQL exception in updateUnsuccessLoginTriesCount");
        }
    }

}
