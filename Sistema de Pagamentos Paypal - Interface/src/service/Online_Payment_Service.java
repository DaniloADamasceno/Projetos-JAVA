package service;

public interface Online_Payment_Service {
  double taxa_Juros(double amount);

  double juros(double amount, int months);
}
