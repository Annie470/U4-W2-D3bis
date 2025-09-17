package entities;


import java.time.LocalDate;
import java.util.List;

public class Customer {
    private long id;
    private String name;
    private int tier;

    private static long count= 100;


    public Customer(String name, int tier){
        this.id=count++;
        this.name=name;
        this.tier=tier;
    }

    public Order creareOrdine(LocalDate orderDate, LocalDate deliveryDate, List<Product> products) {
        return new Order(orderDate, deliveryDate, products, this);
    }

    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getTier() {
        return tier;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setTier(int tier) {
        this.tier = tier;
    }
}
