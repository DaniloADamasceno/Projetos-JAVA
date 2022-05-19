package Customer_base;

public class Cliente {

    private int numberAcc; //-------------------- numero da Conta
    private String name; //---------------------- Titular da Conta
    private double valueAcc; // ----------------- valor/saldo da conta
   // private double deposit; //----------------- deposito em conta 


    public Cliente(int numberAcc, String name) {
        this.numberAcc = numberAcc;
        this.name = name;
    }
    public Cliente(int numberAcc, String name, double valueAcc) {
        this.numberAcc = numberAcc;
        this.name = name;
        deposit(valueAcc);
    }

    public int getNumberAcc() { // --------------------- obter o numero da conta 
        return numberAcc;
    }
  
    public String getName() { //------------------------ obter o nome do conta 
        return name;
    }
    public void setName(String name) { // -------------- modificar o nome do usuário 
        this.name = name;
    }


    public double getValueAcc() {// -------------------- Obter o valor do saldo
        return valueAcc;
    }

    
    // Criando metodos 
    
    public void deposit(double amount) { //-------------- Deposito
        valueAcc += amount;
    }
   

    public void withdraw(double amount) { //------------- Saque
        valueAcc -= amount - 5.0;
    
    }

            

    public String toString() {
        return "________________________________     Dólar and Euro Bank     ________________________________ \n" +
        "\n Account number:  " + numberAcc +
        "\n account owner:  " + name +
        "\n account balance R$:  " + String.format("%.2f", valueAcc);  
    }

    
}
