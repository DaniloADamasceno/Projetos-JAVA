package chessPieces;

import boardGame.Board;
import chess.Color;
import chess.Piece;

public class Queen extends Piece{    // Classe Rainha
    
    //------------------------
    //!      Constructor
    //------------------------
    public Queen(Board board, Color color) {
        super(board, color);
       
        
    } 

    @Override
    public String toString() {
        return "Q";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        return mat;
    }
    
}
