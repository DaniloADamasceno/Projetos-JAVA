package generalEntities;
import enums.Color;


public class Square extends GeometricShape {

  public double square;

  //----------------------
  //      CONSTRUCTORS
  //----------------------

  public Square() {
    super();
  }

  public Square(Color ColorShape, double square) {
    super(ColorShape);
    this.square = square;
  }

  //----------------------
  //    Getter & Setter
  //----------------------

  public double getSquare() {
    return square;
  }

  public void setSquare(double square) {
    this.square = square;
  }

  //----------------------
  //      METHODS
  //----------------------

  @Override
  public double area() {
    return square * square;
  }
}
