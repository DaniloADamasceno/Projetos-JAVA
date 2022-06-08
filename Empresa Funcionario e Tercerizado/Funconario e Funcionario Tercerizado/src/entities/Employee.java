package entities;

public class Employee {
    
    private String name;
    private Integer hours;
    private Double valuePerHour;

    //--------------------------- 
    //      Constructor(s)
    //---------------------------

    public Employee() {
    }

    public Employee(String name, Integer hours, Double valuePerHour) {
        this.name = name;
        this.hours = hours;
        this.valuePerHour = valuePerHour;
    }
    
    //---------------------------
    //      getters and setters
    //---------------------------
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public Double getValuePerHour() {
        return valuePerHour;
    }

    public void setValuePerHour(Double valuePerHour) {
        this.valuePerHour = valuePerHour;
    }
    
    //--------------------------
    //      methods
    //--------------------------

    public Double payment() {
        return hours * valuePerHour;
    }



    

}