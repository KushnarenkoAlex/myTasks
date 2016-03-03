package main.java.com.epam.preprod.kushnarenko.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import main.java.com.epam.preprod.kushnarenko.dao.DeliveryDAO;
import main.java.com.epam.preprod.kushnarenko.db.transaction.ITransactionManager;
import main.java.com.epam.preprod.kushnarenko.db.transaction.ITransactionOperation;
import main.java.com.epam.preprod.kushnarenko.entity.Delivery;
import main.java.com.epam.preprod.kushnarenko.service.DeliveryService;

/**
 * Implementation for DeliveryService
 * 
 * @author Oleksandr_Kushnarenk
 *
 */
public class DeliveryServiceImpl implements DeliveryService {

    private final static Logger logger = Logger.getLogger(DeliveryServiceImpl.class.getName());

    private ITransactionManager manager;
    private DeliveryDAO deliveryRep;

    public DeliveryServiceImpl(ITransactionManager itm, DeliveryDAO deliveryRep) {
        this.manager = itm;
        this.deliveryRep = deliveryRep;
    }

    @Override
    public List<Delivery> getDeliveryList() {
        logger.debug("Getting list of deliveries");
        return manager.execute(new ITransactionOperation<List<Delivery>>() {

            @Override
            public List<Delivery> execute(Connection con) throws SQLException {
                return deliveryRep.getAll(con);
            }
        });
    }

    @Override
    public Delivery getDelivery(Long delivery) {
        return manager.execute(new ITransactionOperation<Delivery>() {

            @Override
            public Delivery execute(Connection con) throws SQLException {
                return deliveryRep.getEntityById(delivery, con);
            }
        });
    }

}
