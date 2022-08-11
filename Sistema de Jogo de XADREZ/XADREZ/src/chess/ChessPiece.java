package chess;

import boardGame.Board;
import boardGame.Piece;
import boardGame.Position;


public abstract class ChessPiece extends Piece {

  private Color color;
  private int moveCount;

  //-------------------
  //!    Constructor
  //-------------------
  public ChessPiece(Board board, Color color) {
    super(board);
    this.color = color;
  }
  
  //-------------------------
  //!    Getters and Setters
  //-------------------------
  public Color getColor() {
    return color;
  }

  public int getMoveCount() {
		return moveCount;
	}
	
	protected void increaseMoveCount() {
		moveCount++;
	}

	protected void decreaseMoveCount() {
		moveCount--;
	}
  public Chess_Position getChessPosition() {
    return Chess_Position.fromPosition(position);
  }

  //-------------------
  //!    Methods
  //-------------------
  //!--------------->>>     Pegar peça do oponente     <<<-----------------
  protected boolean IsThereOpponentPiece(Position position) {
    ChessPiece p = (ChessPiece) getBoard().piece(position);
    return p != null && p.getColor() != color;
  }
}
