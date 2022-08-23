package chess.chessPieces;

import boardGame.Board;
import boardGame.Position;
import chess.ChessPiece;
import chess.Color;

public class Bishop extends ChessPiece { // Classe Bispo

  //------------------------
  //!      Constructor
  //------------------------
  public Bishop(Board board, Color color) {
    super(board, color);
  }

  @Override
  public String toString() {
    return "B";
  }

  @Override
  public boolean[][] possibleMoves() {
    boolean[][] mat = new boolean[getBoard().getRows()][getBoard()
      .getColumns()];

    Position pStart = new Position(0, 0); // Posição inicial do Bispo

    //!------------------------------->>>     Marcar as posições Noroeste NW     <<<------------------------------
    pStart.setValues(position.getRow() - 1, position.getColumn() - 1);
    while (
      getBoard().positionExists(pStart) && !getBoard().thereIsAPiece(pStart)
    ) {
      mat[pStart.getRow()][pStart.getColumn()] = true;
      pStart.setValues(pStart.getRow() -1, pStart.getColumn() - 1);
    }
    if (getBoard().positionExists(pStart) && isThereAnyPossibleMove(pStart)) {
      mat[pStart.getRow()][pStart.getColumn()] = true;
    }

    //!------------------------------->>>     Marcar as posições Nordeste  NE    <<<------------------------------
    pStart.setValues(position.getRow() - 1, position.getColumn() +1 );
    while (
      getBoard().positionExists(pStart) && !getBoard().thereIsAPiece(pStart)
    ) {
      mat[pStart.getRow()][pStart.getColumn()] = true;
      pStart.setValues(pStart.getRow() - 1, pStart.getColumn() + 1);
    }
    if (getBoard().positionExists(pStart) && isThereAnyPossibleMove(pStart)) {
      mat[pStart.getRow()][pStart.getColumn()] = true;
    }

    //!------------------------------->>>     Marcar as posições a Sudeste  SE    <<<------------------------------
    pStart.setValues(position.getRow() + 1, position.getColumn() + 1);
    while (
      getBoard().positionExists(pStart) && !getBoard().thereIsAPiece(pStart)
    ) {
      mat[pStart.getRow()][pStart.getColumn()] = true;
      pStart.setValues(pStart.getRow() + 1, pStart.getColumn() + 1);
    }
    if (getBoard().positionExists(pStart) && isThereAnyPossibleMove(pStart)) {
      mat[pStart.getRow()][pStart.getColumn()] = true;
    }

    //!------------------------------->>>     Marcar as posições a Sudoeste SW    <<<------------------------------
    pStart.setValues(position.getRow() +1 , position.getColumn() - 1);
    while (
      getBoard().positionExists(pStart) && !getBoard().thereIsAPiece(pStart)
    ) {
      mat[pStart.getRow()][pStart.getColumn()] = true;
      pStart.setValues(pStart.getRow()  + 1, pStart.getColumn() - 1);
    }
    if (getBoard().positionExists(pStart) && isThereAnyPossibleMove(pStart)) {
      mat[pStart.getRow()][pStart.getColumn()] = true;
    }

    return mat;
  }
}

