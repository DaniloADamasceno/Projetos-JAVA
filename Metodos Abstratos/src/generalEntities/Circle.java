package generalEntities;
import enums.Color;

public class Circle extends GeometricShape {

  double radius;

  //----------------------
  //      CONSTRUCTORS
  //----------------------

  public Circle() {
    super();
  }

  public Circle(Color ColorShape, double radius) {
    super(ColorShape);
    this.radius = radius;
  }

  //----------------------
  //    Getter & Setter
  //----------------------

  public double getRadius() {
    return radius;
  }

  public void setRadius(double radius) {
    this.radius = radius;
  }

  //----------------------
  //      METHODS
  //----------------------

  @Override
  public double area() {
    return Math.PI * radius * radius;
  }
}
