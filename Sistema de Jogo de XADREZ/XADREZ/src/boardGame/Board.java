package boardGame;

public class Board {

  private int rows;
  private int columns;
  private Chess_Piece[][] pieces;

  //-------------------
  //!    Constructor
  //-------------------
  public Board(int rows, int columns) {
    if (rows < 1 || columns < 1) {
      throw new BoardException(
        "ERRO: ao criar o Tabuleiro: deve haver pelo menos 1 linha e 1 coluna" +
        "\n" +
        "ERROR: creating the Board: there must be at least 1 row and 1 column"
      );
    }
    this.rows = rows;
    this.columns = columns;
    pieces = new Chess_Piece[rows][columns];
  }

  public Board() {}

  //--------------------------
  //!     Getters and Setters
  //--------------------------

  public int getRows() {
    return rows;
  }

  public int getColumns() {
    return columns;
  }

  //-------------------
  //!    Methods
  //-------------------

  //!-------------------->>>    Tratamento de Exceções    <<<---------------------

  public Chess_Piece piece(int row, int column) {
    if (!positionExists(row, column)) {
      throw new BoardException(
        "Posição NÃO EXISTE tabuleiro | Position NO board"
      );
    }
    return pieces[row][column];
  }

  public Chess_Piece piece(Position position) {
    if (!positionExists(position)) {
      throw new BoardException(
        "Posição NÃO EXISTE tabuleiro | Position NO board"
      );
    }
    return pieces[position.getRow()][position.getColumn()];
  }

  public void placePiece(Chess_Piece piece, Position position) {
    if (thereIsAPiece(position)) {
      throw new BoardException(
        "já existe uma peça na posição | there is already a part in position:  " +
        position
      );
    }
    pieces[position.getRow()][position.getColumn()] = piece;
    piece.position = position;
  }

  private boolean positionExists(int row, int column) {
    return row >= 0 && row < rows && column >= 0 && column < columns;
  }

  public boolean positionExists(Position position) {
    return positionExists(position.getRow(), position.getColumn());
  }

  public boolean thereIsAPiece(Position position) {
    if (!positionExists(position)) {
      throw new BoardException(
        "Posição NÃO EXISTE tabuleiro | Position NO board"
      );
    }
    return piece(position) != null;
  }

  //!-------------------->>>    Removendo peças    <<<---------------------

  public Chess_Piece removePiece(Position position) {
    if (!positionExists(position)) {
      throw new BoardException(
        "Posição NÃO EXISTE tabuleiro | Position NO board"
      );
    }
    if (piece(position) == null) {
      return null;
    }
    Chess_Piece aux = piece(position);
    aux.position = null;
    pieces[position.getRow()][position.getColumn()] = null;
    return aux;
  }
}
