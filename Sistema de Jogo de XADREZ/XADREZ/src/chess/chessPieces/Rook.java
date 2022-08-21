package chess.chessPieces;

import boardGame.Board;
import boardGame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece { // Classe Torre

  //------------------------
  //!      Constructor
  //------------------------
  public Rook(Board board, Color color) {
    super(board, color);
  }

  @Override
  public String toString() {
    return "T";
  }

  @Override
  public boolean[][] possibleMoves() {
    boolean[][] mat = new boolean[getBoard().getRows()][getBoard()
      .getColumns()];

    Position pInit = new Position(0, 0); // Posição inicial

    //!------------------------------->>>     Marcar as posições acima     <<<------------------------------
    pInit.setValues(position.getRow() - 1, position.getColumn());
    while (
      getBoard().positionExists(pInit) && !getBoard().thereIsAPiece(pInit)
    ) {
      mat[pInit.getRow()][pInit.getColumn()] = true;
      pInit.setRow(pInit.getRow() - 1);
    }
    if (getBoard().positionExists(pInit) && isThereAnyPossibleMove(pInit)) {
      mat[pInit.getRow()][pInit.getColumn()] = true;
    }

    //!------------------------------->>>     Marcar as posições abaixo     <<<------------------------------
    pInit.setValues(position.getRow() + 1, position.getColumn());
    while (
      getBoard().positionExists(pInit) && !getBoard().thereIsAPiece(pInit)
    ) {
      mat[pInit.getRow()][pInit.getColumn()] = true;
      pInit.setRow(pInit.getRow() + 1);
    }
    if (getBoard().positionExists(pInit) && isThereAnyPossibleMove(pInit)) {
      mat[pInit.getRow()][pInit.getColumn()] = true;
    }

    //!------------------------------->>>     Marcar as posições a Esquerda     <<<------------------------------
    pInit.setValues(position.getRow(), position.getColumn() - 1);
    while (
      getBoard().positionExists(pInit) && !getBoard().thereIsAPiece(pInit)
    ) {
      mat[pInit.getRow()][pInit.getColumn()] = true;
      pInit.setColumn(pInit.getColumn() - 1);
    }
    if (getBoard().positionExists(pInit) && isThereAnyPossibleMove(pInit)) {
      mat[pInit.getRow()][pInit.getColumn()] = true;
    }

    //!------------------------------->>>     Marcar as posições a Direita     <<<------------------------------
    pInit.setValues(position.getRow(), position.getColumn() + 1);
    while (
      getBoard().positionExists(pInit) && !getBoard().thereIsAPiece(pInit)
    ) {
      mat[pInit.getRow()][pInit.getColumn()] = true;
      pInit.setColumn(pInit.getColumn() + 1);
    }
    if (getBoard().positionExists(pInit) && isThereAnyPossibleMove(pInit)) {
      mat[pInit.getRow()][pInit.getColumn()] = true;
    }

    return mat;
  }
}
