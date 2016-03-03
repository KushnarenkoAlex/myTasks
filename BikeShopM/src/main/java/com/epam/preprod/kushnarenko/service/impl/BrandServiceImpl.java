package main.java.com.epam.preprod.kushnarenko.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import main.java.com.epam.preprod.kushnarenko.dao.BrandDAO;
import main.java.com.epam.preprod.kushnarenko.db.transaction.ITransactionManager;
import main.java.com.epam.preprod.kushnarenko.db.transaction.ITransactionOperation;
import main.java.com.epam.preprod.kushnarenko.entity.Brand;
import main.java.com.epam.preprod.kushnarenko.service.BrandService;

public class BrandServiceImpl implements BrandService {

    private final static Logger logger = Logger.getLogger(BrandServiceImpl.class.getName());

    ITransactionManager manager;
    BrandDAO brandRep;

    public BrandServiceImpl(ITransactionManager itm, BrandDAO brandRep) {
        this.manager = itm;
        this.brandRep = brandRep;
    }

    /*
     * (non-Javadoc)
     * 
     * @see main.java.com.epam.preprod.kushnarenko.service.impl.BrandService#
     * getBrandList()
     */
    @Override
    public List<Brand> getBrandList() {
        logger.info("Getting list of brands");
        return manager.execute(new ITransactionOperation<List<Brand>>() {

            @Override
            public List<Brand> execute(Connection con) throws SQLException {
                return brandRep.getAll(con);
            }
        });
    }

}
