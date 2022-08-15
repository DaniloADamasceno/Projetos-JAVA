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
    super(board, color);
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
  public ChessPosition getChessPosition() {
    return ChessPosition.fromPosition(position);
  }

  //-------------------
  //!    Methods
  //-------------------

  public ChessPosition getChessPosition(Position position) {
    return ChessPosition.fromPosition(position);
  }

  //!--------------->>>     Pegar peça do oponente     <<<-----------------
  protected boolean IsThereOpponentPiece(Position position) {
    ChessPiece p = (ChessPiece) getBoard().piece(position);
    return p != null && p.getColor() != color;
  }
}
