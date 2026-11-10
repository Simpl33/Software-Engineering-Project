public class moveValidator{

    public moveValidator(){
    }

    public boolean isValidMove(Move move, CheckersBoard board, String curentPlayer){

        int startRow = move.getStartRow();
        int startCol = move.getStartCol();
        int endRow = move.getEndRow();
        int endCol = move.getEndCol();

        //making sure the locations are on the board
        if (!board.isInsideBoard(startRow, startCol) || !board.isInsideBoard(endRow, endCol)){
            System.out.println("Outside board");
            return false;
        } 

        //checks to see if a piece is at the starting location
        Piece piece = board.getPiece(startRow, startCol);

        if (piece == null){
            System.out.println("no piece");
            return false;
        }

        //checks to see if the piece belongs to the current player
        if (!piece.getColor().equals(curentPlayer)){
            System.out.println("Wrong player");
            return false;
        }

        //checks to see if the ending square is empty
        if (board.getPiece(endRow, endCol) != null){
            System.out.println("Space filled");
            return false;
        }

        //check capture move 
        if (isCaptureMove(move, piece, board)){
            return true;
        }
        //check if normal one square move is valid
        if (isSimpleMove(move, piece, board, curentPlayer)){
            return true;
        }

        return false;
    }

    public boolean isSimpleMove(Move move, Piece piece, CheckersBoard board, String currentPlayer){
        int rowChange = move.getStartRow() - move.getEndRow();
        int colChange = move.getEndCol() - move.getStartCol();

        // Checks if their is a capture avaliable for the current player
        if(anyCaptureAvailable(currentPlayer, board)){
            return false;
        }

        //move must only be exactly one column diagonally
        if (Math.abs(colChange) != 1){
            System.out.println("ColChange error");
            return false;
        }

        //Kings can move in either direction
        if (piece.isKing()){
            return Math.abs(rowChange) ==1;
        }

        return isCorrectDirection(piece, rowChange);

    }

    public boolean isCaptureMove(Move move, Piece piece, CheckersBoard board){
        int rowChange = move.getStartRow() - move.getEndRow();
        int colChange = move.getEndCol() - move.getStartCol();

        //capture move moves exactly 2 rows and columns

        if(Math.abs(rowChange) != 2 || Math.abs(colChange) != 2){
            return false;
        }

        //regular pieces may only move in one direction

        if(!piece.isKing() && !isCorrectDirection(piece, rowChange)){
            return false;
        }

        //find the square that was jumped over
        int middleRow = (move.getEndRow() + move.getStartRow()) / 2;
        int middleCol = (move.getStartCol() + move.getEndCol()) / 2;

        Piece jumpedPiece = board.getPiece(middleRow, middleCol);

        //there needs to be a piece to capture
        if (jumpedPiece == null){
            return false;
        }

        //You can not capture a piece that is yours
        if (jumpedPiece.getColor().equals(piece.getColor())){
            return false;
        }



        return true;
    }
    
    public boolean isCorrectDirection(Piece piece, int rowChange){
        if (piece.getColor().equals("red")){
            return rowChange > 0;
        }
        if (piece.getColor().equals("black")){
            System.out.println("Test");
            return rowChange < 0;
        }
        
        
        return false;

    }

    public boolean canKingMove(Piece piece){
        return piece.isKing();
    }

    public boolean anyCaptureAvailable(String currentPlayer, CheckersBoard board){
        for(int row = 0; row < 8; row++){
            for(int col = 0; col < 8; col++){
                if (board.getPiece(row, col) != null){
                    if(board.getPiece(row, col).getColor().equals(currentPlayer)){
                        if(hasCaptureAvailable(board.getPiece(row, col), row, col, board)){
                        return true;
                        }
                    } else {
                    continue;
                    }
                }
            }
        }
        return false;
    }

    public boolean hasCaptureAvailable(Piece piece, int row, int col, CheckersBoard board){

        int[][] directions = {
            {-2,-2}, {-2,2}, {2,-2}, {2,2}
        };

        for (int[] direction : directions){

            int endRow = row + direction[0];
            int endCol = col + direction[1];

            if (!board.isInsideBoard(endRow, endCol)){
                continue;
            }

            //landing square needs to be empty

            if (board.getPiece(endRow, endCol) != null){
                continue;
            }

            Move possibleMove = new Move(row, col, endRow, endCol);

            if(isCaptureMove(possibleMove, piece, board)){
                return true;
            }
        }

        return false;

    }

}