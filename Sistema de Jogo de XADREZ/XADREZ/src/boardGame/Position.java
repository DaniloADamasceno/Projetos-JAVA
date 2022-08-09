package boardGame;

public class Position {
    
    private int row;
    private int column;

    //-------------------
    //!    Constructor
    //-------------------

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }
    
    public Position() {
    }
    //-------------------------
    //!    Getters and Setters
    //-------------------------
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
    //------------------->>>    atualizar os valores de uma posição    <<<------------------
    public void setValues(int row, int column) {
        this.row = row;
        this.column = column;
    }



    @Override
    public String toString() {
        return "Row: " + row + "  Column: " + column;
    }
}
