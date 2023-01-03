package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contract {

  private Integer number;
  private Date date;
  private Double totalValue;

  private List<Parcelas> parcelas = new ArrayList<>();

  //----------------------------
  //!     CONSTRUCTOR
  //----------------------------
  public Contract(Integer number, Date date, Double totalValue) {
    this.number = number;
    this.date = date;
    this.totalValue = totalValue;
  }

  public Contract() {}

  //----------------------------
  //!    GETTERS AND SETTERS
  //----------------------------
  public Integer getNumber() {
    return number;
  }

  public void setNumber(Integer number) {
    this.number = number;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public Double getTotalValue() {
    return totalValue;
  }

  public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
  }
  
  public List<Parcelas> getParcelas() {
        return parcelas;
  }
  //%%---------- >>>> Add Parcelas    
  public void addParcelas(Parcelas percela) {
        parcelas.add(percela);
  }
  
  //%%---------- >>>> Remove Parcelas
      public void removeParcelas(Parcelas percela) {
            parcelas.remove(percela);
      }

}

