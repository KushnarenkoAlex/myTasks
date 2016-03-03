package main.java.com.epam.preprod.kushnarenko.dao;

import java.sql.Connection;
import java.util.List;

import main.java.com.epam.preprod.kushnarenko.entity.Brand;

/**
 * This interface represents DAO that extend GenericDAP and parametrise it with
 * Brand entity.
 * 
 * @author Oleksandr_Kushnarenk
 *
 */
public interface BrandDAO extends GenericDAO<Brand, Integer> {

    /**
     * This method allows to get list of all brands.
     */
    List<Brand> getAll(Connection con);

    /**
     * This method allows to get brand by it's ID.
     */
    Brand getEntityById(Integer id, Connection con);

    Brand update(Brand entity, Connection con);

    boolean delete(Integer id, Connection con);

    boolean add(Brand u, Connection con);

}