package main.java.com.epam.preprod.kushnarenko.utils;

import java.util.HashMap;
import java.util.Map.Entry;

import main.java.com.epam.preprod.kushnarenko.bean.RegistrationUserBean;
import main.java.com.epam.preprod.kushnarenko.entity.Order;
import main.java.com.epam.preprod.kushnarenko.entity.OrderItem;
import main.java.com.epam.preprod.kushnarenko.entity.Product;
import main.java.com.epam.preprod.kushnarenko.entity.User;

public class Transformer {

    public User getUser(RegistrationUserBean rub) {
        User u = new User();
        u.setFirstName(rub.getFirstName());
        u.setLastName(rub.getLastName());
        u.setPassword(rub.getPassword());
        u.setEmail(rub.getEmail());
        u.setPhoneNumber(rub.getPhoneNumber());
        Boolean b = (rub.getSpam() == null) ? false : true;
        u.setSpam(b);
        return u;
    }

    public Order getOrder(HashMap<Product, Integer> bucket, Integer id, Long delivery, Long payment) {
        Order order = new Order();
        for (Entry<Product, Integer> entry : bucket.entrySet()) {
            OrderItem oi = new OrderItem();
            oi.setProductId(entry.getKey().getId());
            oi.setActualPrice(entry.getKey().getPrice());
            oi.setQuantity(entry.getValue());
            order.addProduct(oi);
        }
        order.setUserId(id);
        order.setDelivery(delivery);
        order.setPayment(payment);
        return order;
    }

}
