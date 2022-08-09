import generalEntities.Circle;
import enums.Color;
import generalEntities.GeometricShape;
import generalEntities.Rectangle;
import generalEntities.Square;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ProgramMaster {

  private static List<GeometricShape> list;

  public static void main(String[] args) throws Exception {
    /*
         Fazer um programa para ler os dados deN figuras (N fornecido pelo usuário), e depois mostrar as áreas destas figuras
          na mesma ordem em que foram digitadas.
         */

    System.out.println(); // linha em branco inicial
    Scanner sc = new Scanner(System.in);
    Locale.setDefault(Locale.ENGLISH); // seta o idioma para inglês

    List<GeometricShape> geometricShapes = new ArrayList<>(); // cria uma lista de figuras geométricas

    System.out.println("Digite o número de figuras: ");
    int numFiguras = sc.nextInt();

    for (int i = 1; i <= numFiguras; i++) {
      System.out.println(" Geometric Shape " + i + "data : ");
      System.out.println("C - Circle");
      System.out.println("R - Rectangle");
      System.out.println("S - Square");
      char ch = sc.next().charAt(0);

      System.out.println(
        "type the letter of the color of the geometric figure"
      );
      System.out.println("R - Red");
      System.out.println("G - Green");
      System.out.println("B - Blue");
      System.out.println("Y - Yellow");
      System.out.println("W - White");

      Color color = Color.valueOf(sc.next());

      //------------------
      // Leitura de Figuras
      //------------------

      if (ch == 'C') {
        System.out.println("type the radius of the circle");
        double radius = sc.nextDouble();
        Circle Circle = new Circle(color, radius);
        list.add(new Circle(color, radius));
        //           System.out.println("The area of the circle is:  " + Circle.area());

      } else if (ch == 'R') {
        System.out.print("type the width of the rectangle:  ");
        double width = sc.nextDouble();
        System.out.print("type the height of the rectangle  ");
        double height = sc.nextDouble();
        list.add(new Rectangle(color, width, height));
        //           System.out.println("The area of the rectangle is: " + Rectangle.area());

      } else if (ch == 'S') {
        System.out.println("type the side of the square");
        double side = sc.nextDouble();
        Square Square = new Square(color, side);
        list.add(new Square(color, side));
        //          System.out.println("The area of the square is: " + Square.area());
      } else {
        System.out.println("Invalid option");
      }

      System.out.println(); // linha em branco final
      System.out.println("Shape Areas:");

      for (GeometricShape geometricShape : geometricShapes) {
        System.out.println(
          geometricShape.getClass().getSimpleName() +
          ": " +
          geometricShape.area()
        );
      }
    }

    sc.close();
  }
}
