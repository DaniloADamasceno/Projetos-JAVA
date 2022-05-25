import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Locale;
import Funcionario.Employee;

public class Company {

    public static void main(String[] args) throws Exception {

        /*
        Fazer um programa para ler um número inteiro "N" e depois os dados(id,nome e salario) de "N" funcionários.
        Não deve haver repetição de id.
        Em seguida,efetuar o aumento de "X" por cento no salário de um determinado funcionário.
        Para isso,o programa deve ler um id e o valor X. Se o id informado não existir,mostrar uma mensagem e abortar a operação.
        Ao final,mostrara listagem atualizada dos funcionários, conforme exemplos.
        Lembre-se de aplicar a técnica de encapsulamento para não permitir que o salário possa ser mudado livremente.
        Um salário só pode ser aumentado com base em uma operação de aumento por porcentagem dada.
         */
        Scanner in = new Scanner(System.in);
         Locale.setDefault(Locale.ENGLISH); 
       
       List<Employee> list = new ArrayList<>();

        System.out.print(" Quantos funcionarios serão Cadastrados: ");
        int nEmployee = in.nextInt();
    

        for (int i = 1; i <= nEmployee; i++) {
            System.out.println();
            System.out.print("Employere #" + i + ":");
            System.out.println();

            System.out.print("ID: ");
            int id = in.nextInt();
            while (hasId(list, id)) {
                System.out.println("Id already taken. Try again: ");
            }

            System.out.print("Name:  ");
            String name = in.next();

            System.out.print("Salary:  ");
            int salary = in.nextInt();

            list.add(new Employee(id, name, salary)); 
        }

        System.out.println();
        System.out.print(
                "Informe o ID do funcionário que terá aumento salarial:  ");
        int id = in.nextInt();

        Employee emp = list
                .stream()
                .filter(x -> x.getId() == id)
                .findFirst()
                .orElse(null);
        if (emp == null) {
            System.out.println("ID inexistente");
        } else {
            System.out.print("Digite a porcentagem de aumento: ");
            double porcentagem = in.nextDouble();
            emp.increaseSalary(porcentagem);
        }

        System.out.println();
        System.out.println("Lista de Empregados");
        for (Employee obj : list) {
            System.out.println(obj);
        }

        in.close();
    }

    public static boolean hasId (List<Employee> list, int id) {
        Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        return emp != null;
  }
}
