package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Parcelas {

  private Date dueDate; // data de vencimento
  private Double amount; // valor da parcela

  private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // formatação da data

  //----------------------------
  //!     CONSTRUCTOR
  //----------------------------
  public Parcelas(Date dueDate, Double amount) {
    this.dueDate = dueDate;
    this.amount = amount;
  }

  public Parcelas() {}

  //----------------------------
  //!    GETTERS AND SETTERS
  //----------------------------
  public Date getDueDate() {
    return dueDate;
  }

  public void setDueDate(Date dueDate) {
    this.dueDate = dueDate;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  //%%---------- >>>> toString
  @Override
  public String toString() {
    return sdf.format(dueDate) + "  -  " + String.format("%.2f", amount);
  }
}
