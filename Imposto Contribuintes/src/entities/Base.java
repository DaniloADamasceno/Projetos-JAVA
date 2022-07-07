package entities;

public abstract class Base {
    
    private String name;
    private Double annualIncome;
    

    //--------------------
    //      CONSTRUCTOR
    //--------------------

    public Base() {}
    
    public Base(String name, Double annualIncome) {
        this.name = name;
        this.annualIncome = annualIncome;

    }
    
    //--------------------
    //   GETTERS AND SETTERS
    //--------------------

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Double getAnnualIncome() {
        return annualIncome;
    }
    
    public void setAnnualIncome(Double annualIncome) {
        this.annualIncome = annualIncome;
    }
    
    
    //--------------------
    //      METHODS
    //--------------------

    public abstract Double tax();
    
}