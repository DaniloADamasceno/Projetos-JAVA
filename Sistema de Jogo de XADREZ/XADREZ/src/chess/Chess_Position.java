package chess;

public class Chess_Position {

    private char column;
    private char row;

    //--------------------------
    //        CONSTRUCTOR
    //--------------------------

    public Chess_Position(char column, char row) {
        this.column = column;
        this.row = row;
    }

    //--------------------------
    //    GETTERS & SETTERS
    //--------------------------

    public char getColumn() {
        return column;
    }

    public void setColumn(char column) {
        this.column = column;
    }

    public char getRow() {
        return row;
    }

    public void setRow(char row) {
        this.row = row;
    }

}
