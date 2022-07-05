package entities;

public final class ImportedProduct extends Product {

    private double customsFee;

    //--------------------
    //      CONSTRUCTOR
    //--------------------

    public ImportedProduct() {
    }

    public ImportedProduct(String name, double price, double customsFee) {
        super(name, price);
        this.customsFee = customsFee;
    }

    //--------------------
    //      GETTERS & SETTERS
    //--------------------

    public double getCustomsFee() {
        return customsFee;
    }

    //--------------------
    //      METHODS
    //--------------------

    @Override
    public String toString() {
        return 
        super.toString() +
        "\n customsFee:  " + customsFee + "\n" ;
    }
    
}