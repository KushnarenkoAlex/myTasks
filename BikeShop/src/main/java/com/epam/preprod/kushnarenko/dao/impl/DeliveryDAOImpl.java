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
import main.java.com.epam.preprod.kushnarenko.dao.DeliveryDAO;
import main.java.com.epam.preprod.kushnarenko.entity.Delivery;

/**
 * Implementation for DeliveryDAO
 * 
 * @author Oleksandr_Kushnarenk
 *
 */
public class DeliveryDAOImpl implements DeliveryDAO {

    private final static Logger logger = Logger.getLogger(DeliveryDAOImpl.class);
    private static final ResourceBundle RES_BUN = ResourceBundle.getBundle(Path.SQL_RESOURCES);

    /**
     * Unsupported for this implementation.
     */
    @Override
    public boolean delete(Long id, Connection con) {
        throw new UnsupportedOperationException();
    }

    public Delivery extractDelivery(ResultSet rs) throws SQLException {
        Delivery d = new Delivery();
        d.setId(rs.getLong("id"));
        d.setName(rs.getString("name"));
        return d;
    }

    @Override
    public List<Delivery> getAll(Connection con) {
        logger.debug("GetAll deliveries operation");
        List<Delivery> res = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(RES_BUN.getString(Const.FIND_ALL_DELIVERIES));
            rs = pstmt.executeQuery();
            while (rs.next()) {
                res.add(extractDelivery(rs));
            }
        } catch (SQLException e) {
            logger.error("SQL exception in getAllDeliveries ");
        }
        return res;
    }

    @Override
    public Delivery getEntityById(Long id, Connection con) {
        Delivery delivery = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(RES_BUN.getString(Const.GET_DELIVERY_BY_ID));
            pstmt.setLong(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                delivery = extractDelivery(rs);
            }
        } catch (SQLException e) {
            logger.error("SQL exception in getAllPayments ");
        }
        return delivery;
    }

    /**
     * Unsupported for this implementation.
     */
    @Override
    public Delivery update(Delivery entity, Connection con) {
        throw new UnsupportedOperationException();
    }

    /**
     * Unsupported for this implementation.
     */
    @Override
    public boolean add(Delivery u, Connection con) {
        throw new UnsupportedOperationException();
    }

}
