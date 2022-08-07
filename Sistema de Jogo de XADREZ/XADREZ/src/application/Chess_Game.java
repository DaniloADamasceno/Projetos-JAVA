package application;

import java.util.Locale;
import java.util.Scanner;

import boardGame.Position;
import chess.ChessPosition;
import chess.Chess_Match;
import chess.Chess_Piece;

public class Chess_Game {

  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    Locale.setDefault(Locale.US);

    Chess_Match match = new Chess_Match();

    while (true) {
      User_Interface.printBoard(match.getPieces());
      System.out.println(); // Quebra de linha

      System.out.print("Source: ");
      ChessPosition source = User_Interface.readChessPosition(in);
      System.out.println(); // Quebra de linha

      System.out.print("Target: ");
      ChessPosition target = User_Interface.readChessPosition(in);

      Chess_Piece capturedPiece = Chess_Match.performChessMove(source, target);

      System.out.println(); // Quebra de linha final 
      in.close();
    }
  }

  private static Chess_Piece performChessMove(ChessPosition source, ChessPosition target) {
    return null;
  }
}
