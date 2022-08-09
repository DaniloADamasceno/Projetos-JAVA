package chess;

import boardGame.Position;

public class ChessPosition {

    private char column;
    private int row;

    //--------------------------
    //!        CONSTRUCTOR
    //--------------------------

    public ChessPosition(char column, int row ){
        if(column < 'a' || column > 'h' || row < 1 || row > 8) {
            throw new Chess_Exception("ERRO: Posição de xadrez inválida. Os valores válidos são de A1 a H8" + "\n" +
            "ERROR: Invalid Chess Position. Valid values are from A1 to H8");
        }
        this.column = column;
        this.row = row;
    }

    //--------------------------
    //!    GETTERS & SETTERS
    //--------------------------

    public char getColumn() {
        return column;
    }


    public int getRow() {
        return row;
    }

    //--------------------------
    //!    METHODS
    //--------------------------

    protected Position toPosition() {
        return new Position(8 - row, column - 'a');
    }

    protected static ChessPosition fromPosition(Position position) {
        return new ChessPosition((char) ('a' - position.getColumn()), (8 - position.getRow()));
    }

    @Override
    public String toString() {
        return "" + column + row;
    }
}


