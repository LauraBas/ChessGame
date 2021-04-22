package pieces;

import board.ChessBoard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KingMovementsTest {

    @Test
    void shouldReturnTrueIfMovementIsAllowed() {
        ChessBoard b = new ChessBoard();
        b.set("d6", "black-king");
        assertTrue(b.move("d6", "d5"));
        b.set("d6", "black-king");
        assertTrue(b.move("d6", "d7"));
        b.set("d6", "black-king");
        assertTrue(b.move("d6", "e6"));
        b.set("d6", "black-king");
        assertTrue(b.move("d6", "e7"));
        b.set("d6", "black-king");
        assertTrue(b.move("d6", "c5"));
        b.set("d6", "black-king");
        assertTrue(b.move("d6", "c7"));
        b.set("d6", "black-king");
        assertTrue(b.move("d6", "e5"));
        b.set("d6", "black-king");
        assertTrue(b.move("d6", "c6"));
    }

    @Test
    void shouldReturnFalseIfMovementNotAllowed() {
        ChessBoard b = new ChessBoard();
        b.set("d6", "black-king");
        assertFalse(b.move("d6", "d8"));
        assertFalse(b.move("d6", "h6"));
        assertFalse(b.move("d6", "d3"));
    }

    @Test
    void shouldEatIfOpponent() {
        ChessBoard b = new ChessBoard();
        b.set("d6", "black-king");
        b.set("d5", "white-rook");
        assertTrue(b.move("d6","d5"));
        assertEquals("black-king", b.show("d5"));
    }

    @Test
    void shouldNotEatIfAlly() {
        ChessBoard b = new ChessBoard();
        b.set("d6", "black-king");
        b.set("d5", "black-rook");
        assertFalse(b.move("d6","d5"));
        assertEquals("black-rook", b.show("d5"));
        assertEquals("black-king", b.show("d6"));
    }


}