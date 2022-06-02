import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.Worker;
import entities.enunmerable.WorkLevel;
import entities.HourContract;

public class AppEmpresa {

  public static void main(String[] args) throws ParseException {
    /*
        Ler os dados de um trabalhador com "N" contratos ("N" fornecido pelo usuário). Depois, solicitar do usuário
         um mês e mostrar qual foi o salário do funcionário nesse mês, conforme exemplo abaixo:
        
         */

    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // ---> Formatação da data

    System.out.println(
      "                                        ----------  COMPANY of COMPANYES     ----------"
    );
    System.out.println();

    System.out.print("Enter department's name:  ");
    String deptName = sc.nextLine();
    System.out.println();

    System.out.println("Enter the worker data:  ");
    System.out.println();
    System.out.print("Name:  ");
    String workerName = sc.nextLine();
    System.out.print("Level:  ");
    String workLevel = sc.nextLine();
    System.out.print("Base salary:  ");
    double baseSalary = sc.nextDouble();

    //------------------------------------------
    //      Criando um objeto de Departamento
    //------------------------------------------

    Worker worker = new Worker(workerName, WorkLevel.valueOf(workLevel), baseSalary, new Department(deptName));
    

    System.out.print("Enter the number of contracts: "); //---> Entrando com um numero de contratos do funcionário
    int numContracts = sc.nextInt();

    //------------------------------------------
    //      Condicional para ler os contratos 
    //------------------------------------------

    for (int i = 1; i <= numContracts; i++) {
      System.out.println("Enter #" + i + " contract data: ");
      System.out.print("Date (DD/MM/YYYY):  ");
      Date contractDate = sdf.parse(sc.next());
      System.out.print("Value per hour:  ");
      double valuePerHour = sc.nextDouble();
      System.out.print("Duration (hours):  ");
      int hours = sc.nextInt();
      //------------------------------------------
      //      Criando um objeto de Contrato
      //------------------------------------------
      HourContract contract = new HourContract(contractDate, valuePerHour, hours);
      //------------------------------------------
      //      Adicionando um contrato ao funcionário
      //------------------------------------------
      worker.addContract(contract);
    }
    System.out.println();
    System.out.println("Enter month and year to calculate income (MM/YYYY): ");
    System.out.print("Date in format MM/YYYY):  ");
    String monthAndYear = sc.next();
    System.out.println();
    int month = Integer.parseInt(monthAndYear.substring(0, 2));
    int year = Integer.parseInt(monthAndYear.substring(3));

    System.out.println("Name : " + worker.getName());
    System.out.println("Department: " + worker.getDepartment().getName());
    System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));

    sc.close();
  }
}
