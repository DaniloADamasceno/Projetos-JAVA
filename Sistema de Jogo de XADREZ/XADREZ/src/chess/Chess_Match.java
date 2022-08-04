package chess;

import boardGame.Board;
import boardGame.Position;
import chessPieces.King;
import chessPieces.Queen;
import chessPieces.Rook;

public class Chess_Match {

  private Board board;
  private int turn;
  private Color currentPlayer;
  private boolean check;
  private boolean checkMate;

  //-------------------
  //    Constructor
  //-------------------

  public Chess_Match() {
    board = new Board(8, 8);
    initialSetup(); // Inicializa o tabuleiro com as peças
  }

  public Chess_Piece[][] getPieces() {
    Chess_Piece[][] match_pieces = new Chess_Piece[board.getRows()][board.getColumns()];
    for (int i = 0; i < board.getRows(); i++) {
      for (int j = 0; j < board.getColumns(); j++) {
        match_pieces[i][j] = (Chess_Piece) board.piece(i, j);
      }
    }
    return match_pieces;
  }

  private void placeNewPiece(char column, int row, Chess_Piece piece) {
    board.placePiece(piece, new ChessPosition(column, row).toPosition());
  }

  private void initialSetup() {
    placeNewPiece('b', 6, new Rook(board, Color.WHITE)); // Torre branca #01
    placeNewPiece('b', 1, new Rook(board, Color.WHITE)); // Torre branca #02

    placeNewPiece('a', 6, new Rook(board, Color.BLACK)); // Torre preta #01
    placeNewPiece('a', 2, new Rook(board, Color.BLACK)); // Torre preta #02

    placeNewPiece('c', 3, new King(board, Color.WHITE));
    placeNewPiece('d', 4, new King(board, Color.BLACK));

    placeNewPiece('e', 5, new Queen(board, Color.BLACK));
    placeNewPiece('f', 6, new Queen(board, Color.WHITE));
  }
}
