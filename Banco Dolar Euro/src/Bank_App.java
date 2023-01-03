import java.util.Scanner;

import Customer_base.Cliente;

import java.util.Locale;

public class Bank_App {

  public static void main(String[] args) throws Exception {
    /*
    Em um banco, para se cadastrar uma conta bancária, é necessário informar o número da conta, o nome do
    titular da conta, e o valor de depósito inicial que o titular depositou ao abrir a conta. Este valor de depósito
    inicial, entretanto, é opcional, ou seja: se o titular não tiver dinheiro a depositar no momento de abrir sua
    conta, o depósito inicial não será feito e o saldo inicial da conta será, naturalmente, zero.
    Importante: uma vez que uma conta bancária foi aberta, o número da conta nunca poderá ser alterado. Já
    o nome do titular pode ser alterado (pois uma pessoa pode mudar de nome por ocasião de casamento, por
    exemplo).
    Por fim, o saldo da conta não pode ser alterado livremente. É preciso haver um mecanismo para proteger
    isso. O saldo só aumenta por meio de depósitos, e só diminui por meio de saques. Para cada saque
    realizado, o banco cobra uma taxa de $ 5.00. Nota: a conta pode ficar com saldo negativo se o saldo não for
    suficiente para realizar o saque e/ou pagar a taxa.
    
    
    Você deve fazer um programa que realize o cadastro de uma conta, dando opção para que seja ou não
    informado o valor de depósito inicial. Em seguida, realizar um depósito e depois um saque, sempre
    mostrando os dados da conta após cada operação
       */
    Scanner in = new Scanner(System.in);
    Locale.setDefault(Locale.ENGLISH);
    Cliente clientBank;

    System.out.print("Entre com o número da conta:   ");
    int numberAcc = in.nextInt();

    System.out.print("Entre com o nome do cliente:  ");
    String name = in.next();
   // in.nextLine();

    System.out.print("Deposto inicial (y/n):  ");
    char resposta = in.next().charAt(0); //--------------------------------------------------- para ler o caractere de resposta 

    if(resposta == 'y') {
      System.out.print("Digite o valor a ser depositado, R$:  ");
      double valueAcc = in.nextDouble();
      clientBank = new Cliente(numberAcc, name, valueAcc);
    }
    else {
      clientBank = new Cliente(numberAcc, name);
    }
    
    System.out.println(" Accout data:");
    System.out.println(clientBank);
    System.out.println();

    System.out.print("Entre com o valor depositado:  ");
    double depositValue = in.nextDouble();
    clientBank.deposit(depositValue);
    System.out.println();

    System.out.println("Update account data:");
   System.out.println(clientBank);
    System.out.println();

    System.out.print("Digite o valor a ser retirado:  ");
    double withdrawAcc = in.nextDouble();
    clientBank.withdraw(withdrawAcc);
    System.out.println();

    System.out.println("Update account data:  ");
    System.out.println(clientBank);
    System.out.println();









    in.close();
  }
}
