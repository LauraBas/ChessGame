package pieces;

import board.ChessBoard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnightTest {
    ChessBoard b;

    @BeforeEach
    void setUp() {
       b = new ChessBoard();
       b.init();
    }

    @Test
    void shouldMovePieceAndReturnTrueIfMovementIsAllowed() {
        assertEquals( "white-knight", b.show("g1"));
        assertEquals( "-", b.show("f3"));
        assertTrue(b.move("g1", "f3"));
        assertEquals( "white-knight", b.show("f3"));
        assertEquals( "-", b.show("g1"));
        assertEquals( "white-knight", b.show("b1"));
        assertEquals( "-", b.show("c3"));
        assertTrue(b.move("b1", "c3"));
        assertEquals( "white-knight", b.show("c3"));
        assertEquals( "-", b.show("b1"));
        assertTrue(b.move("c3", "e4"));
        assertEquals( "white-knight", b.show("e4"));
        assertEquals( "-", b.show("c3"));

    }

    @Test
    void shouldReturnFalseIfMovementIsNotAllowed() {
        assertFalse( b.move("g1", "e2"));
        assertFalse( b.move("g1", "g3"));

    }

}