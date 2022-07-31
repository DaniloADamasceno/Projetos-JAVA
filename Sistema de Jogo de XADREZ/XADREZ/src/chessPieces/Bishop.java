package chessPieces;

import boardGame.Board;
import chess.Chess_Piece;
import chess.Color;

public class Bishop extends Chess_Piece {  // Classe Bispo

    //------------------------
    //      Constructor
    //------------------------
    public Bishop(Board board, Color color) {
        super(board, color);

    } 
    
    @Override
    public String toString() {
        return "Bi";
    }

    
}