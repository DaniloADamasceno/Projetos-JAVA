package chess.chessPieces;

import boardGame.Board;
import boardGame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece { // Classe Rei

  private ChessMatch chessMatch;

  //------------------------
  //!      Constructor
  //------------------------
  public King(Board board, Color color, ChessMatch chessMatch) {
    super(board, color);
    this.chessMatch = chessMatch;
  }

  @Override
  public String toString() {
    return "K";
  }

  private boolean canMove(Position position) { // Saber se o Rei podera mover-se para a posição
    ChessPiece p = (ChessPiece) getBoard().piece(position);
    return p == null || ((ChessPiece) p).getColor() != getColor();
  }

  //!------------------------------->>>     Método para testar a Condição de ROOK    <<<------------------------------
  private boolean testRookCastling(Position position) {
    ChessPiece p = (ChessPiece) getBoard().piece(position);
    return (
      p != null &&
      p instanceof Rook &&
      p.getColor() == getColor() &&
      p.getMoveCount() == 0
    );
  }

  @Override
  public boolean[][] possibleMoves() {
    boolean[][] mat = new boolean[getBoard().getRows()][getBoard()
      .getColumns()];

    Position pStart = new Position(0, 0); // Posição do REI

    //!------------------------------->>>     Marcar as posições acima     <<<------------------------------
    pStart.setValues(position.getRow() - 1, position.getColumn());
    if (getBoard().positionExists(pStart) && canMove(pStart)) {
      mat[pStart.getRow()][pStart.getColumn()] = true;
    }
    //!------------------------------->>>     Marcar as posições abaixo     <<<------------------------------
    pStart.setValues(position.getRow() + 1, position.getColumn());
    if (getBoard().positionExists(pStart) && canMove(pStart)) {
      mat[pStart.getRow()][pStart.getColumn()] = true;
    }
    //!------------------------------->>>     Marcar as posições Esquerda     <<<------------------------------
    pStart.setValues(position.getRow(), position.getColumn() - 1);
    if (getBoard().positionExists(pStart) && canMove(pStart)) {
      mat[pStart.getRow()][pStart.getColumn()] = true;
    }
    //!------------------------------->>>     Marcar as posições Direita     <<<------------------------------
    pStart.setValues(position.getRow(), position.getColumn() + 1);
    if (getBoard().positionExists(pStart) && canMove(pStart)) {
      mat[pStart.getRow()][pStart.getColumn()] = true;
    }
    //!------------------------------->>>     Marcar as posições Noroeste     <<<------------------------------
    pStart.setValues(position.getRow() - 1, position.getColumn() - 1);
    if (getBoard().positionExists(pStart) && canMove(pStart)) {
      mat[pStart.getRow()][pStart.getColumn()] = true;
    }
    //!------------------------------->>>     Marcar as posições Nordeste     <<<------------------------------
    pStart.setValues(position.getRow() - 1, position.getColumn() + 1);
    if (getBoard().positionExists(pStart) && canMove(pStart)) {
      mat[pStart.getRow()][pStart.getColumn()] = true;
    }
    //!------------------------------->>>     Marcar as posições Sudeste     <<<------------------------------
    pStart.setValues(position.getRow() + 1, position.getColumn() - 1);
    if (getBoard().positionExists(pStart) && canMove(pStart)) {
      mat[pStart.getRow()][pStart.getColumn()] = true;
    }
    //!------------------------------->>>     Marcar as posições Sudeste     <<<------------------------------
    pStart.setValues(position.getRow() + 1, position.getColumn() + 1);
    if (getBoard().positionExists(pStart) && canMove(pStart)) {
      mat[pStart.getRow()][pStart.getColumn()] = true;
    }

    //!------------------------------->>>     Movimento Especial de Castling     <<<------------------------------
    if (getMoveCount() == 0 && !chessMatch.getCheck()) {
      
      //!------------------------------->>>     Testar o Rook do lado do Rei     <<<------------------------------
      Position positionT1 = new Position(position.getRow(), position.getColumn() + 3);
      if (testRookCastling(positionT1)) {
        Position p1 = new Position(position.getRow(), position.getColumn() + 1);
        Position p2 = new Position(position.getRow(), position.getColumn() + 2);
        if (getBoard().piece(p1) == null && getBoard().piece(p2) == null) {
          mat[position.getRow()][position.getColumn() + 2] = true;
        }
      }
      //!------------------------------->>>     Testar o Rook do lado da Rainha     <<<------------------------------
            Position positionT2 = new Position(position.getRow(), position.getColumn() - 4);
       if (testRookCastling(positionT2)) {
        Position p1 = new Position(position.getRow(), position.getColumn() - 1);
        Position p2 = new Position(position.getRow(), position.getColumn() - 2);
        Position p3 = new Position(position.getRow(), position.getColumn() - 3);
        if (getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null) {
          mat[position.getRow()][position.getColumn() - 2] = true;
        }
      }
    }

    return mat;
  }
}
