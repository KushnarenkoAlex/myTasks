package main.java.com.epam.preprod.kushnarenko.dao;

import java.sql.Connection;
import java.util.List;

import main.java.com.epam.preprod.kushnarenko.entity.Order;

/**
 * This interface represents DAO that extend GenericDAP and parametrise it with
 * Order entity.
 * 
 * @author Oleksandr_Kushnarenk
 *
 */
public interface OrderDAO extends GenericDAO<Order, Long> {

    List<Order> getAll(Connection con);

    Order getEntityById(Long id, Connection con);

    Order update(Order entity, Connection con);

    boolean delete(Long id, Connection con);

    boolean add(Order u, Connection con);

}