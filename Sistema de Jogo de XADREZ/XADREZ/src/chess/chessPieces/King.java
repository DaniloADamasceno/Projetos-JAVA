package chess.chessPieces;

import boardGame.Board;
import boardGame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece { // Classe Rei

  //------------------------
  //!      Constructor
  //------------------------
  public King(Board board, Color color) {
    super(board, color);
  }

  @Override
  public String toString() {
    return "K";
  }

  private boolean canMove(Position position) { // Saber se o Rei podera mover-se para a posição
    ChessPiece p = (ChessPiece) getBoard().piece(position);
    return p == null || ((ChessPiece) p).getColor() != getColor();
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

    return mat;
  }
}
