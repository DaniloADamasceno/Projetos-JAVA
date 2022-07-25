package boardGame;

public class Piece {

  protected Position position;
  private Board board;

  //-------------------
  //    Constructor
  //-------------------
  public Piece() {
  }
  
  public Piece( Board board) {
      position = null;
      this.board = board;
  }
  //-------------------
  //Getters and Setters
  //-------------------

  protected Board getBoard() {
    return board;
  }

}
