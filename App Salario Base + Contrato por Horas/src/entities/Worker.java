package entities;

import entities.enunmerable.WorkLevel;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Worker {

  private String name;
  private WorkLevel level;
  private double baseSalary;

  private Department department;
  private List<HourContract> contract = new ArrayList<>();

  //----------------------------------
  //           Constructor
  //----------------------------------

  public Worker() {}

  public Worker(
    String name,
    WorkLevel level,
    double baseSalary,
      Department department) {
      
    this.name = name;
    this.level = level;
    this.baseSalary = baseSalary;
    this.department = department;
  }

  //----------------------------------
  //      Getter/Setter
  //----------------------------------

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getBaseSalary() {
    return baseSalary;
  }

  public void setBaseSalary(double baseSalary) {
    this.baseSalary = baseSalary;
  }

  public WorkLevel getLevel() {
    return level;
  }

  public void setLevel(WorkLevel level) {
    this.level = level;
  }

  public Department getDepartment() {
    return department;
  }

  public void setDepartment(Department department) {
    this.department = department;
  }

  public List<HourContract> getContract() {
    return contract;
  }

  //----------------------------------
  //      Methods
  //----------------------------------

  public void addContract(HourContract contract) { // ---> Adicionando um contrato
    contract.add(contract);
  }

  public void removeContract(HourContract contract) { //---> Removendo um contrato
    contract.remove(contract);
  }

  public double income(Integer year, Integer month) { //---> Calculando o salário do funcionário com os contratos
    double sum = baseSalary;
    Calendar cal = Calendar.getInstance();

    for (HourContract cContract : contract) {
      cal.setTime(cContract.getDate());
      int cMonth = 1 + cal.get(Calendar.MONTH);
      int cYear = cal.get(Calendar.YEAR);
      if (cMonth == month && cYear == year) {
        sum += cContract.totalValue();
      }
    }
    return sum;
  }
}
