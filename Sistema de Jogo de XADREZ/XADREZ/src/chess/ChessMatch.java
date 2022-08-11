package chess;

import boardGame.Board;
import boardGame.Chess_Piece;
import boardGame.Piece;
import boardGame.Position;
import chessPieces.Bishop;
import chessPieces.King;
import chessPieces.Knight;
import chessPieces.Queen;
import chessPieces.Rook;
import java.util.ArrayList;
import java.util.List;

//import chessPieces.Pawn;

public class ChessMatch {

  private int turn;
  private Color currentPlayer;
  private Board board;
  private List<Piece> piecesOnTheBoard = new ArrayList<>();
  private List<Piece> capturedPieces = new ArrayList<>();
  private boolean check;
  private boolean checkMate;
  private static Chess_Piece capturedPiece;
  private Position position;

  //-------------------
  //!    Constructor
  //-------------------

  public ChessMatch() {
    board = new Board(8, 8);
    turn = 1;
    currentPlayer = Color.WHITE;

    initialSetup(); // Inicializa o tabuleiro com as peças
  }

  public Chess_Piece[][] getPieces() {
    Chess_Piece[][] match_pieces = new Chess_Piece[board.getRows()][board.getColumns()];
    for (int i = 0; i < board.getRows(); i++) {
      for (int j = 0; j < board.getColumns(); j++) {
        match_pieces[i][j] = (Chess_Piece) board.piece(i, j);
      }
    }
    return match_pieces;
  }

  //---------------------
  //!   GETTERS & SETTERS
  //---------------------
  public int getTurn() {
    return turn;
  }

  public Color getCurrentPlayer() {
    return currentPlayer;
  }

  public boolean getCheck() {
    return check;
  }

  public boolean getCheckMate() {
    return checkMate;
  }

  // public ChessPiece getEnPassantVulnerable() {
  // 	return enPassantVulnerable;
  // }

  // public ChessPiece getPromoted() {
  // 	return promoted;
  // }

  //-----------------
  //!   METHODS
  //-----------------
  public boolean[][] possibleMoves(Chess_Position sourcePosition) {
    Position position = sourcePosition.toPosition();
    validateSourcePosition(position);
    return board.piece(position).possibleMoves();
  }

  public Chess_Piece performChessMove(
    Chess_Position sourcePosition,
    Chess_Position targetPosition
  ) {
    Position source = sourcePosition.toPosition();
    Position target = targetPosition.toPosition();
    validateSourcePosition(source); // REMOVER O TARGET
    validateTargetPosition(source, target);
    Chess_Piece capturedPiece = makeMove(source, target);
    nextTurn();
    return (Chess_Piece) capturedPiece;
  }

  private Chess_Piece makeMove(Position source, Position target) {
    Chess_Piece p = board.removePiece(source);
    Chess_Piece capturedPiece = board.removePiece(target);
    board.placePiece(p, target);
    if (capturedPiece != null) {
      piecesOnTheBoard.remove(capturedPiece);
      capturedPieces.add((Piece) capturedPiece);
    }
    return capturedPiece;
  }

  private void validateSourcePosition(Position source) {
    if (!board.thereIsAPiece(source)) {
      throw new Chess_Exception(
        "Não existe peça na posição de origem | There is no piece in source position"
      );
    }
    if (currentPlayer != ((Piece) board.piece(position)).getColor()) {
      throw new Chess_Exception(
        "A peça de origem não é sua | The piece of source position is not yours"
      );
    }
    if (!board.piece(position).isThereAnyPossibleMove()) {
      throw new Chess_Exception(
        "Não há movimentos possíveis para a peça escolhida | There is no possible moves for the chosen piece"
      );
    }
  }

  private void validateTargetPosition(Position source, Position target) {
    if (!board.piece(source).possibleMoves(target)) {
      throw new Chess_Exception(
        "A peça não pode se mover para a posição de destino | The piece can not move to the target position"
      );
    }
  }

  private void nextTurn() {
    turn++;
    currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;
  }

  private void placeNewPiece(char column, int row, Piece piece) {
    board.placePiece(piece, new Chess_Position(column, row).toPosition());
    piecesOnTheBoard.add(piece);
  }

  private void initialSetup() {
    //!--------------->>>     ROOKS / TORRES ( Brancas e Pretas )     <<<-----------------
    placeNewPiece('a', 1, new Rook(board, Color.WHITE)); // Torre branca #01
    placeNewPiece('h', 1, new Rook(board, Color.WHITE)); // Torre branca #02

    placeNewPiece('h', 8, new Rook(board, Color.BLACK)); // Torre preta #01
    placeNewPiece('a', 8, new Rook(board, Color.BLACK)); // Torre preta #02

    //!--------------->>>     KNIGHTS / CAVALO ( Brancas e Pretas )     <<<-----------------
    placeNewPiece('b', 1, new Knight(board, Color.WHITE)); // Cavaleiro branco #01
    placeNewPiece('g', 1, new Knight(board, Color.WHITE)); // Cavaleiro branco #02

    placeNewPiece('g', 8, new Knight(board, Color.BLACK)); // Cavaleiro preta #01
    placeNewPiece('b', 8, new Knight(board, Color.BLACK)); // Cavaleiro preta #02

    //!--------------->>>    BISHOPS / BISPO ( Brancas e Pretas )     <<<-----------------
    placeNewPiece('c', 1, new Bishop(board, Color.WHITE)); // Bispo branco #01
    placeNewPiece('f', 1, new Bishop(board, Color.WHITE)); // Bispo branco #02

    placeNewPiece('f', 8, new Bishop(board, Color.BLACK)); // Bispo preta #01
    placeNewPiece('c', 8, new Bishop(board, Color.BLACK)); // Bispo preta #02

    //!--------------->>>    QUEENS / RAINHA ( Brancas e Pretas )     <<<-----------------
    placeNewPiece('d', 1, new Queen(board, Color.WHITE)); // Rainha branca #01
    placeNewPiece('d', 8, new Queen(board, Color.BLACK)); // Rainha preta #01

    //!--------------->>>    KINGS / REI ( Brancas e Pretas )     <<<-----------------
    placeNewPiece('e', 1, new King(board, Color.WHITE)); // Rei branco #01
    placeNewPiece('e', 8, new King(board, Color.BLACK)); // Rei preta #01
    //!--------------->>>       PAWNS / PEÕES ( Brancas e Pretas )     <<<-----------------
    // for (int i = 0; i < 8; i++) {
    //   placeNewPiece('a', 2 + i, new Pawn(board, Color.WHITE)); // Peões brancos #01
    //   placeNewPiece('h', 2 + i, new Pawn(board, Color.BLACK)); // Peões pretos #01
    // }

  }
}
