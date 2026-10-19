// class that represents the checkerboard and keeps track of where the pieces are
public class CheckersBoard {

    // 2D array that stores Piece objects in rows and columns
    private Piece[][] board;

    // constructor that creates an 8 by 8 board and sets up the starting pieces
    public CheckersBoard() {
        board = new Piece[8][8];
        initializeBoard();
    }

    // places the black and red pieces in their starting positions
    private void initializeBoard() {

        // loops through the first 3 rows for the black pieces
        for (int row = 0; row < 3; row++) {

            
            for (int col = 0; col < 8; col++) {

                // only places a piece on the alternating playable squares
                if ((row + col) % 2 == 1) {

                    board[row][col] = new Piece("black");
                }
            }
        }

        // loops through the last 3 rows for the red pieces
        for (int row = 5; row < 8; row++) {

            
            for (int col = 0; col < 8; col++) {

                // only places a piece on the alternating playable squares
                if ((row + col) % 2 == 1) {

                    
                    board[row][col] = new Piece("red");
                }
            }
        }
    }

    // returns the piece that is stored at a certain row and column
    public Piece getPiece(int row, int col) {
        return board[row][col];
    }

    // moves a piece from its starting position to its ending position
    // returns false if there is no piece in the starting position
    public boolean movePiece(int startRow, int startCol, int endRow, int endCol) {

        // checks if the starting square is empty
        if (board[startRow][startCol] == null) {
            return false;
        }

        // puts the piece from the starting square into the ending square
        board[endRow][endCol] = board[startRow][startCol];

        // makes the old starting square empty
        board[startRow][startCol] = null;

        // returns true because the piece was moved
        return true;
    }

    // removes a piece from the board by making that position empty
    public void removePiece(int row, int col) {
        board[row][col] = null;
    }
}