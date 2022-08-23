package chess.chessPieces;

import boardGame.Board;
import boardGame.Position;
//import boardGame.Piece;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece { // Classe Peão

  //------------------------
  //!      Constructor
  //------------------------

  public Pawn(Board board, Color color) {
    super(board, color);
  }

  @Override
  public boolean[][] possibleMoves() {
    boolean[][] mat = new boolean[getBoard().getRows()][getBoard()
      .getColumns()];
    Position pStart = new Position(0, 0); // Posição inicial do Peão

    //!------------------------------->>>     Mover uma posição acima     <<<------------------------------
    if (getColor() == Color.WHITE) {
      pStart.setValues(position.getRow() - 1, position.getColumn());
      if (getBoard().positionExists(pStart) && !getBoard().thereIsAPiece(pStart)) {
        mat[pStart.getRow()][pStart.getColumn()] = true;
      }

      //!------------------------------->>>     Mover duas posições acima na primeira vez     <<<------------------------------
      pStart.setValues(position.getRow() - 2, position.getColumn());
      Position p2 = new Position(position.getRow() - 1, position.getColumn());
      if (getColor() == Color.WHITE) {
        if (
          getBoard().positionExists(pStart) &&
          !getBoard().thereIsAPiece(pStart) &&
          getBoard().positionExists(p2) &&
          !getBoard().thereIsAPiece(p2) &&
          getMoveCount() == 0
        ) {
          mat[pStart.getRow()][pStart.getColumn()] = true;
        }

        //!------------------------------->>>     Mover para a Esquerda     <<<------------------------------
        pStart.setValues(position.getRow() - 1, position.getColumn() - 1);
        if (getBoard().positionExists(pStart) && isThereAnyPossibleMove(pStart)) {
          mat[pStart.getRow()][pStart.getColumn()] = true;
        }
        //!------------------------------->>>     Mover para a Direita     <<<------------------------------
        pStart.setValues(position.getRow() - 1, position.getColumn() + 1);
        if (getBoard().positionExists(pStart) && isThereAnyPossibleMove(pStart)) {
          mat[pStart.getRow()][pStart.getColumn()] = true;
        }
      }
      //%%------------------------------->>>     Peças Pretas     <<<------------------------------
    } else {
      pStart.setValues(position.getRow() + 1, position.getColumn());
      if (getBoard().positionExists(pStart) && !getBoard().thereIsAPiece(pStart)) {
        mat[pStart.getRow()][pStart.getColumn()] = true;
      }

      //!------------------------------->>>     Mover duas posições acima na primeira vez     <<<------------------------------
      pStart.setValues(position.getRow() + 2, position.getColumn());
      Position p2 = new Position(position.getRow() + 1, position.getColumn());
      if (getColor() == Color.WHITE) {
        if (
          getBoard().positionExists(pStart) &&
          !getBoard().thereIsAPiece(pStart) &&
          getBoard().positionExists(p2) &&
          !getBoard().thereIsAPiece(p2) &&
          getMoveCount() == 0
        ) {
          mat[pStart.getRow()][pStart.getColumn()] = true;
        }

        //!------------------------------->>>     Mover para a Esquerda     <<<------------------------------
        pStart.setValues(position.getRow() + 1, position.getColumn() - 1);
        if (getBoard().positionExists(pStart) && isThereAnyPossibleMove(pStart)) {
          mat[pStart.getRow()][pStart.getColumn()] = true;
        }
        //!------------------------------->>>     Mover para a Direita     <<<------------------------------
        pStart.setValues(position.getRow() + 1, position.getColumn() + 1);
        if (getBoard().positionExists(pStart) && isThereAnyPossibleMove(pStart)) {
          mat[pStart.getRow()][pStart.getColumn()] = true;
        }
      }
    }
    return mat;
  }

  @Override
  public String toString() {
    return "P";
  }
}
