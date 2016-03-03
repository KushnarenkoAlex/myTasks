package main.java.com.epam.preprod.kushnarenko.service;

import java.math.BigDecimal;
import java.util.List;

import main.java.com.epam.preprod.kushnarenko.bean.FilteringCriteria;
import main.java.com.epam.preprod.kushnarenko.entity.Product;

/**
 * Interface ProductService represents service for working with User entity and
 * UserDAO.
 * 
 * @author Oleksandr_Kushnarenk
 *
 */
public interface ProductService {

    List<Product> getProductList();

    BigDecimal getMaxPrice();

    BigDecimal getMinPrice();

    /**
     * This method allows to get List of all filtered by FilterCriteria products.
     */
    List<Product> getProductListByCriteria(FilteringCriteria filteringCriteria);

    /**
     * This method allows to get count of all products in database.
     */
    Integer getProductCount();

    /**
     * This method allows to get count of filtered by FilterCriteria products.
     */
    Integer getFilteredProductCount(FilteringCriteria filteringCriteria);

}