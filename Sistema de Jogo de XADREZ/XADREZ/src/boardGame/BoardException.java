package boardGame;

public class BoardException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    //------------------
    //    Constructor
    //------------------
    public BoardException(String msg) {
        super(msg);
    }
}