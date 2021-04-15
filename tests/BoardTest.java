import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BoardTest {

    @Test
    void shouldShowPiecesByPosition() {
        Board b = new Board();
        assertEquals( "white-pawn", b.show("a2"));
        assertEquals( "black-pawn", b.show("a7"));
        assertEquals( "white-king", b.show("e1"));
        assertEquals( "-", b.show("a5"));
    }

    @Test
    void shouldMovePiece() {
        Board b = new Board();
        assertEquals( "white-pawn", b.show("a2"));
        assertEquals( "-", b.show("a3"));
        boolean moveOk = b.move("a2", "a3");
        assertTrue(moveOk);
        assertEquals( "white-pawn", b.show("a3"));
        assertEquals( "-", b.show("a2"));
    }

}