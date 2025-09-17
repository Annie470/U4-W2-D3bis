package entities;

import java.time.LocalDate;
import java.util.List;

public class Order {
    private long id;
    private Status status;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private List<Product> products;
    private Customer customer;

    private static long count= 5000;

    public Order(LocalDate orderDate, LocalDate deliveryDate, List<Product> products, Customer customer){
        LocalDate today= LocalDate.now();
        this.id= count++;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.products = products;
        this.status= deliveryDate.isBefore(today) ? Status.PROCESSED : Status.IN_PROGRESS;
        this.customer = customer;
    }

    public long getId() {
        return id;
    }
    public Customer getCustomer() {
        return customer;
    }
    public List<Product> getProducts() {
        return products;
    }
    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }
    public LocalDate getOrderDate() {
        return orderDate;
    }
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
    public void setProducts(List<Product> products) {
        this.products = products;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", status=" + status +
                ", orderDate=" + orderDate +
                ", deliveryDate=" + deliveryDate +
                ", products=" + products +
                ", customer=" + customer.getName() +
                '}';
    }
}
