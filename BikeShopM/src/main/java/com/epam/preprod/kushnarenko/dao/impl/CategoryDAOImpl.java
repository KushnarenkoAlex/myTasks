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
import main.java.com.epam.preprod.kushnarenko.dao.CategoryDAO;
import main.java.com.epam.preprod.kushnarenko.entity.Category;

/**
 * Implementation for CategoryDAO
 * 
 * @author Oleksandr_Kushnarenk
 *
 */
public class CategoryDAOImpl implements CategoryDAO {

    private final static Logger logger = Logger.getLogger(CategoryDAOImpl.class);
    private static final ResourceBundle RES_BUN = ResourceBundle.getBundle(Path.SQL_RESOURCES);

    @Override
    public boolean delete(Integer id, Connection con) {
        return false;
    }

    public Category extractCategory(ResultSet rs) throws SQLException {
        Category c = new Category();
        c.setId(rs.getLong("id"));
        c.setName(rs.getString("name"));
        return c;
    }

    @Override
    public List<Category> getAll(Connection con) {
        List<Category> res = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(RES_BUN.getString(Const.FIND_ALL_CATEGORIES));
            rs = pstmt.executeQuery();
            while (rs.next()) {
                res.add(extractCategory(rs));
            }
        } catch (SQLException e) {
            logger.error("SQL exception in getAllCategories ", e);
        }
        return res;
    }

    @Override
    public Category getEntityById(Integer id, Connection con) {
        return null;
    }

    @Override
    public Category update(Category entity, Connection con) {
        return null;
    }

    @Override
    public boolean add(Category u, Connection con) {
        return false;
    }

}
