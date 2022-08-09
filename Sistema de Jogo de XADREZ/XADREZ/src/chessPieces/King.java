package chessPieces;

import boardGame.Board;
import chess.Chess_Piece;
import chess.Color;

public class King extends Chess_Piece { // Classe Rei

//------------------------
//!      Constructor
//------------------------
    public King(Board board, Color color) {
        super(board, color);
    } 
    
    @Override
    public String toString() {
        return "K";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        return null;
    }
}
