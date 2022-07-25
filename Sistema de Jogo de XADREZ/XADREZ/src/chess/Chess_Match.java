package chess;

import boardGame.Board;

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

}