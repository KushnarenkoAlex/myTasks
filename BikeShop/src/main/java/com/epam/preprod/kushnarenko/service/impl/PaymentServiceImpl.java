package main.java.com.epam.preprod.kushnarenko.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import main.java.com.epam.preprod.kushnarenko.dao.PaymentDAO;
import main.java.com.epam.preprod.kushnarenko.db.transaction.ITransactionManager;
import main.java.com.epam.preprod.kushnarenko.db.transaction.ITransactionOperation;
import main.java.com.epam.preprod.kushnarenko.entity.Payment;
import main.java.com.epam.preprod.kushnarenko.service.PaymentService;

/**
 * Implementation for DeliveryService
 * 
 * @author Oleksandr_Kushnarenk
 *
 */
public class PaymentServiceImpl implements PaymentService {

    private final static Logger logger = Logger.getLogger(PaymentServiceImpl.class.getName());

    private ITransactionManager manager;
    private PaymentDAO paymentRep;

    public PaymentServiceImpl(ITransactionManager itm, PaymentDAO paymentRep) {
        this.manager = itm;
        this.paymentRep = paymentRep;
    }

    @Override
    public List<Payment> getPaymentList() {
        logger.debug("Getting list of payments");
        return manager.execute(new ITransactionOperation<List<Payment>>() {

            @Override
            public List<Payment> execute(Connection con) throws SQLException {
                return paymentRep.getAll(con);
            }
        });
    }

    @Override
    public Payment getPayment(Long payment) {
        return manager.execute(new ITransactionOperation<Payment>() {

            @Override
            public Payment execute(Connection con) throws SQLException {
                return paymentRep.getEntityById(payment, con);
            }
        });
    }

}
