package chess.chessPieces;

import boardGame.Board;
import chess.ChessPiece;
import chess.Color;

public class Knight extends ChessPiece{  // Classe Cavalo

    //------------------------
    //!      Constructor
    //------------------------
    public Knight(Board board, Color color) {
        super(board, color);
    } 
    @Override
    public String toString() {
        return "C";
    }
    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        return mat;
    }
    
}
