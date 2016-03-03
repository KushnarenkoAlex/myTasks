package main.java.com.epam.preprod.kushnarenko.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import main.java.com.epam.preprod.kushnarenko.constants.Const;
import main.java.com.epam.preprod.kushnarenko.constants.Path;
import main.java.com.epam.preprod.kushnarenko.dao.PaymentDAO;
import main.java.com.epam.preprod.kushnarenko.entity.Payment;

/**
 * Implementation for PaymentDAO
 * 
 * @author Oleksandr_Kushnarenk
 *
 */
public class PaymentDAOImpl implements PaymentDAO {

    private final static Logger logger = Logger.getLogger(PaymentDAOImpl.class);
    private static final ResourceBundle RES_BUN = ResourceBundle.getBundle(Path.SQL_RESOURCES);

    /**
     * Unsupported for this implementation.
     */
    @Override
    public boolean delete(Long id, Connection con) {
        throw new UnsupportedOperationException();
    }

    public Payment extractPayment(ResultSet rs) throws SQLException {
        Payment p = new Payment();
        p.setId(rs.getLong("id"));
        p.setName(rs.getString("name"));
        return p;
    }

    @Override
    public List<Payment> getAll(Connection con) {
        logger.debug("GetAll payments operation");
        List<Payment> res = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(RES_BUN.getString(Const.FIND_ALL_PAYMENTS));
            rs = pstmt.executeQuery();
            while (rs.next()) {
                res.add(extractPayment(rs));
            }
        } catch (SQLException e) {
            logger.error("SQL exception in getAllPayments ");
        }
        return res;
    }

    @Override
    public Payment getEntityById(Long id, Connection con) {
        Payment payment = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(RES_BUN.getString(Const.GET_PAYMENT_BY_ID));
            pstmt.setLong(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                payment = extractPayment(rs);
            }
        } catch (SQLException e) {
            logger.error("SQL exception in getAllPayments ");
        }
        return payment;
    }

    /**
     * Unsupported for this implementation.
     */
    @Override
    public Payment update(Payment entity, Connection con) {
        throw new UnsupportedOperationException();
    }

    /**
     * Unsupported for this implementation.
     */
    @Override
    public boolean add(Payment u, Connection con) {
        throw new UnsupportedOperationException();
    }

}
