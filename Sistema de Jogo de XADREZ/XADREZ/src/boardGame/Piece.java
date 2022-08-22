package boardGame;


public abstract class Piece {

	protected Position position;
    private Board board;
  
  //-------------------
  //!    Constructor
  //-------------------

  public Piece(Board board) {
		this.board = board;
		position = null;
  }

  //-------------------------
  //!    Getters and Setters
  //-------------------------

	protected Board getBoard() {
		return board;
	}

  //-------------------
  //!    Methods
  //-------------------
    //!--------------->>>     Consultar os movimentos possíveis    <<<-----------------

  public abstract boolean[][] possibleMoves();
	
	public boolean possibleMove(Position position) {
    return possibleMoves()[position.getRow()][position.getColumn()];
	}
	
  //!--------------->>>     Pegar peça do oponente     <<<-----------------
	public boolean isThereAnyPossibleMove(Position p) {
		boolean[][] mat = possibleMoves();
		for (int i=0; i<mat.length; i++) {
			for (int j=0; j<mat.length; j++) {
				if (mat[i][j]) {
					return true;
				}
			}
		}
		return false;
	}
}
