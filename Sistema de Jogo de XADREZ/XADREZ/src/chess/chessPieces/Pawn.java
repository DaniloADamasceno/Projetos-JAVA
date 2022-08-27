package chess.chessPieces;

import boardGame.Board;
import boardGame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece { // Classe Peão

  private ChessMatch chessMatch;

  //------------------------
  //!      Constructor
  //------------------------

  public Pawn(Board board, Color color, ChessMatch chessMatch) {
    super(board, color);
    this.chessMatch = chessMatch;
  }

  @Override
  public boolean[][] possibleMoves() {
    boolean[][] mat = new boolean[getBoard().getRows()][getBoard()
      .getColumns()];
    Position pStart = new Position(0, 0); // Posição inicial do Peão

    //%%------------------------------->>>     Peças Brancas     <<<------------------------------
    //!------------------------------->>>     Mover uma posição acima     <<<------------------------------
    if (getColor() == Color.WHITE) {
      pStart.setValues(position.getRow() - 1, position.getColumn());
      if (
        getBoard().positionExists(pStart) && !getBoard().thereIsAPiece(pStart)
      ) {
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
        if (
          getBoard().positionExists(pStart) && isThereAnyPossibleMove(pStart)
        ) {
          mat[pStart.getRow()][pStart.getColumn()] = true;
        }
        //!------------------------------->>>     Mover para a Direita     <<<------------------------------
        pStart.setValues(position.getRow() - 1, position.getColumn() + 1);
        if (
          getBoard().positionExists(pStart) && isThereAnyPossibleMove(pStart)
        ) {
          mat[pStart.getRow()][pStart.getColumn()] = true;
        }

        //!------------------------------->>>     Movimento Especial En Passant peça Branca    <<<------------------------------
        if (position.getRow() == 3) {
          Position left = new Position(
            position.getRow(),
            position.getColumn() - 1
          );
          if (
            getBoard().positionExists(left) &&
            IsThereOpponentPiece(left) &&
            getBoard().piece(left) == chessMatch.getEnPassantVulnerable()
          ) {
            mat[left.getRow() - 1][left.getColumn()] = true;
          }
          Position right = new Position(
            position.getRow(),
            position.getColumn() + 1
          );
          if (
            getBoard().positionExists(right) &&
            IsThereOpponentPiece(right) &&
            getBoard().piece(right) == chessMatch.getEnPassantVulnerable()
          ) {
            mat[right.getRow() - 1][right.getColumn()] = true;
          }
        }
      }
      //%%------------------------------->>>     Peças Pretas     <<<------------------------------
    } else {
      pStart.setValues(position.getRow() + 1, position.getColumn());
      if (
        getBoard().positionExists(pStart) && !getBoard().thereIsAPiece(pStart)
      ) {
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
        if (
          getBoard().positionExists(pStart) && isThereAnyPossibleMove(pStart)
        ) {
          mat[pStart.getRow()][pStart.getColumn()] = true;
        }
        //!------------------------------->>>     Mover para a Direita     <<<------------------------------
        pStart.setValues(position.getRow() + 1, position.getColumn() + 1);
        if (
          getBoard().positionExists(pStart) && isThereAnyPossibleMove(pStart)
        ) {
          mat[pStart.getRow()][pStart.getColumn()] = true;
        }
        //!------------------------------->>>     Movimento Especial En Passant peça Preta   <<<------------------------------
        if (position.getRow() == 4) {
          Position left = new Position(
            position.getRow(),
            position.getColumn() - 1
          );
          if (
            getBoard().positionExists(left) &&
            IsThereOpponentPiece(left) &&
            getBoard().piece(left) == chessMatch.getEnPassantVulnerable()
          ) {
            mat[left.getRow() - 1][left.getColumn()] = true;
          }
          Position right = new Position(
            position.getRow(),
            position.getColumn() + 1
          );
          if (
            getBoard().positionExists(right) &&
            IsThereOpponentPiece(right) &&
            getBoard().piece(right) == chessMatch.getEnPassantVulnerable()
          ) {
            mat[right.getRow() - 1][right.getColumn()] = true;
          }
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
