package entities;

public class OutsourceEmployee extends Employee {

    private Double additionalCharge;

    //---------------------------
    //      Constructors
    //---------------------------

    public OutsourceEmployee() { // Sempre chamar o super no construtor padrão quando fizer um extends
        super();
    }

    public OutsourceEmployee(String name, Integer hours, Double valuePerHour, Double additionalCharge) {
        super(name, hours, valuePerHour);
        this.additionalCharge = additionalCharge;
    }

    //--------------------------
    //      getters and setters
    //--------------------------

    public Double getAdditionalCharge() {
        return additionalCharge;
    }

    public void setAdditionalCharge(Double additionalCharge) {
        this.additionalCharge = additionalCharge;
    }

    //--------------------------
    //      methods
    //--------------------------

    @Override
    public Double payment() {
        return super.payment() + (additionalCharge * 1.1);
    }

}
    
