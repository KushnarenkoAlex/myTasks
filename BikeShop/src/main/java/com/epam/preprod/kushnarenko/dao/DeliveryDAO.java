package main.java.com.epam.preprod.kushnarenko.dao;

import java.sql.Connection;
import java.util.List;

import main.java.com.epam.preprod.kushnarenko.entity.Delivery;

/**
 * This interface represents DAO that extend GenericDAP and parametrise it with
 * Delivery entity.
 * 
 * @author Oleksandr_Kushnarenk
 *
 */
public interface DeliveryDAO extends GenericDAO<Delivery, Long> {

    List<Delivery> getAll(Connection con);

    Delivery getEntityById(Long id, Connection con);

    Delivery update(Delivery entity, Connection con);

    boolean delete(Long id, Connection con);

    boolean add(Delivery u, Connection con);

}