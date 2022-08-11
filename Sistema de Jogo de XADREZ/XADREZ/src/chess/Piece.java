package chess;

import boardGame.Board;
import boardGame.Chess_Piece;
import boardGame.Position;

public abstract class Piece extends Chess_Piece {

  private Color color;

  //-------------------
  //!    Constructor
  //-------------------
  public Piece(Board board, Color color) {
    super(board);
    this.color = color;
  }

  //-------------------------
  //!    Getters and Setters
  //-------------------------
  public Color getColor() {
    return color;
  }

  //-------------------
  //!    Methods
  //-------------------
  //!--------------->>>     Pegar peça do oponente     <<<-----------------
  protected boolean IsThereOpponentPiece(Position position) {
    Piece p = (Piece) getBoard().piece(position);
    return p != null && p.getColor() != color;
  }
}
