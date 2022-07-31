package chessPieces;

import boardGame.Board;
import chess.Chess_Piece;
import chess.Color;

public class Queen extends Chess_Piece{    // Classe Rainha
    
    //------------------------
    //      Constructor
    //------------------------
    public Queen(Board board, Color color) {
        super(board, color);
       
        
    } 

    @Override
    public String toString() {
        return "Q";
    }
    
}