package chess;

import boardGame.Board;
import boardGame.Piece;

public class Chess_Piece extends Piece {
    
    private Color color;

    //-------------------
    //    Constructor
    //-------------------
    public Chess_Piece(Board board, Color color) {
        super(board);
        this.color = color;
    }
    //-------------------
    //Getters and Setters
    //-------------------
    public Color getColor() {
        return color;
    }
    //-------------------
    //    Methods
    //-------------------
    
}