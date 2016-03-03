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
import main.java.com.epam.preprod.kushnarenko.dao.BrandDAO;
import main.java.com.epam.preprod.kushnarenko.entity.Brand;

/**
 * Implementation for BrandDAO
 * 
 * @author Oleksandr_Kushnarenk
 *
 */
public class BrandDAOImpl implements BrandDAO {

    private final static Logger logger = Logger.getLogger(BrandDAOImpl.class);
    private static final ResourceBundle RES_BUN = ResourceBundle.getBundle(Path.SQL_RESOURCES);

    /**
     * Unsupported for this implementation.
     */
    @Override
    public boolean delete(Long id, Connection con) {
        throw new UnsupportedOperationException();
    }

    public Brand extractBrand(ResultSet rs) throws SQLException {
        Brand c = new Brand();
        c.setId(rs.getLong("id"));
        c.setName(rs.getString("name"));
        return c;
    }

    @Override
    public List<Brand> getAll(Connection con) {
        logger.debug("GetAll brands operation");
        List<Brand> res = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(RES_BUN.getString(Const.FIND_ALL_BRANDS));
            rs = pstmt.executeQuery();
            while (rs.next()) {
                res.add(extractBrand(rs));
            }
        } catch (SQLException e) {
            logger.error("SQL exception in getAllBrands", e);
        }
        return res;
    }

    /**
     * Unsupported for this implementation.
     */
    @Override
    public Brand getEntityById(Long id, Connection con) {
        throw new UnsupportedOperationException();
    }

    /**
     * Unsupported for this implementation.
     */
    @Override
    public Brand update(Brand entity, Connection con) {
        throw new UnsupportedOperationException();
    }

    /**
     * Unsupported for this implementation.
     */
    @Override
    public boolean add(Brand u, Connection con) {
        throw new UnsupportedOperationException();
    }

}
