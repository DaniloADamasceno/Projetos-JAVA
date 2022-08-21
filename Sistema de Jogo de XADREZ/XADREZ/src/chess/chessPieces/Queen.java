package chess.chessPieces;

import boardGame.Board;
import chess.ChessPiece;
import chess.Color;

public class Queen extends ChessPiece{    // Classe Rainha
    
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
