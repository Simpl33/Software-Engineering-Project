public class CheckersGame {

    private CheckersBoard board;
    private moveValidator validator;
    private String currentPlayer;
    private boolean firstClick;
    private boolean gameOver;
    private String winner;
    private int startRow;
    private int startCol;

    public CheckersGame() {
        board = new CheckersBoard();
        validator = new moveValidator();
        
        currentPlayer = "black";
        firstClick = true;
        gameOver = false;
        winner = null;
        startRow = 0;
        startCol = 0;
    }

    public boolean makeMove(Move move) {
        //do not allow moves after the game is over
        if (gameOver) {
            return false;
        }

        //check if the move follows the rules

        if (!validator.isValidMove(move, board, currentPlayer)) {
            System.out.println("Fail!");
            return false;
        }

        int startRow = move.getStartRow();
        int startCol = move.getStartCol();
        int endRow = move.getEndRow();
        int endCol = move.getEndCol();


        //save the piece that is being moved
        Piece piece = board.getPiece(startRow, startCol);

        //check if the new move is a capture
        boolean capture = validator.isCaptureMove(move, piece, board);

        //move the piece
        System.out.println("Success!");
        board.movePiece(startRow, startCol, endRow, endCol);

        //if it is a capture, remove the piece
        if (capture) {
            int middleRow = (startRow + endRow) /2;
            int middleCol = (startCol + endCol) /2;
            board.removePiece(middleRow, middleCol);

            // Checks to see if the current player can capture multiple pieces
            if(validator.hasCaptureAvailable(board.getPiece(endRow, endCol), endRow, endCol, board)){
                return true;
            }
        }
        

        //check if the piece should be kinged
        checkForKing(piece, endRow);

        //check if someone won
        checkWin();

        //switch players only if the game is still running
        if (!gameOver) {
            switchTurn();
        }
    return true;
    }

    public void switchTurn() {
        if (currentPlayer.equals("black")) {
            currentPlayer = "red";
        } else {
            currentPlayer = "black";
        }
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }

    public void checkForKing(Piece piece, int row) {

        if (piece.getColor().equals("black") && row ==7) {
            piece.setKing(true);
        } else if (piece.getColor().equals("red") && row == 0) {
            piece.setKing(true);
        }
    }

    public void checkWin(){
        int redPieces = 0;
        int blackPieces = 0;

        for (int row = 0; row < 8; row++){
            for (int col = 0; col < 8; col++){
                Piece piece = board.getPiece(row, col);
                if (piece != null){
                    if (piece.getColor().equals("red")){
                        redPieces++;
                    }else if (piece.getColor().equals("black")){
                        blackPieces++;
                    }
                }
            }
        }
        if (redPieces == 0){
            gameOver = true;
            winner = "black";
        }

        if (blackPieces == 0){
            gameOver = true;
            winner = "red";
        }

       
        
    }

    public boolean isGameOver(){
        return gameOver;
    }

    public String getWinner(){
        return winner;
    }

    public CheckersBoard getBoard(){
        return board;
    }

    
    public void handlePieceClicked(Tile tile){
        if (firstClick){
            startRow = tile.getRow();
            startCol = tile.getCol();
            firstClick = false;
        } else {
            Move move = new Move(startRow, startCol, tile.getRow(), tile.getCol());
            System.out.println(tile.getRow() + ", " + tile.getCol() );
            this.makeMove(move);
            firstClick = true;
        }
    }
}
