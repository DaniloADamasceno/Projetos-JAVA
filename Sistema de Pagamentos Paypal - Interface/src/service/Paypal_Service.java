package service;

public class Paypal_Service implements Online_Payment_Service { // implementando a interface

  private static final double taxaDeJuros
   = 0.02;
  private static final double Monthly_Juros = 0.01;

  //%%---------- >>>> Taxa de Pagamento
  public double taxa_Juros(double amount) {
    return amount * taxaDeJuros
    ;
  }

  //%%---------- >>>> Juros Mensais
  public double juros(double amount, int months) {
    return amount * Monthly_Juros * months;
  }
}
  