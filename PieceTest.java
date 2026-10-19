import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PieceTest {

    @Test
    // tests the creation of Piece objects and their properties
    public void testPieceCreation() {

        Piece blackPiece = new Piece("black");

        assertEquals("black", blackPiece.getColor());
        assertFalse(blackPiece.isKing());

        Piece redPiece = new Piece("red");

        assertEquals("red", redPiece.getColor());
        assertFalse(redPiece.isKing());
    }

    @Test
    // tests the setKing method of Piece
    public void testSetKing() {

        Piece piece = new Piece("black");

        assertFalse(piece.isKing());

        piece.setKing(true);

        assertTrue(piece.isKing());
    }
}