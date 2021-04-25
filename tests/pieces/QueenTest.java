package pieces;

import board.ChessBoard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QueenTest {
    @Test
    void shouldReturnTrueIfMovementIsAllowed() {
        ChessBoard b = new ChessBoard();
        b.set("d6", "black-queen");
        assertTrue(b.move("d6", "b8"));
        assertTrue(b.move("b8", "b5"));
        assertTrue(b.move("b5", "h5"));
        assertTrue(b.move("h5", "h1"));
        assertTrue(b.move("h1", "a8"));
        assertTrue(b.move("a8", "a1"));
        assertTrue(b.move("a1", "d4"));
        assertTrue(b.move("d4", "h4"));
        assertEquals("black-queen", b.show("h4"));
    }

    @Test
    void shouldReturnFalseIfMovementNotAllowed() {
        ChessBoard b = new ChessBoard();
        b.set("d6", "black-queen");
        assertFalse(b.move("d6","e8"));
    }

    @Test
    void shouldEatIfOpponent() {
        ChessBoard b = new ChessBoard();
        b.set("d6", "black-queen");
    }
}
