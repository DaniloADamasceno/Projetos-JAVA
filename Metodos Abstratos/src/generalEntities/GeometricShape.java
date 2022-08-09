package generalEntities;
import enums.Color;

public abstract class GeometricShape {

  private Color ColorShape;

  //--------------------
  // CONSTRUTORES
  //--------------------

  public GeometricShape() {}

  public GeometricShape(Color ColorShape) {
    this.ColorShape = ColorShape;
  }

  //--------------------
  // Getter & Setter
  //--------------------

  public Color getColor() {
    return ColorShape;
  }

  public void setColor(Color ColorShape) {
    this.ColorShape = ColorShape;
  }

  //--------------------
  // METHODS
  //--------------------

  public abstract double area(); // criar um método abstrato para as areas das formas
}
