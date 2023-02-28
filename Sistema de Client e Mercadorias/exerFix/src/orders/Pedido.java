package orders;

import java.util.Date;
import java.util.List;

import entities.Client;
import entities.OrderItem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import instituition.OrderStatus;


public class Pedido {

      private Date moment;
      private OrderStatus status;

      private Client client;
      private List<OrderItem> item = new ArrayList<>();
      private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

      //----------------------------------
      //          Constructors
      //----------------------------------

     // private Pedido() {}
      
      public Pedido(Date moment, OrderStatus status, Client client) {
            this.moment = moment;
            this.status = status;
            
      }

      //----------------------------------
      //          Getters and Setters
      //----------------------------------

      public Pedido(Date moment2, statusService.OrderStatus status2, Client client2) {}

    public Date getMoment() {
            return moment;
      }

      public void setMoment(Date moment) {
            this.moment = moment;
      }

      public Client getClient() {
            return client;
      }

      public void setClient(Client client) {
            this.client = client;
      }

      public List<OrderItem> getItens() {
            return item;
      }

      public OrderStatus getStatus() {
            return status;
      }

      public void setStatus(OrderStatus status) {
            this.status = status;
      }

      //----------------------------------
      //          Methods
      //----------------------------------

      public void addItem(OrderItem item) {
            item.add(item);
      }

      public void removeItem(OrderItem item) {
            item.remove(item);
      }

      public double total() {
            double sum = 0.0;
            for (OrderItem item : Item()) {
                  sum += item.subTotal();
            }
            return sum;
      }
      
private OrderItem[] Item() {
            return null;
      }

public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: ");
		sb.append(sdf.format(moment) + "\n");
		sb.append("Order status: ");
		sb.append(status + "\n");
		sb.append("Client: ");
		sb.append(client + "\n");
		sb.append("Order items:\n");
		for (OrderItem item : item) {
			sb.append(item + "\n");
		}
		sb.append("Total price: $");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
	}

    
}