package main.java.com.epam.preprod.kushnarenko.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import main.java.com.epam.preprod.kushnarenko.dao.CategoryDAO;
import main.java.com.epam.preprod.kushnarenko.db.transaction.ITransactionManager;
import main.java.com.epam.preprod.kushnarenko.db.transaction.ITransactionOperation;
import main.java.com.epam.preprod.kushnarenko.entity.Category;
import main.java.com.epam.preprod.kushnarenko.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {

    private final static Logger logger = Logger.getLogger(CategoryServiceImpl.class.getName());

    ITransactionManager manager;
    CategoryDAO categoryRep;

    public CategoryServiceImpl(ITransactionManager itm, CategoryDAO categoryRep) {
        this.manager = itm;
        this.categoryRep = categoryRep;
    }

    @Override
    public List<Category> getCategoryList() {
        logger.info("Getting list of Category");
        return manager.execute(new ITransactionOperation<List<Category>>() {

            @Override
            public List<Category> execute(Connection con) throws SQLException {
                return categoryRep.getAll(con);
            }
        });
    }

}
