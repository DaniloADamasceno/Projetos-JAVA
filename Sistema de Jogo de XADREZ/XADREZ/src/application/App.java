package application;

import java.util.Locale;
import java.util.Scanner;

import boardGame.Position;

public class App {

  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    Locale.setDefault(Locale.US);

    Position position = new Position(10, 10);
    System.out.println(position);
    System.out.println();
    in.close();
  }
}
