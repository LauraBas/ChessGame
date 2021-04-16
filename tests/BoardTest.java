import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    void shouldMovePieceAndReturnTrueIfMovementIsAllowed() {
        Board b = new Board();
        assertEquals( "white-pawn", b.show("a2"));
        assertEquals( "-", b.show("a3"));
        assertTrue(b.move("a2", "a3"));
        assertTrue(b.move("b3", "b4"));
        assertEquals( "white-pawn", b.show("a3"));
        assertEquals( "-", b.show("a2"));
    }

    @Test
    void shouldReturnFalseIfMovementIsNotAllowed() {
        Board b = new Board();
        assertFalse( b.move("a2", "c3"));
        assertFalse( b.move("b2", "b6"));
        assertFalse( b.move("c2", "a3"));
    }

}