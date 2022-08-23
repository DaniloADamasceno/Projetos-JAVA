package chess.chessPieces;

import boardGame.Board;
import boardGame.Position;
import chess.ChessPiece;
import chess.Color;

public class Queen extends ChessPiece { // Classe Torre

  //------------------------
  //!      Constructor
  //------------------------
  public Queen(Board board, Color color) {
    super(board, color);
  }

  @Override
  public String toString() {
    return "Q";
  }

  @Override
  public boolean[][] possibleMoves() {
    boolean[][] mat = new boolean[getBoard().getRows()][getBoard()
      .getColumns()];

    Position pStart = new Position(0, 0); // Posição inicial da Rainha

    //!------------------------------->>>     Marcar as posições acima     <<<------------------------------
    pStart.setValues(position.getRow() - 1, position.getColumn());
    while (
      getBoard().positionExists(pStart) && !getBoard().thereIsAPiece(pStart)
    ) {
      mat[pStart.getRow()][pStart.getColumn()] = true;
      pStart.setRow(pStart.getRow() - 1);
    }
    if (getBoard().positionExists(pStart) && isThereAnyPossibleMove(pStart)) {
      mat[pStart.getRow()][pStart.getColumn()] = true;
    }

    //!------------------------------->>>     Marcar as posições abaixo     <<<------------------------------
    pStart.setValues(position.getRow() + 1, position.getColumn());
    while (
      getBoard().positionExists(pStart) && !getBoard().thereIsAPiece(pStart)
    ) {
      mat[pStart.getRow()][pStart.getColumn()] = true;
      pStart.setRow(pStart.getRow() + 1);
    }
    if (getBoard().positionExists(pStart) && isThereAnyPossibleMove(pStart)) {
      mat[pStart.getRow()][pStart.getColumn()] = true;
    }

    //!------------------------------->>>     Marcar as posições a Esquerda     <<<------------------------------
    pStart.setValues(position.getRow(), position.getColumn() - 1);
    while (
      getBoard().positionExists(pStart) && !getBoard().thereIsAPiece(pStart)
    ) {
      mat[pStart.getRow()][pStart.getColumn()] = true;
      pStart.setColumn(pStart.getColumn() - 1);
    }
    if (getBoard().positionExists(pStart) && isThereAnyPossibleMove(pStart)) {
      mat[pStart.getRow()][pStart.getColumn()] = true;
    }

    //!------------------------------->>>     Marcar as posições a Direita     <<<------------------------------
    pStart.setValues(position.getRow(), position.getColumn() + 1);
    while (
      getBoard().positionExists(pStart) && !getBoard().thereIsAPiece(pStart)
    ) {
      mat[pStart.getRow()][pStart.getColumn()] = true;
      pStart.setColumn(pStart.getColumn() + 1);
    }
    if (getBoard().positionExists(pStart) && isThereAnyPossibleMove(pStart)) {
        mat[pStart.getRow()][pStart.getColumn()] = true;
    }
    
        //!------------------------------->>>     Marcar as posições acima     <<<------------------------------
    pStart.setValues(position.getRow() - 1, position.getColumn());
    while (
      getBoard().positionExists(pStart) && !getBoard().thereIsAPiece(pStart)
    ) {
      mat[pStart.getRow()][pStart.getColumn()] = true;
      pStart.setRow(pStart.getRow() - 1);
    }
    if (getBoard().positionExists(pStart) && isThereAnyPossibleMove(pStart)) {
      mat[pStart.getRow()][pStart.getColumn()] = true;
    }

    //!------------------------------->>>     Marcar as posições abaixo     <<<------------------------------
    pStart.setValues(position.getRow() + 1, position.getColumn());
    while (
      getBoard().positionExists(pStart) && !getBoard().thereIsAPiece(pStart)
    ) {
      mat[pStart.getRow()][pStart.getColumn()] = true;
      pStart.setRow(pStart.getRow() + 1);
    }
    if (getBoard().positionExists(pStart) && isThereAnyPossibleMove(pStart)) {
      mat[pStart.getRow()][pStart.getColumn()] = true;
    }

    //!------------------------------->>>     Marcar as posições a Esquerda     <<<------------------------------
    pStart.setValues(position.getRow(), position.getColumn() - 1);
    while (
      getBoard().positionExists(pStart) && !getBoard().thereIsAPiece(pStart)
    ) {
      mat[pStart.getRow()][pStart.getColumn()] = true;
      pStart.setColumn(pStart.getColumn() - 1);
    }
    if (getBoard().positionExists(pStart) && isThereAnyPossibleMove(pStart)) {
      mat[pStart.getRow()][pStart.getColumn()] = true;
    }

    //!------------------------------->>>     Marcar as posições a Direita     <<<------------------------------
    pStart.setValues(position.getRow(), position.getColumn() + 1);
    while (
      getBoard().positionExists(pStart) && !getBoard().thereIsAPiece(pStart)
    ) {
      mat[pStart.getRow()][pStart.getColumn()] = true;
      pStart.setColumn(pStart.getColumn() + 1);
    }
    if (getBoard().positionExists(pStart) && isThereAnyPossibleMove(pStart)) {
      mat[pStart.getRow()][pStart.getColumn()] = true;
    }

    return mat;
  }
}
