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

    @Test
    void shouldEatIfOpponentInOneMovement() {
        ChessBoard b = new ChessBoard();
        assertEquals( "white-rook", b.show("a1"));
        assertTrue(b.move("a2", "a4"));
        assertTrue(b.move("a1", "a3"));
        assertEquals( "white-rook", b.show("a3"));
        assertTrue(b.move("a3", "h3"));
        assertEquals( "black-pawn", b.show("h7"));
        assertTrue(b.move("h3", "h6"));
        assertEquals( "white-rook", b.show("h6"));
        assertTrue(b.move("h6", "h7"));
        assertEquals( "white-rook", b.show("h7"));
    }

    @Test
    void shouldEatIfOpponent() {
        ChessBoard b = new ChessBoard();
        assertEquals( "white-rook", b.show("a1"));
        assertTrue(b.move("a2", "a4"));
        assertTrue(b.move("a1", "a3"));
        assertEquals( "white-rook", b.show("a3"));
        assertTrue(b.move("a3", "h3"));
        assertEquals( "black-pawn", b.show("h7"));
        assertTrue(b.move("h3", "h7"));
        assertEquals( "white-rook", b.show("h7"));
        assertTrue(b.move("g7", "g6"));
        assertTrue(b.move("h7", "f7"));
        assertEquals( "white-rook", b.show("f7"));
    }

    @Test
    void shouldNotEatIfAlly() {
        ChessBoard b = new ChessBoard();
        assertEquals( "white-rook", b.show("a1"));
        assertFalse(b.move("a1","b1"));
        assertFalse(b.move("a1","a2"));
        assertTrue(b.move("a2", "a3"));
        assertFalse(b.move("a1","a3"));
    }

}