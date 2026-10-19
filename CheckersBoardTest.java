import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CheckersBoardTest {

    // tests that the board is initialized with the correct number of black pieces
    @Test
    public void testInitialBlackPieceCount() {

        
        CheckersBoard board = new CheckersBoard();

       
        int blackCount = 0;

        // loops through all the squares on the board
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece piece = board.getPiece(row, col);

                if (piece != null && piece.getColor().equals("black")) {
                    blackCount++;
                }
            }
        }

        // asserts that there are 12 black pieces on the board
        assertEquals(12, blackCount);
    }

    // tests that the board is initialized with the correct number of red pieces
    @Test
    public void testInitialRedPieceCount() {

        
        CheckersBoard board = new CheckersBoard();

    
        int redCount = 0;

        // loops through all the squares on the board
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece piece = board.getPiece(row, col);

                if (piece != null && piece.getColor().equals("red")) {
                    redCount++;
                }
            }
        }

        // asserts that there are 12 red pieces on the board
        assertEquals(12, redCount);
    }

    // tests that the middle two rows of the board are empty
    @Test
    public void testMiddleRowsAreEmpty() {

        
        CheckersBoard board = new CheckersBoard();

        // loops through the middle rows of the board
        for (int row = 3; row < 5; row++) {
            for (int col = 0; col < 8; col++) {
                Piece piece = board.getPiece(row, col);

                // asserts that the middle rows are empty
                assertNull(piece);
            }
        }
    }

    // tests that pieces are only placed on playable squares
    @Test
    public void testPiecesOnlyOnPlayableSquares() {

        
        CheckersBoard board = new CheckersBoard();

        // loops through all the squares on the board
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {

                Piece piece = board.getPiece(row, col);

                // if the square is not playable, it should be empty
                if ((row + col) % 2 == 0) {
                    assertNull(piece);
                }
            }
        }
    }

    @Test
public void testMovePiece() {
    CheckersBoard board = new CheckersBoard();

    boolean result = board.movePiece(2, 1, 3, 0);

    assertTrue(result);
    assertNull(board.getPiece(2, 1));
    assertNotNull(board.getPiece(3, 0));
}

@Test
public void testMovePieceFromEmptySquare() {
    CheckersBoard board = new CheckersBoard();

    boolean result = board.movePiece(3, 0, 4, 1);

    assertFalse(result);
}

@Test
public void testRemovePiece() {
    CheckersBoard board = new CheckersBoard();

    assertNotNull(board.getPiece(2, 1));

    board.removePiece(2, 1);

    assertNull(board.getPiece(2, 1));
}
}