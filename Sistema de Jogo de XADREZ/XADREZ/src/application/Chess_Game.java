package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import boardGame.Piece;
import chess.ChessMatch;
import chess.Chess_Exception;
import chess.ChessPosition;

public class Chess_Game {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Locale.setDefault(Locale.US);

    ChessMatch match = new ChessMatch();
    List<Piece> captured = new ArrayList<>();

    while (!chessMatch.getCheckMate()) {
      try {
        User_Interface.clearScreen(); // Limpa a tela
        User_Interface.printMatch(chessMatch, captured);
        System.out.println(); // Quebra de linha

        System.out.print("Posição de Origem | Source: ");
        ChessPosition source = User_Interface.readChessPosition(in);
        System.out.println(); // Quebra de linha

        boolean[][] possibleMoves = match.possibleMoves(source); // Pega os possíveis movimentos
        User_Interface.clearScreen(); // Limpa a tela
        User_Interface.printBoard(chessMatch.getPieces(), possibleMoves);
        System.out.println(); // Quebra de linha

        System.out.print("Posição de Destino | Target: ");
        ChessPosition target = User_Interface.readChessPosition(in);

        Piece capturedPiece = ChessMatch.performChessMove(source, target);

        if (capturedPiece != null) {
          captured.add(capturedPiece);
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

    
    System.out.println(); // Quebra de linha final 
    in.close();
  }
  }
