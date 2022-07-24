package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

//import javax.lang.model.util.SimpleAnnotationValueVisitor14;

public class Reservation {

  private Integer roomNumber;
  private Date checkin;
  private Date checkout;

  private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

  //---------------
  // Constructors
  //---------------

  public Reservation() {}

  public Reservation(Integer roomNumber, Date checkin, Date checkout) {
    this.roomNumber = roomNumber;
    this.checkin = checkin;
    this.checkout = checkout;
  }

  //---------------
  // Getter/Setter
  //---------------

  public Integer getRoomNumber() {
    return roomNumber;
  }

  public void setRoomNumber(Integer roomNumber) {
    this.roomNumber = roomNumber;
  }

  public Date getCheckin() {
    return checkin;
  }

  public Date getCheckout() {
    return checkout;
  }

  //---------------
  // Methods
  //---------------

  public long duration() {
    long diff = checkout.getTime() - checkin.getTime();
    // para converter o tempo em milissegundos utilizando a classe TIME_UNIT
    return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    //
    // se não utilizando a classe TIME_UNIT, bastaria fazer:
    // return (long) (diff / (1000 * 60 * 60 * 24));
  }


  public void updateDates(Date checkin, Date checkout) {
      this.checkin = checkin;
      this.checkout = checkout;
  }

@Override
  public String toString() {
      return "--->>  Hotel transilvânia  <<---" + "\n" +
              "Room: " + roomNumber + "\n" +
              "Check-in: " + sdf.format(checkin) + "\n" +
              "Check-out: " + sdf.format(checkout) + "\n" +
              "Duration: " + duration() + " nights";
        }
}
