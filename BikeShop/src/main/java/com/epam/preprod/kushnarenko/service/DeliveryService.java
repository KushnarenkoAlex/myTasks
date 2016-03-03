package main.java.com.epam.preprod.kushnarenko.service;

import java.util.List;

import main.java.com.epam.preprod.kushnarenko.entity.Delivery;

/**
 * Interface DeliveryService represents service for working with Delivery entity
 * and DeliveryDAO.
 * 
 * @author Oleksandr_Kushnarenk
 *
 */
public interface DeliveryService {

    /**
     * Finds and returns all deliveries from database.
     * 
     * @return List of delivery
     */
    List<Delivery> getDeliveryList();

    Delivery getDelivery(Long delivery);

}