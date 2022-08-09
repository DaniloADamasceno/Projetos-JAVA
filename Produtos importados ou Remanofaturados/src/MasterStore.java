import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;
import entities.UsedProduct;
import entities.ImportedProduct;

public class MasterStore {
    public static void main(String[] args) throws Exception {
   
        /* 
         Fazer um programa para ler os dados de N produtos (N fornecido pelo usuário).
          Ao final, mostrar a etiqueta de preço de cada produto na mesma ordem em que foram digitados.
        
        Todo produto possui nome e preço. Produtos importados possuem uma taxa de alfândega, e produtos usados possuem data de fabricação.
        Estes dados específicos devem ser acrescentados na etiqueta de preço. 
        Para produtos
        importados, a taxa e alfândega deve ser acrescentada ao preço final do produto.
        */

        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        List<Product> list = new ArrayList<>();
        
        System.out.print("Enter the number of products:  ");
        int numProducts = sc.nextInt();

        for( int i = 1; i <= numProducts; i++) {
            System.out.println("Product #" + i + " data: ");

            System.out.print("Common, used or imported (c/u/i)? ");
            char productType = sc.next().charAt(0);

            System.out.print("Name:  ");
            String name = sc.next();

            System.out.print("Price:  ");
            double price = sc.nextDouble();

            if (productType == 'c') {
                Product product = new Product(name, price);
                list.add(product);
                System.out.println(); // Saltar linha
            } 
            else if (productType == 'u') {
                System.out.print("Manufacture date (DD/MM/YYYY):  ");
                String manufactureDate = sc.next();
                
                Product product = new UsedProduct(name, price, manufactureDate);
                list.add(product);
                System.out.println(); // Saltar linha
            }
            else{
                System.out.print("Customs fee:  ");
                double customsFee = sc.nextDouble();
                
                Product product = new ImportedProduct(name, price, customsFee);
                list.add(product);
                System.out.println(); // Saltar linha
            }
        }
        System.out.println(); // Saltar linha
        System.out.println("PRICE TAG: ");
        for (Product product : list) {
            System.out.println(product.toString());
        }

        System.out.println();
        sc.close(); 
    }
}
