package main.java.com.epam.preprod.kushnarenko.dao;

import java.sql.Connection;
import java.util.List;

/**
 * GenericDAO interface with some CRUD operations.
 * 
 * @author Oleksandr_Kushnarenk
 *
 * @param <E>
 *            - entity
 * @param <K>
 *            - key
 */
public interface GenericDAO<E, K> {

    /**
     * Finds all entities in database.
     * 
     * @param con
     * @return list of all entities
     */
    List<E> getAll(Connection con);

    /**
     * Find entity in database by id.
     * 
     * @param id
     *            Entity id
     * @param con
     *            Connection to db
     * @return founded entity.
     */
    E getEntityById(K id, Connection con);

    /**
     * Updates entity with same id in database.
     * 
     * @param entity
     * @param con
     * @return updated entity.
     */
    E update(E entity, Connection con);

    /**
     * Deletes record from database by id.
     * 
     * @param id
     * @param con
     * @return true if record was deleted.
     */
    boolean delete(K id, Connection con);

    /**
     * Adds new record to database.
     * 
     * @param entity
     * @param con
     * @return true if entity was added to database.
     */
    boolean add(E entity, Connection con);
}