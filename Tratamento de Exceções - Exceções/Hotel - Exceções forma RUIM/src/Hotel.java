import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import model.entities.Reservation;

public class Hotel {

   public static void main(String[] args) throws Exception {
      /*
       Fazer um programa para ler os dados de uma reserva de hotel (número do quarto, data de entrada e data de saída)
      e mostrar os dados da reserva, inclusive sua duração em dias.
       Em seguida, ler novas datas de entrada e saída, atualizar a reserva, e mostrar novamente a reserva com os dados atualizados.
      O programa não deve aceitar dados inválidos para a reserva, conforme as seguintes regras:
      - Alterações de reserva só podem ocorrer para datas futuras
      - A data de saída deve ser maior que a data de entrada
       */

      SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
      Locale.setDefault(Locale.US);
      Scanner sc = new Scanner(System.in);

      System.out.println("--->>  Hotel transilvânia  <<---");
      System.out.println(); // para pular uma linha
      System.out.print("Informe o número do quarto:  ");
      int roomNumber = sc.nextInt();

      System.out.print("Informe a data de entrada (dd/MM/yyyy):  ");
      Date checkin = sdf.parse(sc.next());

      System.out.print("Informe a data de saída (dd/MM/yyyy):  ");
      Date checkout = sdf.parse(sc.next());

      if (!checkout.after(checkin)) {
         System.out.println("Data de saída deve ser maior que a data de entrada");
         System.out.println(); // para pular uma linha
      } else {
         Reservation reservation = new Reservation(roomNumber, checkin, checkout);
         System.out.println("Reserva: " + reservation);
         System.out.println(); // para pular uma linha

         // --->>    Atualização de reserva    <<---
         System.out.println("Entre com as atualizações de reserva: ");
         System.out.print("Informe a data de entrada (dd/MM/yyyy):  ");
         checkin = sdf.parse(sc.next());
         System.out.print("Informe a data de entrada (dd/MM/yyyy):  ");
         checkout = sdf.parse(sc.next());
  
            //--- Atualizar a reserva ---
            String error = reservation.updateDates(checkin, checkout);
            if (error != null) {
               System.out.println("Error in update reservation:  " + error);
               System.out.println("Reserva: " + reservation);
            }
         else {
            System.out.println("Reserva atualizada: " + reservation);
         }
      }
         sc.close();
      }
   }

