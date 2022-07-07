import java.util.List;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import entities.Base;
import entities.Company;
import entities.Individual;

public class ProgramMaster {
    public static void main(String[] args) throws ParseException {
        /*
           Fazer um programa para ler os dados de N contribuintes (N fornecido pelo usuário), os quais podem ser pessoa física ou pessoa jurídica, 
        e depois mostrar o valor do imposto pago por cada um, bem como o total de imposto arrecadado.
        //!     Os dados de pessoa física são: 
                                                nome, renda anual e gastos com saúde. 
        //!     Os dados de pessoa jurídica são:
                                                nome, renda anual e número de funcionários.
        
          As regras para cálculo de imposto são as seguintes:
        //!        Pessoa física: 
        pessoas cuja renda foi abaixo de 20000.00 pagam 15% de imposto. 
        Pessoas com renda de 20000.00 em diante pagam 25% de imposto. 
        Se a pessoa teve gastos com saúde, 50% destes gastos são abatidos no imposto.
        
        Exemplo: uma pessoa cuja renda foi 50000.00 e teve 2000.00 em gastos com saúde, o imposto
        fica: (50000 * 25%) - (2000 * 50%) = 11500.00
        
        //!        Pessoa jurídica: 
        pessoas jurídicas pagam 16% de imposto. Porém, se a empresa possuir mais de 10
        funcionários, ela paga 14% de imposto.
        
        Exemplo: uma empresa cuja renda foi 400000.00 e possui 25 funcionários, o imposto fica:
        400000 * 14% = 56000.00
         */
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        List<Base> list = new ArrayList<>();

        System.out.println();
        System.out.print(" Digite o número de contribuintes: ");
        int nFuncionarios = sc.nextInt();

        for (int i = 1; i <= nFuncionarios; i++) {
            System.out.println("Taxa do funcionário #" + i + " data : ");
            System.out.print(" Individual or Company (i / C)?  ");

            if ( sc.next().charAt(0) == 'i') {
                System.out.print("Digite o nome do funcionário:  ");
                String name = sc.next();
                System.out.print("Digite a renda anual do funcionário:  ");
                double annualIncome = sc.nextDouble();
                System.out.print("Digite o gasto com saúde do funcionário:  ");
                double healthExpenditures = sc.nextDouble();
                list.add(new Individual(name, annualIncome, healthExpenditures));
                
            } else {
                System.out.print("Digite o nome da empresa:  ");
                String nome = sc.next();
                System.out.print("Digite a renda anual da empresa:  ");
                double annualIncome = sc.nextDouble();
                System.out.print("Digite o número de funcionários da empresa:  ");
                int numFuncionarios = sc.nextInt();
                list.add(new Company(nome, annualIncome, numFuncionarios));
            }

            System.out.println(); // pula linha
            System.out.println(" Taxes Paid: ");
            for (Base b : list) {
                System.out.println(b.getName() + ": $" + b.tax());
            } 
        }
  


        sc.close();
    }

}
