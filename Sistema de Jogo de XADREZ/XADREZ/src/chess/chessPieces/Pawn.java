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
    Position p = new Position(0, 0);

    //!------------------------------->>>     Mover uma posição acima     <<<------------------------------
    if (getColor() == Color.WHITE) {
      p.setValues(position.getRow() - 1, position.getColumn());
      if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
        mat[p.getRow()][p.getColumn()] = true;
      }

      //!------------------------------->>>     Mover duas posições acima na primeira vez     <<<------------------------------
      p.setValues(position.getRow() - 2, position.getColumn());
      Position p2 = new Position(position.getRow() - 1, position.getColumn());
      if (getColor() == Color.WHITE) {
        if (
          getBoard().positionExists(p) &&
          !getBoard().thereIsAPiece(p) &&
          getBoard().positionExists(p2) &&
          !getBoard().thereIsAPiece(p2) &&
          getMoveCount() == 0
        ) {
          mat[p.getRow()][p.getColumn()] = true;
        }

        //!------------------------------->>>     Mover para a Esquerda     <<<------------------------------
        p.setValues(position.getRow() - 1, position.getColumn() - 1);
        if (getBoard().positionExists(p) && isThereAnyPossibleMove(p)) {
          mat[p.getRow()][p.getColumn()] = true;
        }
        //!------------------------------->>>     Mover para a Direita     <<<------------------------------
        p.setValues(position.getRow() - 1, position.getColumn() + 1);
        if (getBoard().positionExists(p) && isThereAnyPossibleMove(p)) {
          mat[p.getRow()][p.getColumn()] = true;
        }
      }
      //%%------------------------------->>>     Peças Pretas     <<<------------------------------
    } else {
      p.setValues(position.getRow() + 1, position.getColumn());
      if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
        mat[p.getRow()][p.getColumn()] = true;
      }

      //!------------------------------->>>     Mover duas posições acima na primeira vez     <<<------------------------------
      p.setValues(position.getRow() + 2, position.getColumn());
      Position p2 = new Position(position.getRow() + 1, position.getColumn());
      if (getColor() == Color.WHITE) {
        if (
          getBoard().positionExists(p) &&
          !getBoard().thereIsAPiece(p) &&
          getBoard().positionExists(p2) &&
          !getBoard().thereIsAPiece(p2) &&
          getMoveCount() == 0
        ) {
          mat[p.getRow()][p.getColumn()] = true;
        }

        //!------------------------------->>>     Mover para a Esquerda     <<<------------------------------
        p.setValues(position.getRow() + 1, position.getColumn() - 1);
        if (getBoard().positionExists(p) && isThereAnyPossibleMove(p)) {
          mat[p.getRow()][p.getColumn()] = true;
        }
        //!------------------------------->>>     Mover para a Direita     <<<------------------------------
        p.setValues(position.getRow() + 1, position.getColumn() + 1);
        if (getBoard().positionExists(p) && isThereAnyPossibleMove(p)) {
          mat[p.getRow()][p.getColumn()] = true;
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
