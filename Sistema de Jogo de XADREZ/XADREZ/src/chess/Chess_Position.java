package chess;

import boardGame.Position;

public class Chess_Position {

    private char column;
    private char row;

    //--------------------------
    //        CONSTRUCTOR
    //--------------------------

    public Chess_Position(char column, char row) {
        if(column < 'a' || column > 'h' || row < '1' || row > '8') {
            throw new Chess_Exception("ERROR: Invalid Chess Position. Valid values are from A1 to H8");
        }
        this.column = column;
        this.row = row;
    }

    //--------------------------
    //    GETTERS & SETTERS
    //--------------------------

    public char getColumn() {
        return column;
    }


    public char getRow() {
        return row;
    }

    //--------------------------
    //    METHODS
    //--------------------------

    protected Position toPosition() {
        return new Position(8 - row, column - 'a');
    }

protect 

}

