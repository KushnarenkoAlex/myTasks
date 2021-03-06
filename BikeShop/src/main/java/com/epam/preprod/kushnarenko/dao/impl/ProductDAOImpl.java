package main.java.com.epam.preprod.kushnarenko.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import main.java.com.epam.preprod.kushnarenko.bean.FilteringCriteria;
import main.java.com.epam.preprod.kushnarenko.constants.Const;
import main.java.com.epam.preprod.kushnarenko.constants.Path;
import main.java.com.epam.preprod.kushnarenko.dao.ProductDAO;
import main.java.com.epam.preprod.kushnarenko.entity.Product;
import main.java.com.epam.preprod.kushnarenko.exception.DbCallException;

/**
 * Implementation for ProductDAO
 * 
 * @author Oleksandr_Kushnarenk
 *
 */
public class ProductDAOImpl implements ProductDAO {

    private final static Logger logger = Logger.getLogger(ProductDAOImpl.class);
    private static final ResourceBundle RES_BUN = ResourceBundle.getBundle(Path.SQL_RESOURCES);

    /**
     * Unsupported for this implementation.
     */
    @Override
    public boolean add(Product entity, Connection con) {
        throw new UnsupportedOperationException();
    }

    /**
     * Unsupported for this implementation.
     */
    @Override
    public boolean delete(Long id, Connection con) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Product> getAll(Connection con) {
        logger.debug("GetAll products operation");
        List<Product> products = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(RES_BUN.getString(Const.FIND_ALL_PRODUCTS));
            rs = pstmt.executeQuery();
            while (rs.next()) {
                products.add(extractProduct(rs));
            }
        } catch (SQLException e) {
            logger.error("SQL exception in getall products operation");
        }
        return products;
    }

    @Override
    public Product getEntityById(Long id, Connection con) {
        Product product = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(RES_BUN.getString(Const.GET_PRODUCT_BY_ID));
            pstmt.setLong(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                product = extractProduct(rs);
            }
        } catch (SQLException e) {
            logger.error("SQL exception in getEntityById products operation");
        }
        return product;
    }

    /**
     * Unsupported for this implementation.
     */
    @Override
    public Product update(Product entity, Connection con) {
        throw new UnsupportedOperationException();
    }

    private Product extractProduct(ResultSet rs) throws SQLException {
        Product product = new Product();
        product.setId(rs.getLong("id"));
        product.setName(rs.getString("name"));
        product.setPrice(rs.getBigDecimal("price"));
        product.setBrandId(rs.getLong("brandId"));
        product.setCategoryId(rs.getLong("categoryId"));
        product.setPicture(rs.getString("picture"));
        return product;
    }

    @Override
    public BigDecimal getMaxPrice(Connection con) {
        BigDecimal res = new BigDecimal(0);
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(RES_BUN.getString(Const.GET_MAX_PRICE));
            rs = pstmt.executeQuery();
            if (rs.next()) {
                res = rs.getBigDecimal("max");
            }
        } catch (SQLException e) {
            logger.error("SQL exception in getall products operation");
            throw new DbCallException(Const.INCORRECT_QUERY);
        }
        return res;
    }

    @Override
    public BigDecimal getMinPrice(Connection con) {
        BigDecimal res = new BigDecimal(0);
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(RES_BUN.getString(Const.GET_MIN_PRICE));
            rs = pstmt.executeQuery();
            if (rs.next()) {
                res = rs.getBigDecimal("min");
            }
        } catch (SQLException e) {
            logger.error("SQL exception in getall products operation");
        }
        return res;
    }

    @Override
    public List<Product> getAllByCriteria(FilteringCriteria filteringCriteria, Connection con) {
        List<Product> products = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String query = filteringCriteria.createQueryWithLimit().toString();
            logger.debug(String.format("Get by criteria query: %s", query));
            pstmt = con.prepareStatement(query);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                products.add(extractProduct(rs));
            }
        } catch (SQLException e) {
            logger.error("SQL exception in getAllByCriteria products operation");
        }
        return products;
    }

    @Override
    public Integer getCount(Connection con) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Integer count = 0;
        try {
            pstmt = con.prepareStatement(RES_BUN.getString(Const.GET_PRODUCT_COUNT));
            rs = pstmt.executeQuery();
            if (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (SQLException e) {
            logger.error("SQL exception in getall products operation");
        }
        return count;
    }

    @Override
    public List<Product> getFilteredProducts(FilteringCriteria filteringCriteria, Connection con) {
        List<Product> products = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(filteringCriteria.createQueryWithoutLimit().toString());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                products.add(extractProduct(rs));
            }
        } catch (SQLException e) {
            logger.error("SQL exception in getAllByCriteria products operation");
        }
        return products;
    }

}
