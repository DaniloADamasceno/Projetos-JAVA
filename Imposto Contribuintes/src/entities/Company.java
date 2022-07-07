package entities;

public final class Company extends Base {
    
    Integer numberOfFunconarios;

    //--------------------
    //      CONSTRUCTOR
    //--------------------

    public Company() {}

    public Company(String name, Double annualIncome, Integer numberOfFunconarios) {
        super(name, annualIncome);
        this.numberOfFunconarios = numberOfFunconarios;
    }

    //--------------------
    //  GETTERS AND SETTERS
    //--------------------

    public Integer getNumberOfFunconarios() {
        return numberOfFunconarios;
    }

    public void setNumberOfFunconarios(Integer numberOfFunconarios) {
        this.numberOfFunconarios = numberOfFunconarios;
    }

    //--------------------
    //      METHODS
    //--------------------

    @Override
    public final Double tax() {
        double tax = 0.0;
        
        if (numberOfFunconarios > 10) {
            tax = getAnnualIncome() * 0.14;
        } else {
            tax = getAnnualIncome() * 0.16;
        }
        
        return tax;
    }
    
    
}