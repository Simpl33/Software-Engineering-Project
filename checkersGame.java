private class CheckersGame{

    private CheckersBoard board;
    private MoveValidator validator;
    private String currentPlayer;
    private boolean gameOver;
    private String winner;

    public CheckersGame() {
        board = new CheckersBoard();
        validator = new MoveValidator();
        
        currentPlayer = "black";
        gameOver = false;
        winner = null;
    }

    public boolean makeMove(Move move) {
        //do not allow moves after the game is over
        if (gameOver) {
            return false;
        }

        //check if the move follows the rules

        if (!validator.isValidMove(move, board)) {
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

        //if it is a capture, remove the piece
        if (capture) {
            int middleRow = (startRow + endRow) /2;
            int middleCol = (startCol + endCol) /2;
            board.removePiece(middleRow, middleCol);
        }

        //move the piece
        board.movePiece(startRow, startCol, endRow, endCol);

        //check if the piece should be kinged
        checkKing(piece, endRow);

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

        public boolean isGameOver(){
            return gameOver;
        }

        public String getWinner(){
            return winner;
        }

        public CheckersBoard getBoard(){
            return board;
        }
        
    }
