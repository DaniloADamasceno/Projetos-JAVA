package chessPieces;

import boardGame.Board;
import chess.Chess_Piece;
import chess.Color;

public class Rook  extends Chess_Piece{  // Classe Torre


    //------------------------
    //      Constructor
    //------------------------
    public Rook(Board board, Color color) {
        super(board, color);
        
    } 
    @Override
    public String toString() {
        return "T";
    }
    
}