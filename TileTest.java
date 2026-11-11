import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TileTest {
    // tests the creation of Tile objects and their properties
    @Test
    public void testTile() {
        Tile tile = new Tile(2, 3);

        assertEquals(2, tile.getRow());
        assertEquals(3, tile.getCol());
    }
}