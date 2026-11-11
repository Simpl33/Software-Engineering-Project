import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class moveValidatorTest {

    @Test
    public void testValidMove() {
        CheckersBoard board = new CheckersBoard();
        moveValidator validator = new moveValidator();

        Move move = new Move(2, 1, 3, 0);

        assertTrue(validator.isValidMove(move, board, "black"));
    }

    @Test
    public void testInvalidMove() {
        CheckersBoard board = new CheckersBoard();
        moveValidator validator = new moveValidator();

        Move move = new Move(3, 2, 4, 3);

        assertFalse(validator.isValidMove(move, board, "black"));
    }

    @Test
    public void testWrongPlayer() {
        CheckersBoard board = new CheckersBoard();
        moveValidator validator = new moveValidator();

        Move move = new Move(5, 0, 4, 1);

        assertFalse(validator.isValidMove(move, board, "black"));
    }

    @Test
    public void testKing() {
        moveValidator validator = new moveValidator();
        Piece piece = new Piece("black");

        piece.setKing(true);

        assertTrue(validator.canKingMove(piece));
    }
}