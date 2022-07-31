package chess;

import boardGame.Board;
import boardGame.Position;
import chessPieces.King;
import chessPieces.Rook;

public class Chess_Match  {
    
    private Board board;
    private int turn;
    private Color currentPlayer;
    private boolean check;
    private boolean checkMate;

    //-------------------
    //    Constructor
    //-------------------

    public Chess_Match() {
        board = new Board(8, 8);
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

    private void initialSetup() {
        board.placePiece(new Rook(board, Color.WHITE), new Position(2, 1));
        board.placePiece(new Rook(board, Color.BLACK), new Position(4, 3));

        board.placePiece(new King(board, Color.WHITE), new Position(7, 6));
        board.placePiece(new King(board, Color.BLACK), new Position(6, 0));


    }
}