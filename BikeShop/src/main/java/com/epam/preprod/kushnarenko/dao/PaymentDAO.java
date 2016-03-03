package main.java.com.epam.preprod.kushnarenko.dao;

import java.sql.Connection;
import java.util.List;

import main.java.com.epam.preprod.kushnarenko.entity.Payment;

/**
 * This interface represents DAO that extend GenericDAP and parametrise it with
 * Payment entity.
 * 
 * @author Oleksandr_Kushnarenk
 *
 */
public interface PaymentDAO extends GenericDAO<Payment, Long> {

    List<Payment> getAll(Connection con);

    Payment getEntityById(Long id, Connection con);

    Payment update(Payment entity, Connection con);

    boolean delete(Long id, Connection con);

    boolean add(Payment u, Connection con);

}