package application;

import chess.Chess_Piece;

public class User_Interface {

  //----------------------
  //     Methods
  //----------------------

  public static void printBoard(Chess_Piece[][] pieces) {
    for (int i = 0; i < pieces.length; i++) {
      System.out.print((8 - i) + " >>");

      for (int j = 0; j < pieces.length; j++) {
        printPiece(pieces[i][j]);
      }
      System.out.println(); // Quebra de linha
    }
    System.out.println("    [Aa][Bb][Cc][Dd][Ee][Ff][Gg][Hh]");
  }

  private static void printPiece(Chess_Piece piece) {
    if (piece == null) {
      System.out.print("[--]");
    } else {
      System.out.print("[  ]");
    }
  }
}
