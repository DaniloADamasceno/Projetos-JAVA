package chessPieces;

import boardGame.Board;
import boardGame.Piece;
import chess.Color;

public class Bishop extends Piece {  // Classe Bispo

    //------------------------
    //!      Constructor
    //------------------------
    public Bishop(Board board, Color color) {
        super(board, color);

    } 
    
    @Override
    public String toString() {
        return "B";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        return mat;
    }

    
}
