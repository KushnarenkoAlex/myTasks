package main.java.com.epam.preprod.kushnarenko.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private Long id;
    private Long statusId;
    private Date orderDate;
    private Integer userId;
    private List<OrderItem> items;
    private Long delivery;
    private Long payment;

    public List<OrderItem> getItems() {
        return items;
    }

    public Order() {
        items = new ArrayList<>();
    }

    public Order(Long id, Long statusId, Date orderDate, Integer userId) {
        super();
        items = new ArrayList<>();
        this.id = id;
        this.statusId = statusId;
        this.orderDate = orderDate;
        this.userId = userId;
    }

    public boolean addProduct(OrderItem oi) {
        return this.items.add(oi);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Order other = (Order) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (orderDate == null) {
            if (other.orderDate != null)
                return false;
        } else if (!orderDate.equals(other.orderDate))
            return false;
        if (statusId == null) {
            if (other.statusId != null)
                return false;
        } else if (!statusId.equals(other.statusId))
            return false;
        if (userId == null) {
            if (other.userId != null)
                return false;
        } else if (!userId.equals(other.userId))
            return false;
        return true;
    }

    public Long getDelivery() {
        return delivery;
    }

    public Long getId() {
        return id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public Long getPayment() {
        return payment;
    }

    public Long getStatusId() {
        return statusId;
    }

    public Integer getUserId() {
        return userId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
        result = prime * result + ((statusId == null) ? 0 : statusId.hashCode());
        result = prime * result + ((userId == null) ? 0 : userId.hashCode());
        return result;
    }

    public void setDelivery(Long delivery) {
        this.delivery = delivery;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void setPayment(Long payment) {
        this.payment = payment;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Order [id=" + id + ", statusId=" + statusId + ", orderDate=" + orderDate + ", userId=" + userId + "]";
    }

}
