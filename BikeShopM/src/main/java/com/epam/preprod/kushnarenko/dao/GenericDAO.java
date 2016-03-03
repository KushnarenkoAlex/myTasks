package main.java.com.epam.preprod.kushnarenko.dao;

import java.sql.Connection;
import java.util.List;

/**
 * GenericDAO interface with some CRUD operations.
 * 
 * @author Oleksandr_Kushnarenk
 *
 * @param <E>
 * @param <K>
 */
public interface GenericDAO<E, K> {

    List<E> getAll(Connection con);

    E getEntityById(K id, Connection con);

    E update(E entity, Connection con);

    boolean delete(K id, Connection con);

    boolean add(E entity, Connection con);
}