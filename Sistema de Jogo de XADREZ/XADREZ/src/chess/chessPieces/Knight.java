package chess.chessPieces;

import boardGame.Board;
import boardGame.Position;
import chess.ChessPiece;
import chess.Color;

public class Knight extends ChessPiece { // Classe Rei

  //------------------------
  //!      Constructor
  //------------------------
  public Knight(Board board, Color color) {
    super(board, color);
  }

  @Override
  public String toString() {
    return "C";
  }

  private boolean canMove(Position position) { // Saber se o Rei podera mover-se para a posição
    ChessPiece p = (ChessPiece) getBoard().piece(position);
    return p == null || ((ChessPiece) p).getColor() != getColor();
  }

  @Override
  public boolean[][] possibleMoves() {
    boolean[][] mat = new boolean[getBoard().getRows()][getBoard()
      .getColumns()];

    Position pInit = new Position(0, 0); // Posição do REI

    //!------------------------------->>>     Marcar as posições acima     <<<------------------------------
    pInit.setValues(position.getRow() - 1, position.getColumn() - 2);
    if (getBoard().positionExists(pInit) && canMove(pInit)) {
      mat[pInit.getRow()][pInit.getColumn()] = true;
    }
    //!------------------------------->>>     Marcar as posições abaixo     <<<------------------------------
    pInit.setValues(position.getRow() - 2, position.getColumn() - 1);
    if (getBoard().positionExists(pInit) && canMove(pInit)) {
      mat[pInit.getRow()][pInit.getColumn()] = true;
    }
    //!------------------------------->>>     Marcar as posições Esquerda     <<<------------------------------
    pInit.setValues(position.getRow() - 2, position.getColumn() + 1);
    if (getBoard().positionExists(pInit) && canMove(pInit)) {
      mat[pInit.getRow()][pInit.getColumn()] = true;
    }
    //!------------------------------->>>     Marcar as posições Direita     <<<------------------------------
    pInit.setValues(position.getRow() - 1, position.getColumn() + 2);
    if (getBoard().positionExists(pInit) && canMove(pInit)) {
      mat[pInit.getRow()][pInit.getColumn()] = true;
    }
    //!------------------------------->>>     Marcar as posições Noroeste     <<<------------------------------
    pInit.setValues(position.getRow() + 1, position.getColumn() + 2);
    if (getBoard().positionExists(pInit) && canMove(pInit)) {
      mat[pInit.getRow()][pInit.getColumn()] = true;
    }
    //!------------------------------->>>     Marcar as posições Nordeste     <<<------------------------------
    pInit.setValues(position.getRow() + 2, position.getColumn() + 1);
    if (getBoard().positionExists(pInit) && canMove(pInit)) {
      mat[pInit.getRow()][pInit.getColumn()] = true;
    }
    //!------------------------------->>>     Marcar as posições Sudeste     <<<------------------------------
    pInit.setValues(position.getRow() + 2, position.getColumn() - 1);
    if (getBoard().positionExists(pInit) && canMove(pInit)) {
      mat[pInit.getRow()][pInit.getColumn()] = true;
    }
    //!------------------------------->>>     Marcar as posições Sudeste     <<<------------------------------
    pInit.setValues(position.getRow() + 1, position.getColumn() - 2);
    if (getBoard().positionExists(pInit) && canMove(pInit)) {
      mat[pInit.getRow()][pInit.getColumn()] = true;
    }

    return mat;
  }
}
