package application;

//import boardGame.Piece;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.Chess_Exception;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import java.util.Locale;

public class Chess_Game {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Locale.setDefault(Locale.US);

    ChessMatch chessMatch = new ChessMatch();
    List<ChessPiece> captured = new ArrayList<>();

    //ChessMatch chessMatch;
    while (!chessMatch.getCheckMate()) {
      try {
        User_Interface.clearScreen(); // Limpa a tela
        User_Interface.printMatch(chessMatch, captured);
        System.out.println(); // Quebra de linha

        System.out.print("Posição de Origem | Source: ");
        ChessPosition source = User_Interface.readChessPosition(in);
        System.out.println(); // Quebra de linha

        boolean[][] possibleMoves = chessMatch.possibleMoves(source); // Pega os possíveis movimentos
        User_Interface.clearScreen(); // Limpa a tela
        User_Interface.printBoard(chessMatch.getPieces(), possibleMoves);
        System.out.println(); // Quebra de linha

        System.out.print("Posição de Destino | Target: ");
        ChessPosition target = User_Interface.readChessPosition(in);

        ChessPiece capturedPiece = chessMatch.performChessMove(source, target);

        if (capturedPiece != null) {
          captured.add(capturedPiece);
        }
        //!--------------->>>     Criar a peça promovida     <<<-----------------
        if (chessMatch.getPromoted() != null) {
          System.out.print(
            " Entre com a Peça a Ser PROMOVIDA | Enter piece for promotion (B / N / R / Q): "
          );
          String type = in.nextLine().toUpperCase();
          while (
            !type.equals("B") &&
            !type.equals("N") &&
            !type.equals("R") &&
            !type.equals("Q")
          ) {
            System.out.print(
              " VALOR DE PEÇA INVALIDA: Entre com uma peça valida| Invalid value! Enter piece for promotion (B / N / R / Q ): "
            );
            type = in.nextLine().toUpperCase();
          }
          chessMatch.replacePromotedPiece(type);
        }
      } catch (Chess_Exception e) {
        System.out.println(e.getMessage());
        in.nextLine();
      } catch (InputMismatchException e) {
        System.out.println(e.getMessage());
        in.nextLine();
      }
    }
    User_Interface.clearScreen(); // Limpa a tela
    User_Interface.printMatch(chessMatch, captured);
  }
}
