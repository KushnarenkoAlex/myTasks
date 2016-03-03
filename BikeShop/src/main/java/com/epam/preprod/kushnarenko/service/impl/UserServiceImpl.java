package main.java.com.epam.preprod.kushnarenko.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import org.apache.log4j.Logger;

import main.java.com.epam.preprod.kushnarenko.dao.UserDAO;
import main.java.com.epam.preprod.kushnarenko.db.transaction.ITransactionManager;
import main.java.com.epam.preprod.kushnarenko.db.transaction.ITransactionOperation;
import main.java.com.epam.preprod.kushnarenko.entity.User;
import main.java.com.epam.preprod.kushnarenko.service.UserService;

/**
 * Implementation for UserService
 * 
 * @author Oleksandr_Kushnarenk
 *
 */
public class UserServiceImpl implements UserService {

    private final static Logger logger = Logger.getLogger(UserServiceImpl.class.getName());

    private ITransactionManager manager;
    private UserDAO userRep;

    private short blockingTimeInMinutes;

    public UserServiceImpl(ITransactionManager itm, UserDAO dao, Short blockingTimeInMinutes) {
        this.userRep = dao;
        this.manager = itm;
        this.blockingTimeInMinutes = blockingTimeInMinutes;
    }

    @Override
    public boolean create(User entity) {
        logger.debug("Creating new user operation started");
        logger.debug(String.format("User :%s", entity));
        return manager.execute(new ITransactionOperation<Boolean>() {

            @Override
            public Boolean execute(Connection con) throws SQLException {
                boolean b = (entity == null) ? false : userRep.add(entity, con);
                return b;
            }
        });
    }

    @Override
    public boolean exists(User entity) {
        logger.debug(String.format("Checking user on existing User:%s", entity));
        return manager.execute(new ITransactionOperation<Boolean>() {

            @Override
            public Boolean execute(Connection con) throws SQLException {
                return userRep.userExists(entity.getEmail(), con);
            }

        });
    }

    @Override
    public User login(String email, String password) {
        logger.debug(String.format("Logining user with email %s", email));
        return manager.execute(new ITransactionOperation<User>() {
            @Override
            public User execute(Connection con) throws SQLException {
                User u = userRep.getEntityByEmail(email, con);
                if (u == null) {
                    return null;
                }
                if (!u.getPassword().equals(password)) {
                    userRep.updateUnsuccessLoginTriesCount(u.getId(), u.getUnsuccessTriesCount() + 1, con);
                    userRep.updateUnblockingTime(new Date().getTime() + blockingTimeInMinutes * 1000 * 60, u.getId(),
                            con);
                    return null;
                }
                userRep.updateUnsuccessLoginTriesCount(u.getId(), 0, con);
                return u;
            }
        });
    }

}
