package main.java.com.epam.preprod.kushnarenko.service;

import main.java.com.epam.preprod.kushnarenko.entity.Order;

public interface OrderService {

    /**
     * Allows to add new Order to database with all of the OrderItems inside of
     * Order. Makes it like a one whole transaction.
     * 
     * @param entity
     * @return
     */
    boolean create(Order entity);

}