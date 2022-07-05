package entities;

public class Product {
    private String name;
    private double price;

    //--------------------
    //      CONSTRUCTOR
    //--------------------

    public Product() {
    }
    
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    //--------------------
    //      GETTERS & SETTERS
    //--------------------

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //--------------------
    //      METHODS
    //--------------------

   // @Override
    public String toString() {
        return "Product: \n name:  " + name +  "\n price:  " + price;
    }

    
    

    
}