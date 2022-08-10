package application;

//import boardGame.Board;
//import boardGame.Position;
import chess.Chess_Position;
import chess.Chess_Match;
import chess.Chess_Piece;
import chess.Color;
import java.util.InputMismatchException;
import java.util.Scanner;

public class User_Interface {

  // https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println

  //!-------------------------->>>     TEXT COLORS     <<<--------------------------

  public static final String ANSI_RESET = "\u001B[0m"; // Reset a Cor
  public static final String ANSI_BLACK = "\u001B[30m"; // Preto
  public static final String ANSI_RED = "\u001B[31m"; // Vermelho
  public static final String ANSI_GREEN = "\u001B[32m"; // Verde
  public static final String ANSI_YELLOW = "\u001B[33m"; // Amarelo
  public static final String ANSI_BLUE = "\u001B[34m"; // Azul
  public static final String ANSI_PURPLE = "\u001B[35m"; // Roxo
  public static final String ANSI_CYAN = "\u001B[36m"; // Ciano / Azul Claro
  public static final String ANSI_WHITE = "\u001B[37m"; // Branco

  //!-------------------------->>>     BACKGROUND COLORSSTYLES    <<<--------------------------

  public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m"; // Preto
  public static final String ANSI_RED_BACKGROUND = "\u001B[41m"; // Vermelho
  public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m"; // Verde
  public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m"; // Amarelo
  public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m"; // Azul
  public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m"; // Roxo
  public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m"; // Ciano / Azul Claro
  public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m"; // Branco

  //----------------------
  //!     Methods
  //----------------------

  public static void printBoard(Chess_Piece[][] pieces) {
    for (int i = 0; i < pieces.length; i++) {
      System.out.print((8 - i) + " ");

      for (int j = 0; j < pieces.length; j++) {
        printPiece(pieces[i][j], false);
      }
      System.out.println(); // Quebra de linha
    }
    System.out.println("*                ");
    System.out.println("* a b c d e f g h");
  }

   public static void printBoard(Chess_Piece[][] pieces, boolean[][] possibleMoves) {
    for (int i = 0; i < pieces.length; i++) {
      System.out.print((8 - i) + " ");

      for (int j = 0; j < pieces.length; j++) {
        printPiece(pieces[i][j],possibleMoves[i][j]);
      }
      System.out.println(); // Quebra de linha
    }
    System.out.println("*                ");
    System.out.println("* a b c d e f g h");
  }

  private static void printPiece(Chess_Piece piece, boolean background) {
    if (background) {
      System.out.print(ANSI_BLUE_BACKGROUND);
    } 
    if (piece == null) {
      System.out.print("-" + ANSI_RESET);
    } else {
      if (piece.getColor() == Color.WHITE) {
        System.out.print(ANSI_WHITE + piece + ANSI_RESET);
      } else {
        System.out.print(ANSI_YELLOW + piece + ANSI_RESET);
        //   System.out.print("" + piece.toString().charAt(0) + " ");
      }
    }

    System.out.print(" ");
  }

  //!-------------------------->>>     Limpar a Tela após Atualização de jogo    <<<--------------------------
  // https://stackoverflow.com/questions/2979383/java-clear-the-console
  public static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }


public static void printMatch(Chess_Match chessMatch_UI) {
  printBoard(chessMatch_UI.getPieces());
  System.out.println(); // Quebra de linha
  System.out.println("Turno | Turn: " + chessMatch_UI.getTurn());
  System.out.println("Aguardando Jogada | Waiting Player: " + chessMatch_UI.getCurrentPlayer());
}

  //!-------------------------->>>     Ler a posição do Usuário    <<<--------------------------

  public static Chess_Position readChessPosition(Scanner in) {
    try {
      String s = in.nextLine();
      char column = s.charAt(0);
      int row = Integer.parseInt(s.substring(1));
      return new Chess_Position(column, row);
    } catch (RuntimeException e) {
      throw new InputMismatchException(
        "Erro na leitura da posição ! ! !" +
        "\n" +
        " Valores Validos sã de A1 a H8"
      );
    }
  }
}
