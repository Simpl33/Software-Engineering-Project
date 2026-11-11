import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CheckersGameTest {
    // tests that black is the starting player
    @Test
    public void testStartingPlayer() {
        CheckersGame game = new CheckersGame();

        assertEquals("black", game.getCurrentPlayer());
    }

    // tests the switchTurn method of CheckersGame
    @Test
    public void testSwitchTurn() {
        CheckersGame game = new CheckersGame();

        game.switchTurn();

        assertEquals("red", game.getCurrentPlayer());
    }

    // tests the makeMove method of CheckersGame
    @Test
    public void testValidMove() {
        CheckersGame game = new CheckersGame();

        Move move = new Move(2, 1, 3, 0);

        assertTrue(game.makeMove(move));
    }
}