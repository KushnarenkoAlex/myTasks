package main.java.com.epam.preprod.kushnarenko.service.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import main.java.com.epam.preprod.kushnarenko.bean.FilteringCriteria;
import main.java.com.epam.preprod.kushnarenko.dao.ProductDAO;
import main.java.com.epam.preprod.kushnarenko.db.transaction.ITransactionManager;
import main.java.com.epam.preprod.kushnarenko.db.transaction.ITransactionOperation;
import main.java.com.epam.preprod.kushnarenko.entity.Product;
import main.java.com.epam.preprod.kushnarenko.service.ProductService;

public class ProductServiceImpl implements ProductService {

    private final static Logger logger = Logger.getLogger(ProductServiceImpl.class.getName());

    ITransactionManager manager;
    ProductDAO prodRep;

    public ProductServiceImpl(ITransactionManager itm, ProductDAO prodRep) {
        this.manager = itm;
        this.prodRep = prodRep;
    }

    /*
     * (non-Javadoc)
     * 
     * @see main.java.com.epam.preprod.kushnarenko.service.impl.ProductService#
     * getProductList()
     */
    @Override
    public List<Product> getProductList() {
        logger.info("Getting list of products");
        return manager.execute(new ITransactionOperation<List<Product>>() {

            @Override
            public List<Product> execute(Connection con) throws SQLException {
                return prodRep.getAll(con);
            }
        });
    }

    @Override
    public BigDecimal getMaxPrice() {
        return manager.execute(new ITransactionOperation<BigDecimal>() {

            @Override
            public BigDecimal execute(Connection con) throws SQLException {
                return prodRep.getMaxPrice(con);
            }
        });
    }

    @Override
    public BigDecimal getMinPrice() {
        return manager.execute(new ITransactionOperation<BigDecimal>() {

            @Override
            public BigDecimal execute(Connection con) throws SQLException {
                return prodRep.getMinPrice(con);
            }
        });
    }

    @Override
    public List<Product> getProductListByCriteria(FilteringCriteria filteringCriteria) {
        return manager.execute(new ITransactionOperation<List<Product>>() {

            @Override
            public List<Product> execute(Connection con) throws SQLException {
                return prodRep.getAllByCriteria(filteringCriteria, con);
            }
        });
    }

    @Override
    public Integer getProductCount() {
        return manager.execute(new ITransactionOperation<Integer>() {

            @Override
            public Integer execute(Connection con) throws SQLException {
                return prodRep.getCount(con);
            }
        });
    }

    @Override
    public Integer getFilteredProductCount(FilteringCriteria filteringCriteria) {
        return manager.execute(new ITransactionOperation<Integer>() {

            @Override
            public Integer execute(Connection con) throws SQLException {
                return prodRep.getFilteredProducts(filteringCriteria, con).size();
            }
        });
    }

}
