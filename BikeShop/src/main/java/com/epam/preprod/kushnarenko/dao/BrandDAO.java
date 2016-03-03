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
public interface BrandDAO extends GenericDAO<Brand, Long> {

    List<Brand> getAll(Connection con);

    Brand getEntityById(Long id, Connection con);

    Brand update(Brand entity, Connection con);

    boolean delete(Long id, Connection con);

    boolean add(Brand u, Connection con);

}