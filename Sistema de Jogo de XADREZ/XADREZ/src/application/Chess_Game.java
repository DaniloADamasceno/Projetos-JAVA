package application;

import java.util.Locale;
import java.util.Scanner;

import boardGame.Board;
import boardGame.Position;
import chess.Chess_Match;

public class Chess_Game {

  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    Locale.setDefault(Locale.US);

    Chess_Match match = new Chess_Match();

    User_Interface.printBoard(match.getPieces());



    System.out.println(); // Quebra de linha final 
    in.close();
  }
}

