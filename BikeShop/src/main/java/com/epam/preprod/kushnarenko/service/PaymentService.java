package main.java.com.epam.preprod.kushnarenko.service;

import java.util.List;

import main.java.com.epam.preprod.kushnarenko.entity.Payment;

/**
 * Interface PaymentService represents service for working with Payment entity
 * and PaymentDAO.
 * 
 * @author Oleksandr_Kushnarenk
 *
 */
public interface PaymentService {

    /**
     * Finds and returns all payments from database.
     * 
     * @return List of payments
     */
    List<Payment> getPaymentList();

    Payment getPayment(Long payment);

}