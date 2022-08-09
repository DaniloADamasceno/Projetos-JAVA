package chess;

import boardGame.Board;
import boardGame.Piece;
import boardGame.Position;

public abstract class Chess_Piece extends Piece {
    
    private Color color;

    //-------------------
    //!    Constructor
    //-------------------
    public Chess_Piece(Board board, Color color) {
        super(board);
        this.color = color;
    }
    //-------------------------
    //!    Getters and Setters
    //-------------------------
    public Color getColor() {
        return color;
    }
    //-------------------
    //!    Methods
    //-------------------
    //!--------------->>>     Pegar peça do oponente     <<<-----------------
    protected boolean IsThereOpponentPiece(Position position) {
        Chess_Piece p = (Chess_Piece) getBoard().piece(position);
        return p != null && p.getColor() != color;
    }
    
}
