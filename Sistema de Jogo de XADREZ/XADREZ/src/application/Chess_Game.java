package application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import boardGame.Position;
import chess.ChessPosition;
import chess.Chess_Exception;
import chess.Chess_Match;
import chess.Chess_Piece;

public class Chess_Game {

  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    Locale.setDefault(Locale.US);

    Chess_Match match = new Chess_Match();

    while (true) {
      try {
      User_Interface.clearScreen(); // Limpa a tela
      User_Interface.printBoard(match.getPieces());
      System.out.println(); // Quebra de linha

      System.out.print("Posição de Origem | Source: ");
      ChessPosition source = User_Interface.readChessPosition(in);
      System.out.println(); // Quebra de linha

      System.out.print("Posição de Destino | Target: ");
      ChessPosition target = User_Interface.readChessPosition(in);

      Chess_Piece capturedPiece = Chess_Match.performChessMove(source, target);
      }
      catch (Chess_Exception e) {
        System.out.println(e.getMessage());
        in.nextLine();
      }
       catch (InputMismatchException e) {
        System.out.println(e.getMessage());
        in.nextLine();
      }

      System.out.println(); // Quebra de linha final 
      in.close();
    }
  }

  // // private static Chess_Piece performChessMove(ChessPosition source, ChessPosition target) {
  // //   return null;
  // }
}
