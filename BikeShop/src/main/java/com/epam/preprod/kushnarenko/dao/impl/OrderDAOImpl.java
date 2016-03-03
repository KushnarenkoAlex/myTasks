package main.java.com.epam.preprod.kushnarenko.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import main.java.com.epam.preprod.kushnarenko.constants.Const;
import main.java.com.epam.preprod.kushnarenko.constants.Path;
import main.java.com.epam.preprod.kushnarenko.dao.OrderDAO;
import main.java.com.epam.preprod.kushnarenko.entity.Order;
import main.java.com.epam.preprod.kushnarenko.entity.OrderItem;

/**
 * Implementation for OrderDAO
 * 
 * @author Oleksandr_Kushnarenk
 *
 */
public class OrderDAOImpl implements OrderDAO {

    private final static Logger logger = Logger.getLogger(OrderDAOImpl.class);
    private static final ResourceBundle RES_BUN = ResourceBundle.getBundle(Path.SQL_RESOURCES);

    /**
     * Unsupported for this implementation.
     */
    @Override
    public boolean delete(Long id, Connection con) {
        throw new UnsupportedOperationException();
    }

    public Order extractOrder(ResultSet rs) throws SQLException {
        Order c = new Order();
        c.setId(rs.getLong("id"));
        c.setDelivery(rs.getLong("deliveryId"));
        c.setPayment(rs.getLong("paymentId"));
        c.setOrderDate(rs.getDate("date"));
        c.setStatusId(rs.getLong("statusId"));
        c.setUserId(rs.getInt("userId"));
        return c;
    }

    /**
     * Unsupported for this implementation.
     */
    @Override
    public List<Order> getAll(Connection con) {
        throw new UnsupportedOperationException();
    }

    /**
     * Unsupported for this implementation.
     */
    @Override
    public Order getEntityById(Long long1, Connection con) {
        throw new UnsupportedOperationException();
    }

    /**
     * Unsupported for this implementation.
     */
    @Override
    public Order update(Order entity, Connection con) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(Order order, Connection con) {
        logger.debug(String.format("Adding new order %s", order));
        PreparedStatement pstmt = null;
        try {
            pstmt = insertOrder(con, order);
            pstmt.executeUpdate();
            if (pstmt.executeUpdate() > 0) {
                {
                    ResultSet rs = pstmt.getGeneratedKeys();
                    if (rs.next()) {
                        order.setId(rs.getLong(1));
                    }
                }
            }
            pstmt = insertOrderItems(con, order);
            pstmt.executeBatch();
        } catch (SQLException e) {
            logger.error("SQL exception in add method", e);
            logger.info("Order wasnt added");
            return false;
        }
        logger.info(String.format("New order %s was added", order));
        return true;
    }

    private PreparedStatement insertOrderItems(Connection con, Order order) throws SQLException {
        PreparedStatement pStatement = con.prepareStatement(RES_BUN.getString(Const.INSERT_ORDERITEM));
        for (OrderItem oi : order.getItems()) {
            pStatement.setBigDecimal(1, oi.getActualPrice());
            pStatement.setLong(2, oi.getProductId());
            pStatement.setLong(3, order.getId());
            pStatement.setInt(4, oi.getQuantity());
            pStatement.addBatch();
        }
        return pStatement;
    }

    private PreparedStatement insertOrder(Connection con, Order order) throws SQLException {
        PreparedStatement pstmt = con.prepareStatement(RES_BUN.getString(Const.INSERT_ORDER));
        pstmt.setInt(1, order.getUserId());
        pstmt.setLong(2, order.getDelivery());
        pstmt.setLong(3, order.getPayment());
        return pstmt;
    }

}
