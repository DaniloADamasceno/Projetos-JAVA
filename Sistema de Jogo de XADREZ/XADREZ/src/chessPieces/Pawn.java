package chessPieces;

import boardGame.Board;
import boardGame.Piece;
import chess.Color;

public class Pawn extends Piece{ // Classe Peão

//------------------------
//!      Constructor
//------------------------

public Pawn(Board board, Color color) {
    super(board, color);
}
    @Override
    public String toString() {
        return "P";
    }
    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        return mat;
    }
}
