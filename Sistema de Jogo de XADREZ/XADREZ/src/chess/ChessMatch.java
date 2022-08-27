package chess;

import boardGame.Board;
import boardGame.Piece;
import boardGame.Position;
import chess.chessPieces.Bishop;
import chess.chessPieces.King;
import chess.chessPieces.Knight;
import chess.chessPieces.Pawn;
import chess.chessPieces.Queen;
import chess.chessPieces.Rook;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ChessMatch {

  private int turn;
  private Color currentPlayer;
  private Board board;
  private boolean check;
  private boolean checkMate;
  private ChessPiece enPassantVulnerable;
  private ChessPiece promoted;

  private List<Piece> piecesOnTheBoard = new ArrayList<>();
  private List<Piece> capturedPieces = new ArrayList<>();

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

  public ChessPiece getEnPassantVulnerable() {
    return enPassantVulnerable;
  }

  public ChessPiece getPromoted() {
  	return promoted;
  }
  
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

    //!--------------->>>     Teste se o movimento foi feito para colocar em Xeque o Próprio Jogador     <<<-----------------
    if (testCheck(currentPlayer)) {
      undoMove(source, target, capturedPiece);
      throw new Chess_Exception(
          "Você não pode se colocar em cheque | You can't put yourself in check");
    }
    //!--------------->>>     Teste se o Oponente esta em Xeque     <<<-----------------
    ChessPiece movedPiece = (ChessPiece) board.piece(target); // Pega a peça que foi movida

    //!--------------->>>     Jogada Especial Promoção     <<<-----------------
    promoted = null;
    if (movedPiece instanceof Pawn) {
      if ((movedPiece.getColor() == Color.WHITE && target.getRow() == 0)
          || (movedPiece.getColor() == Color.BLACK && target.getRow() == 7)) {
        promoted = (ChessPiece) board.piece(target);
        promoted = replacePromotedPiece("Q");
      }
    }

    check = testCheck(opponent(currentPlayer)) ? true : false; //// Se o oponente estiver em cheque, check = true

    //!--------------->>>     Teste se o Oponente esta em Xeque MATE     <<<-----------------
    if (testCheckMate(opponent(currentPlayer))) {
      checkMate = true;
    } else {
      nextTurn();
    }

    //!--------------->>>     Movimento Especial En Passant     <<<-----------------
    if (movedPiece instanceof Pawn &&
        (target.getRow() == source.getRow() - 2 ||
            target.getRow() == source.getRow() + 2)) {
      enPassantVulnerable = movedPiece;
    } else {
      enPassantVulnerable = null;
    }

    return (ChessPiece) capturedPiece;
  }
  //!--------------->>>     Trocar a peça promovida     <<<-----------------
  public ChessPiece replacePromotedPiece(String type) {
    if (promoted == null) {
      throw new IllegalStateException("Não há peça para ser promovida | There is no piece to be promoted");
    }
    if (!type.equals("B") && !type.equals("C") && !type.equals("T") && !type.equals("Q")) {
      return promoted;
    }

    Position pos = promoted.getChessPosition().toPosition();
    Piece p = board.removePiece(pos);
    piecesOnTheBoard.remove(p);

    ChessPiece newPiece = newPiece(type, promoted.getColor());
    board.placePiece(newPiece, pos);
    piecesOnTheBoard.add(newPiece);

    return newPiece;
  }
  //!--------------->>>     Criar uma nova peça (Método auxiliar)    <<<-----------------
  protected ChessPiece newPiece(String type, Color color) {
    if (type.equals("B")) return new Bishop(board, color);
    if (type.equals("C")) return new Knight(board, color);
    if (type.equals("T")) return new Rook(board, color);
    return new Queen(board, color);
  }

  private Piece makeMove(Position source, Position target) {
    ChessPiece p = (ChessPiece) board.removePiece(source);
    p.increaseMoveCount();
    Piece capturedPiece = board.removePiece(target);
    board.placePiece(p, target);
    if (capturedPiece != null) {
      piecesOnTheBoard.remove(capturedPiece);
      capturedPieces.add((Piece) capturedPiece);
    }

    //!--------------->>>     Movimento Especial de Rook Lado do Rei    <<<-----------------
    if (p instanceof King && target.getColumn() == source.getColumn() + 2) {
      Position sourceT = new Position(source.getRow(), source.getColumn() + 3);
      Position targetT = new Position(source.getRow(), source.getColumn() + 1);
      ChessPiece rook = (ChessPiece) board.removePiece(sourceT);
      board.placePiece(rook, targetT);
      rook.increaseMoveCount();
    }

    //!--------------->>>     Movimento Especial de Rook Lado da Rainha    <<<-----------------
    if (p instanceof King && target.getColumn() == source.getColumn() - 2) {
      Position sourceT = new Position(source.getRow(), source.getColumn() - 4);
      Position targetT = new Position(source.getRow(), source.getColumn() - 1);
      ChessPiece rook = (ChessPiece) board.removePiece(sourceT);
      board.placePiece(rook, targetT);
      rook.increaseMoveCount();
    }

    //!--------------->>>     Movimento Especial En Passant (REALIZAR)   <<<-----------------
    if (p instanceof Pawn) {
      if (source.getColumn() != target.getColumn() && capturedPiece == null) {
        Position pawnPosition;
        if (p.getColor() == Color.WHITE) {
          pawnPosition = new Position(target.getRow() + 1, target.getColumn());
        } else {
          pawnPosition = new Position(target.getRow() - 1, target.getColumn());
        }
        capturedPiece = board.removePiece(pawnPosition);
        capturedPieces.add(capturedPiece);
        piecesOnTheBoard.remove(capturedPiece);
      }
    }

    return capturedPiece;
  }

  //!--------------->>>     Testar o Check Mate     <<<-----------------
  private boolean testCheckMate(Color color) {
    if (!testCheck(color)) {
      return false;
    }
    List<Piece> list = piecesOnTheBoard
      .stream()
      .filter(x -> ((ChessPiece) x).getColor() == color)
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
    ChessPiece p = (ChessPiece) board.removePiece(target);
    p.decreaseMoveCount();
    board.placePiece(p, source);

    if (capturedPiece != null) {
      board.placePiece(capturedPiece, target);
      capturedPieces.remove(capturedPiece);
      piecesOnTheBoard.add(capturedPiece);
    }

    //!--------------->>>     Movimento Especial de Rook Lado do Rei    <<<-----------------
    if (p instanceof King && target.getColumn() == source.getColumn() + 2) {
      Position sourceT = new Position(source.getRow(), source.getColumn() + 3);
      Position targetT = new Position(source.getRow(), source.getColumn() + 1);
      ChessPiece rook = (ChessPiece) board.removePiece(targetT);
      board.placePiece(rook, sourceT);
      rook.decreaseMoveCount();
    }

    //!--------------->>>     Movimento Especial de Rook Lado da Rainha    <<<-----------------
    if (p instanceof King && target.getColumn() == source.getColumn() - 2) {
      Position sourceT = new Position(source.getRow(), source.getColumn() - 4);
      Position targetT = new Position(source.getRow(), source.getColumn() - 1);
      ChessPiece rook = (ChessPiece) board.removePiece(targetT);
      board.placePiece(rook, sourceT);
      rook.decreaseMoveCount();
    }
    //!--------------->>>     Movimento Especial En Passant (DESFAZER)   <<<-----------------
    if (p instanceof Pawn) {
      if (
        source.getColumn() != target.getColumn() &&
        capturedPiece == enPassantVulnerable
      ) {
        ChessPiece pawn = (ChessPiece) board.removePiece(target);
        Position pawnPosition;
        if (p.getColor() == Color.WHITE) {
          pawnPosition = new Position(3, target.getColumn());
        } else {
          pawnPosition = new Position(4, target.getColumn());
        }
        board.placePiece(pawn, pawnPosition);
      }
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
    if (!board.piece(position).isThereAnyPossibleMove(position)) {
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
    List<Piece> list = piecesOnTheBoard
      .stream()
      .filter(x -> ((ChessPiece) x).getColor() == color)
      .collect(Collectors.toList());
    for (Piece p : list) {
      if (p instanceof King) {
        return (ChessPiece) p;
      }
    }
    throw new IllegalAccessError(
      "Não tem rei da cor " +
      color +
      " no tabuleiro | There is no king of " +
      color +
      " in the board"
    );
  }

  //!--------------->>>     Verificar se o REI está em Xeque     <<<-----------------

  private boolean testCheck(Color color) {
    Position kingPosition = king(color).getChessPosition().toPosition();
    List<Piece> opponentPieces = piecesOnTheBoard
      .stream()
      .filter(x -> ((ChessPiece) x).getColor() == opponent(color))
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
    placeNewPiece('a', 1, new Rook(board, Color.WHITE)); // Torre branca #01 (a1)
    placeNewPiece('h', 1, new Rook(board, Color.WHITE)); // Torre branca #02 (h1)

    placeNewPiece('h', 8, new Rook(board, Color.BLACK)); // Torre preta #01 (h8)
    placeNewPiece('a', 8, new Rook(board, Color.BLACK)); // Torre preta #02 (a8)

    //!--------------->>>     KNIGHTS / CAVALO ( Brancas e Pretas )     <<<-----------------
    placeNewPiece('b', 1, new Knight(board, Color.WHITE)); // Cavaleiro branco #01 (b1)
    placeNewPiece('g', 1, new Knight(board, Color.WHITE)); // Cavaleiro branco #02 (g1)

    placeNewPiece('g', 8, new Knight(board, Color.BLACK)); // Cavaleiro preta #01 (g8)
    placeNewPiece('b', 8, new Knight(board, Color.BLACK)); // Cavaleiro preta #02 (b8)

    //!--------------->>>    BISHOPS / BISPO ( Brancas e Pretas )     <<<-----------------
    placeNewPiece('c', 1, new Bishop(board, Color.WHITE)); // Bispo branco #01 (c1)
    placeNewPiece('f', 1, new Bishop(board, Color.WHITE)); // Bispo branco #02 (f1)

    placeNewPiece('f', 8, new Bishop(board, Color.BLACK)); // Bispo preta #01 (f8)
    placeNewPiece('c', 8, new Bishop(board, Color.BLACK)); // Bispo preta #02 (c8)

    //!--------------->>>    QUEENS / RAINHA ( Brancas e Pretas )     <<<-----------------
    placeNewPiece('d', 1, new Queen(board, Color.WHITE)); // Rainha branca #01 (d1)
    placeNewPiece('d', 8, new Queen(board, Color.BLACK)); // Rainha preta #01 (d8)

    //!--------------->>>    KINGS / REI ( Brancas e Pretas )     <<<-----------------
    placeNewPiece('e', 1, new King(board, Color.WHITE, this)); // Rei branco #01 (e1)
    placeNewPiece('e', 8, new King(board, Color.BLACK, this)); // Rei preta #01 (e8)

    //!--------------->>>       PAWNS / PEÕES ( Brancas)     <<<-----------------

    placeNewPiece('a', 2, new Pawn(board, Color.WHITE, this)); // Peões brancos #01
    placeNewPiece('b', 2, new Pawn(board, Color.WHITE, this)); // Peões brancos #02
    placeNewPiece('c', 2, new Pawn(board, Color.WHITE, this)); // Peões brancos #03
    placeNewPiece('d', 2, new Pawn(board, Color.WHITE, this)); // Peões brancos #04
    placeNewPiece('e', 2, new Pawn(board, Color.WHITE, this)); // Peões brancos #05
    placeNewPiece('f', 2, new Pawn(board, Color.WHITE, this)); // Peões brancos #06
    placeNewPiece('g', 2, new Pawn(board, Color.WHITE, this)); // Peões brancos #07
    placeNewPiece('h', 2, new Pawn(board, Color.WHITE, this)); // Peões brancos #08

    //!--------------->>>       PAWNS / PEÕES (Pretas )     <<<-----------------
    placeNewPiece('a', 7, new Pawn(board, Color.BLACK, this)); // Peões pretos #01
    placeNewPiece('b', 7, new Pawn(board, Color.BLACK, this)); // Peões pretos #02
    placeNewPiece('c', 7, new Pawn(board, Color.BLACK, this)); // Peões pretos #03
    placeNewPiece('d', 7, new Pawn(board, Color.BLACK, this)); // Peões pretos #04
    placeNewPiece('e', 7, new Pawn(board, Color.BLACK, this)); // Peões pretos #05
    placeNewPiece('f', 7, new Pawn(board, Color.BLACK, this)); // Peões pretos #06
    placeNewPiece('g', 7, new Pawn(board, Color.BLACK, this)); // Peões pretos #07
    placeNewPiece('h', 7, new Pawn(board, Color.BLACK, this)); // Peões pretos #08
  }
}
