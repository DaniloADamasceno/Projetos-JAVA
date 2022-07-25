package application;

import java.util.Locale;
import java.util.Scanner;

import boardGame.Board;
import boardGame.Position;

public class Chess_Game {

  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    Locale.setDefault(Locale.US);

    Board board = new Board(8, 8);
    System.out.println(board);
    in.close();
  }
}

