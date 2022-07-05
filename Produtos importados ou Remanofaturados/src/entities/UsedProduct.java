package entities;

public final class UsedProduct extends Product {
    
    private String manufactureDate;

    //--------------------
    //      CONSTRUCTOR
    //--------------------

    public UsedProduct() {
    }

    public UsedProduct(String name, double price, String manufactureDate) {
        super(name, price);
        this.manufactureDate = manufactureDate;
    }

    //--------------------
    //      GETTERS & SETTERS
    //--------------------

    public String getManufactureDate() {
        return manufactureDate;
    }

    //--------------------
    //      METHODS
    //--------------------

    @Override
    public String toString() {
        return super.toString() +
        "\n manufactureDate:  " + manufactureDate + "\n" ;
        
    }
    
}