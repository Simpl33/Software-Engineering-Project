import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MoveTest {
    // tests the creation of Move objects and their properties
    @Test
    public void testMove() {
        Move move = new Move(2, 1, 3, 0);

        assertEquals(2, move.getStartRow());
        assertEquals(1, move.getStartCol());
        assertEquals(3, move.getEndRow());
        assertEquals(0, move.getEndCol());
    }
}