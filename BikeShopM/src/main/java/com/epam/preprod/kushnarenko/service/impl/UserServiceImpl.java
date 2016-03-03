package main.java.com.epam.preprod.kushnarenko.service.impl;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import main.java.com.epam.preprod.kushnarenko.dao.UserDAO;
import main.java.com.epam.preprod.kushnarenko.db.transaction.ITransactionManager;
import main.java.com.epam.preprod.kushnarenko.db.transaction.ITransactionOperation;
import main.java.com.epam.preprod.kushnarenko.entity.User;
import main.java.com.epam.preprod.kushnarenko.service.UserService;

public class UserServiceImpl implements UserService {

    private final static Logger logger = Logger.getLogger(UserServiceImpl.class.getName());

    ITransactionManager manager;
    UserDAO userRep;

    public UserServiceImpl(ITransactionManager itm, UserDAO dao) {
        this.userRep = dao;
        this.manager = itm;
    }

    @Override
    public boolean create(User entity) {
        logger.info("Creating new user operation started");
        logger.info(String.format("User :%s", entity));
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
        logger.info(String.format("Checking user on existing User:%s", entity));
        return manager.execute(new ITransactionOperation<Boolean>() {

            @Override
            public Boolean execute(Connection con) throws SQLException {
                return userRep.userExists(entity.getEmail(), con);
            }

        });
    }

    @Override
    public User login(String email, String password) {
        logger.info(String.format("Logining user with email %s", email));
        return manager.execute(new ITransactionOperation<User>() {
            @Override
            public User execute(Connection con) throws SQLException {
                User u = userRep.getEntityByEmail(email, con);
                if (u == null) {
                    return null;
                }
                if (!u.getPassword().equals(password)) {
                    return null;
                }
                return u;
            }
        });
    }

}
