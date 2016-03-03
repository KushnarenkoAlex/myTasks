package main.java.com.epam.preprod.kushnarenko.dao;

import java.sql.Connection;
import java.util.List;

import main.java.com.epam.preprod.kushnarenko.entity.Category;

/**
 * This interface represents DAO that extend GenericDAP and parametrise it with
 * Category entity.
 * 
 * @author Oleksandr_Kushnarenk
 *
 */
public interface CategoryDAO extends GenericDAO<Category, Integer> {

    /**
     * This method allows to get list of all categories.
     */
    List<Category> getAll(Connection con);

    /**
     * This method allows to get category by it's ID.
     */
    Category getEntityById(Integer id, Connection con);

    Category update(Category entity, Connection con);

    boolean delete(Integer id, Connection con);

    boolean add(Category u, Connection con);

}