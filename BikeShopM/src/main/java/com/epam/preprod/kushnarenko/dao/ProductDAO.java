package main.java.com.epam.preprod.kushnarenko.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.List;

import main.java.com.epam.preprod.kushnarenko.bean.FilteringCriteria;
import main.java.com.epam.preprod.kushnarenko.entity.Product;

/**
 * This interface represents DAO that extend GenericDAP and parametrise it with
 * Product entity.
 * 
 * @author Oleksandr_Kushnarenk
 *
 */
public interface ProductDAO extends GenericDAO<Product, Long> {

    /**
     * This method allows to get list of all users.
     */
    List<Product> getAll(Connection con);

    /**
     * This method allows to get Product by his ID.
     */
    Product getEntityById(Long id, Connection con);

    Product update(Product entity, Connection con);

    boolean delete(Long id, Connection con);

    boolean add(Product u, Connection con);

    BigDecimal getMaxPrice(Connection con);

    BigDecimal getMinPrice(Connection con);

    /**
     * This method allows to get products that matches to FilterCritera and get only
     * part of result that we need with sql LIMIT function. (Useful for pagination)
     */
    List<Product> getAllByCriteria(FilteringCriteria filteringCriteria, Connection con);

    /**
     * This method allows to get ALL products that matches to FilterCritera.
     */
    List<Product> getFilteredProducts(FilteringCriteria filteringCriteria, Connection con);

    Integer getCount(Connection con);

}