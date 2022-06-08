import entities.Employee;
import entities.OutsourceEmployee;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class MainProgram {

  public static void main(String[] args) throws Exception {
    /*
        Uma empresa possui funcionários próprios e terceirizados. Para cada funcionário, deseja-se registrar nome, 
    horas trabalhadas e valor por hora. Funcionários terceirizado possuem ainda uma despesa adicional.
    
        O pagamento dos funcionários corresponde ao valor da hora multiplicado pelas horas trabalhadas, sendo que os
    funcionários terceirizados ainda recebem um bônus correspondente a 110% de sua despesa adicional.
    
        Fazer um programa para ler os dados de N funcionários (N fornecido pelo usuário) e armazená-los em uma lista. Depois
    de ler todos os dados, mostrar nome e pagamento de cada funcionário na mesma ordem em que foram digitados.
     */

    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    List<Employee> list = new java.util.ArrayList<>();

    System.out.print("Enter the number of employees:  ");
    int numEmployees = sc.nextInt();

    for (int i = 1; i <= numEmployees; i++) {
        System.out.println("Employee #" + i + " data: ");

        System.out.print("Outsource Employee (y/n)?  ");
        char OutsourceYoN = sc.next().charAt(0);

        System.out.print("Name: ");
        String name = sc.next();

        System.out.print("Hours: ");
        int hours = sc.nextInt();

        System.out.print("Value per hour: ");
        double valuePerHour = sc.nextDouble();

        if (OutsourceYoN == 'y') {
            System.out.print("Additional charge: ");
            double additionalCharge = sc.nextDouble();

            Employee employee = new OutsourceEmployee(name, hours, valuePerHour, additionalCharge);
            list.add(employee);
        } else {
            Employee employee = new Employee(name, hours, valuePerHour);
            list.add(employee);
        }
    }
    System.out.println();
    System.out.println("PAYMENT: ");
    for(Employee emp : list){
        System.out.println(emp.getName() + "   - R$ " + String.format("%.2f", emp.payment()));
    }

    System.out.println();
    sc.close();
  }
}
