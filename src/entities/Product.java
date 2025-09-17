package entities;


public class Product {
    private long id;
    private  String name;
    private Category category;
    private double price;

    private static long count= 100;


    public Product(String name, Category category, double price) {
        this.id = count++;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public long getId() {
        return id;
    }
    public double getPrice() {
        return price;
    }
    public Category getCategory() {
        return category;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", price=" + price +
                '}';
    }
}
