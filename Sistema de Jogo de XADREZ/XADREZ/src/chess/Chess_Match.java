package chess;

import boardGame.Board;
import boardGame.Position;
import chessPieces.Bishop;
import chessPieces.King;
import chessPieces.Knight;
import chessPieces.Pawn;
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

    //---------------------------------------
    //   ROOKS / TORRES ( Brancas e Pretas )
    //---------------------------------------
    placeNewPiece('a', 1, new Rook(board, Color.WHITE)); // Torre branca #01
    placeNewPiece('h', 1, new Rook(board, Color.WHITE)); // Torre branca #02

    placeNewPiece('h', 8, new Rook(board, Color.BLACK)); // Torre preta #01
    placeNewPiece('a', 8, new Rook(board, Color.BLACK)); // Torre preta #02

    //---------------------------------------
    //   KNIGHTS / CAVALO ( Brancas e Pretas )
    //---------------------------------------
    placeNewPiece('b', 1, new Knight(board, Color.WHITE)); // Cavaleiro branco #01
    placeNewPiece('g', 1, new Knight(board, Color.WHITE)); // Cavaleiro branco #02

    placeNewPiece('g', 8, new Knight(board, Color.BLACK)); // Cavaleiro preta #01
    placeNewPiece('b', 8, new Knight(board, Color.BLACK)); // Cavaleiro preta #02

    //---------------------------------------
    //   BISHOPS / BISPO ( Brancas e Pretas )
    //---------------------------------------
    placeNewPiece('c', 1, new Bishop(board, Color.WHITE)); // Bispo branco #01
    placeNewPiece('f', 1, new Bishop(board, Color.WHITE)); // Bispo branco #02

    placeNewPiece('f', 8, new Bishop(board, Color.BLACK)); // Bispo preta #01
    placeNewPiece('c', 8, new Bishop(board, Color.BLACK)); // Bispo preta #02

    //---------------------------------------
    //   QUEENS / RAINHA ( Brancas e Pretas )
    //---------------------------------------
    placeNewPiece('d', 1, new Queen(board, Color.WHITE)); // Rainha branca #01
    placeNewPiece('d', 8, new Queen(board, Color.BLACK)); // Rainha preta #01

    //---------------------------------------
    //   KINGS / REI ( Brancas e Pretas )
    //---------------------------------------
    placeNewPiece('e', 1, new King(board, Color.WHITE)); // Rei branco #01
    placeNewPiece('e', 8, new King(board, Color.BLACK)); // Rei preta #01

    //---------------------------------------
    //   PAWNS / PEÕES ( Brancas e Pretas )
    //---------------------------------------
    // for (int i = 0; i < 8; i++) {
    //   placeNewPiece('a', 2 + i, new Pawn(board, Color.WHITE)); // Peões brancos #01
    //   placeNewPiece('h', 2 + i, new Pawn(board, Color.BLACK)); // Peões pretos #01
    // }



    
    
 
  }
}
