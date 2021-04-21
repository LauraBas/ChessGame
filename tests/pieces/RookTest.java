package pieces;

import board.ChessBoard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;


class RookTest {
    @Test
    void shouldReturnTrueIfMovementIsAllowed() {
        ChessBoard b = new ChessBoard();
        assertEquals( "white-rook", b.show("a1"));
        assertTrue(b.move("a2", "a4"));
        assertTrue(b.move("a1", "a3"));
        assertEquals( "white-rook", b.show("a3"));
        assertTrue(b.move("a3", "h3"));
        assertTrue(b.move("h3", "e3"));
        assertTrue(b.move("e3", "e5"));
        assertTrue(b.move("e5", "c5"));
        assertTrue(b.move("c5", "c3"));
        assertEquals( "white-rook", b.show("c3"));
    }

    @Test
    void shouldReturnFalseIfMovementIsNotAllowed() {
        ChessBoard b = new ChessBoard();
        assertTrue(b.move("a2", "a4"));
        assertTrue(b.move("a1", "a3"));
        assertEquals( "white-rook", b.show("a3"));
        assertFalse( b.move("a3", "c1"));
        b.move("a3", "a2");
        assertFalse( b.move("a2", "g2"));
    }

}