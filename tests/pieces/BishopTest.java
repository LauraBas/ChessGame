package pieces;

import board.ChessBoard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

class BishopTest {

    @Test
    void shouldMovePieceAndReturnTrueIfMovementIsAllowed() {
        ChessBoard b = new ChessBoard();
        assertEquals( "white-bishop", b.show("c1"));
        b.move("d2", "d3");
        assertTrue(b.move("c1","f4"));
        assertTrue(b.move("f4","g3"));
        assertTrue(b.move("g3","d6"));
        assertTrue(b.move("d6","a3"));
    }

    @Test
    void shouldReturnFalseIfMovementIsNotAllowed() {
        ChessBoard b = new ChessBoard();
        b.move("d2", "d3");
        b.move("c1", "h6");
        assertFalse( b.move("h6", "f8"));
        assertFalse( b.move("h6", "d7"));
    }

    @Test
    void shouldEatIfOpponent() {
        ChessBoard b = new ChessBoard();
        assertEquals( "white-bishop", b.show("c1"));
        b.move("d2", "d3");
        assertTrue(b.move("c1","h6"));
        assertEquals( "white-bishop", b.show("h6"));
        assertEquals( "black-pawn", b.show("g7"));
        assertTrue(b.move("h6","g7"));
        assertEquals( "white-bishop", b.show("g7"));
    }

    @Test
    void shouldNotEatIfAllied() {
        ChessBoard b = new ChessBoard();
        assertEquals( "white-bishop", b.show("c1"));
        assertFalse(b.move("c1","d2"));

    }

}