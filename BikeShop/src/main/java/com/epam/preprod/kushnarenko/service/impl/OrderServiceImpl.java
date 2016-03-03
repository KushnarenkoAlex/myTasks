package main.java.com.epam.preprod.kushnarenko.service.impl;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import main.java.com.epam.preprod.kushnarenko.dao.OrderDAO;
import main.java.com.epam.preprod.kushnarenko.db.transaction.ITransactionManager;
import main.java.com.epam.preprod.kushnarenko.db.transaction.ITransactionOperation;
import main.java.com.epam.preprod.kushnarenko.entity.Order;
import main.java.com.epam.preprod.kushnarenko.service.OrderService;

/**
 * Implementation for OrderService
 * 
 * @author Oleksandr_Kushnarenk
 *
 */
public class OrderServiceImpl implements OrderService {

    private final static Logger logger = Logger.getLogger(OrderServiceImpl.class.getName());

    private ITransactionManager manager;
    private OrderDAO orderRep;

    public OrderServiceImpl(ITransactionManager itm, OrderDAO dao) {
        this.orderRep = dao;
        this.manager = itm;
    }

    @Override
    public boolean create(Order entity) {
        logger.debug("Creating new Order operation started");
        logger.debug(String.format("Order :%s", entity));
        return manager.executeTransaction(new ITransactionOperation<Boolean>() {

            @Override
            public Boolean execute(Connection con) throws SQLException {
                boolean b = (entity == null) ? false : orderRep.add(entity, con);
                return b;
            }
        });
    }

}
