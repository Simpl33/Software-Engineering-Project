// class that represents one move on the checkerboard
//note: this class does not validate if a move is legal

public class Move {

    // stores the row where the piece starts
    private int startRow;

    // stores the column where the piece starts
    private int startCol;

    // stores the row where the piece is moving to
    private int endRow;

    // stores the column where the piece is moving to
    private int endCol;

    // constructor that creates a move using a starting position and ending position
    public Move(int startRow, int startCol, int endRow, int endCol) {
        this.startRow = startRow;
        this.startCol = startCol;
        this.endRow = endRow;
        this.endCol = endCol;
    }

    // returns the starting row of the move
    public int getStartRow() {
        return startRow;
    }

    // returns the starting column of the move
    public int getStartCol() {
        return startCol;
    }

    // returns the ending row of the move
    public int getEndRow() {
        return endRow;
    }

    // returns the ending column of the move
    public int getEndCol() {
        return endCol;
    }
}