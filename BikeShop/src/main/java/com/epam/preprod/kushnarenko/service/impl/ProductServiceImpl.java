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

/**
 * Implementation for ProductService
 * 
 * @author Oleksandr_Kushnarenk
 *
 */
public class ProductServiceImpl implements ProductService {

    private final static Logger logger = Logger.getLogger(ProductServiceImpl.class.getName());

    private ITransactionManager manager;
    private ProductDAO prodRep;

    public ProductServiceImpl(ITransactionManager itm, ProductDAO prodRep) {
        this.manager = itm;
        this.prodRep = prodRep;
    }

    @Override
    public List<Product> getProductList() {
        logger.debug("Getting list of products");
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

    @Override
    public Product getProductById(Long id) {
        return manager.execute(new ITransactionOperation<Product>() {

            @Override
            public Product execute(Connection con) throws SQLException {
                return prodRep.getEntityById(id, con);
            }
        });
    }

}
