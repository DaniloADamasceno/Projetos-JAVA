package Funcionario;

public class Employee {

  private Integer id;
  private String name;
  private double salary;
  private double porcentagem;

  //-----------------------------------
  //   Constructors
  //-----------------------------------
  public Employee(int id, String name, double salary) {
    this.id = id;
    this.name = name;
    this.salary = salary;
  }

  //-----------------------------------
  //   Gets e Sets
  //-----------------------------------
  public int getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
}

public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
}

public double getSalary() {
    return salary;
  }

  public void setSalary(double salary) {
      this.salary = salary;
  }
  
  public void increaseSalary(double porcentagem) {
      salary += salary * porcentagem / 100;
  }
  
  public String toString() {
      return "Employer # \n"
      + "ID: " + id +
      "\n Name: " + name +
      "\n Salary: " + String.format("%.2f",salary) + "\n";
  }
}
