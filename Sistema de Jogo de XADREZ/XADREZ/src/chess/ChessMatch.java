package chess;

import boardGame.Board;
import boardGame.Piece;
import boardGame.Position;
import chess.chessPieces.Bishop;
import chess.chessPieces.King;
import chess.chessPieces.Knight;
import chess.chessPieces.Queen;
import chess.chessPieces.Rook;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//import chessPieces.Pawn;

public class ChessMatch {

  private int turn;
  private Color currentPlayer;
  private Board board;
  private List<Piece> piecesOnTheBoard = new ArrayList<>();
  private List<Piece> capturedPieces = new ArrayList<>();
  private boolean check;
  private boolean checkMate;
  //private static Piece capturedPiece;
  //private Position position;

  //-------------------
  //!    Constructor
  //-------------------

  public ChessMatch() {
    board = new Board(8, 8);
    turn = 1;
    currentPlayer = Color.WHITE;
    initialSetup(); // Inicializa o tabuleiro com as peças
  }

  public ChessPiece[][] getPieces() {
    ChessPiece[][] match_pieces = new ChessPiece[board.getRows()][board.getColumns()];
    for (int i = 0; i < board.getRows(); i++) {
      for (int j = 0; j < board.getColumns(); j++) {
        match_pieces[i][j] = (ChessPiece) board.piece(i, j);
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
//
  //-----------------
  //!   METHODS
  //-----------------
  public boolean[][] possibleMoves(ChessPosition sourcePosition) {
    Position position = sourcePosition.toPosition();
    validateSourcePosition(position);
    return board.piece(position).possibleMoves();
  }

  public ChessPiece performChessMove(
    ChessPosition sourcePosition,
    ChessPosition targetPosition
  ) {
    Position source = sourcePosition.toPosition();
    Position target = targetPosition.toPosition();
    validateSourcePosition(source);
    validateTargetPosition(source, target);
    Piece capturedPiece = makeMove(source, target);

    //!--------------->>>     Teste se o movimento foi feito para colocar em Xeque o Proprio Jogador     <<<-----------------
    if (testCheck(currentPlayer)) {
      undoMove(source, target, capturedPiece);
      throw new Chess_Exception("Você não pode se colocar em cheque | You can't put yourself in check");
    }
    //!--------------->>>     Teste se o Oponente esta em Xeque     <<<-----------------
    check = testCheck(opponent(currentPlayer)) ? true : false;
    //!--------------->>>     Teste se o Oponente esta em Xeque MATE     <<<-----------------
    if(testCheckMate(opponent(currentPlayer))) {
      checkMate = true;
    } else {
      nextTurn();
    }
    return (ChessPiece) capturedPiece;
  }

  private Piece makeMove(Position source, Position target) {
    Piece p = board.removePiece(source);
    Piece capturedPiece = board.removePiece(target);
    board.placePiece(p, target);
    if (capturedPiece != null) {
      piecesOnTheBoard.remove(capturedPiece);
      capturedPieces.add((Piece) capturedPiece);
    }
    return capturedPiece;
  }
  //!--------------->>>     Testar o Check Mate     <<<-----------------
  private boolean testCheckMate(Color color) {
    if (!testCheck(color)) {
      return false;
    }
    List<Piece> list = piecesOnTheBoard.stream().filter(x -> ((ChessPiece) x).getColor() == color)
        .collect(Collectors.toList());

    for (Piece p : list) {
      boolean[][] mat = p.possibleMoves();
      for (int i = 0; i < board.getRows(); i++) {
        for (int j = 0; j < board.getColumns(); j++) {
          if (mat[i][j]) {
            Position source = ((ChessPiece) p).getChessPosition().toPosition();
            Position target = new Position(i, j);
            Piece capturedPiece = makeMove(source, target);
            boolean testCheck = testCheck(color);
            undoMove(source, target, capturedPiece);
            if (!testCheck) {
              return false;
            }
          }
        }
      }
    }
    return true;
  }

  //!--------------->>>     Desfazer Movimento     <<<-----------------
  private void undoMove(Position source, Position target, Piece capturedPiece) {

    Piece p = board.removePiece(target);
    board.placePiece(p, source);

    if (capturedPiece != null) {
      board.placePiece(capturedPiece, target);
      capturedPieces.remove(capturedPiece);
      piecesOnTheBoard.add(capturedPiece);
    }

  }

  private void validateSourcePosition(Position position) {
    if (!board.thereIsAPiece(position)) {
      throw new Chess_Exception(
        "Não existe peça na posição de origem | There is no piece in source position"
      );
    }
    if (currentPlayer != ((ChessPiece) board.piece(position)).getColor()) {
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
    if (!board.piece(source).possibleMove(target)) {
      throw new Chess_Exception(
        "A peça não pode se mover para a posição de destino | The piece can not move to the target position"
      );
    }
  }

  private void nextTurn() {
    turn++;
    currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;
  }
  //!--------------->>>     Troca de oponente     <<<-----------------
    
  private Color opponent(Color color) {
    return (color == Color.WHITE) ? Color.BLACK : Color.WHITE;
  }
  //!--------------->>>     Localizar a cor do REI oponente     <<<-----------------

  private ChessPiece king(Color color) {

    List<Piece> list = piecesOnTheBoard.stream().filter(x -> ((ChessPiece) x).getColor() == color)
        .collect(Collectors.toList());
    for (Piece p : list) {
      if (p instanceof King) {
        return (ChessPiece) p;
      }
    }
    throw new IllegalAccessError(
        "Não tem rei da cor " + color + " no tabuleiro | There is no king of " + color + " in the board");
  }

  //!--------------->>>     Verificar se o REI está em Xeque     <<<-----------------

  private boolean testCheck(Color color) {
    Position kingPosition = king(color).getChessPosition().toPosition();
    List<Piece> opponentPieces = piecesOnTheBoard.stream().filter(x -> ((ChessPiece) x).getColor() == opponent(color))
        .collect(Collectors.toList());
    for (Piece p : opponentPieces) {
      boolean[][] mat = p.possibleMoves();
      if (mat[kingPosition.getRow()][kingPosition.getColumn()]) {
        return true;
      }
    }
    return false;
  }

  
  private void placeNewPiece(char column, int row, Piece piece) {
    board.placePiece(piece, new ChessPosition(column, row).toPosition());
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
