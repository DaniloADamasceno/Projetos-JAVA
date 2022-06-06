import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.OrderItem;
import entities.Product;
import orders.Pedido;
import statusService.OrderStatus;

public class ProgramMaster {
    public static void main(String[] args) throws ParseException {
        /*
         Ler os dados de um pedido com N itens (N fornecido pelo usuário). Depois, mostrar um sumário do pedido conforme exemplo.
          Nota: o instante do pedido deve ser o instante do sistema: new Date()
         */
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // ---> Formatação da data

        System.out.println(
                "                                        ----------  ORDERING COMPANY     ----------"
        );
        System.out.println();

        System.out.println("Enter client data: ");
        System.out.print("Name: ");
        String clientName = sc.nextLine();
        System.out.print("Email: ");
        String clientEmail = sc.nextLine();
        System.out.print("Birth Date (DD/MM/YYYY): ");
        Date clientBirthDate = sdf.parse(sc.next());

        //------------------------------------------
        //      Criando um objeto de Cliente
        //------------------------------------------
        
        Client client = new Client(clientName, clientEmail, clientBirthDate);

        //------------------------------------------------------------------------------
        System.out.println("Enter order data: ");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.next());


        //------------------------------------------
        //      Criando um objeto de pedido
        //------------------------------------------
        Pedido pedido = new Pedido(new Date(), status, client);


        System.out.print("How many items to this order ? ");
        int orderItems = sc.nextInt();

        //------------------------------------------
        //      Condicional pra ler o número de itens
        //------------------------------------------

        for(int i =1; i <= orderItems; i++){
            System.out.println("Enter #" + i + " item data: ");
            System.out.print("Product name: ");
            String productName = sc.nextLine();
            System.out.print("Product price: ");
            double productPrice = sc.nextDouble();
            System.out.print("Quantity: ");
            int quantity = sc.nextInt();

            //------------------------------------------
            //      Criando um objeto de Pedido
            //------------------------------------------

            Product product = new Product(productName, productPrice);

            System.out.print("Quantity: ");
			int quantity1 = sc.nextInt();

			OrderItem orderItem = new OrderItem(quantity1, productPrice, product); 

			pedido.addItem(orderItem);
        }

        System.out.println();
		System.out.println("ORDER SUMMARY:");
		System.out.println(pedido);
		
		sc.close();
    }
}
