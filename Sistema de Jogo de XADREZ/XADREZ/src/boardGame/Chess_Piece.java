package boardGame;

public abstract class Chess_Piece {

  protected Position position;
  private Board board;

  //-------------------
  //!    Constructor
  //-------------------
  public Chess_Piece() {}

  public Chess_Piece(Board board) {
    position = null;
    this.board = board;
  }

  //-----------------------
  //!  Getters and Setters
  //-----------------------

  protected Board getBoard() {
    return board;
  }

  //-------------------
  //!    Methods
  //-------------------

  public abstract boolean[][] possibleMoves();

  public boolean possibleMoves(Position position) {
    return possibleMoves()[position.getRow()][position.getColumn()];
  }

  //!-------------------------->>>     Verificar se existe alguma jogada possível    <<<--------------------------
  public boolean isThereAnyPossibleMove() {
    boolean[][] mat = possibleMoves();
    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat.length; j++) {
        if (mat[i][j]) {
          return true;
        }
      }
    }
    return false;
  }
}
