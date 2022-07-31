package chessPieces;

import boardGame.Board;
import chess.Chess_Piece;
import chess.Color;

public class Pawn extends Chess_Piece{ // Classe Peão

//------------------------
//      Constructor
//------------------------

public Pawn(Board board, Color color) {
    super(board, color);
}
    @Override
    public String toString() {
        return "Pw";
    }
}