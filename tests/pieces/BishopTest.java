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
        b.move("d7", "d5");
        b.move("d5", "d4");
        assertEquals( "black-pawn", b.show("d4"));
        assertTrue(b.move("g7", "d4"));
        assertEquals( "white-bishop", b.show("d4"));
    }

    @Test
    void shouldNotEatIfAlly() {
        ChessBoard b = new ChessBoard();
        assertEquals( "white-bishop", b.show("c1"));
        assertFalse(b.move("c1","d2"));

    }

    @Test
    void shouldNotMoveIfOpponentInThePath() {
        ChessBoard b = new ChessBoard();
        b.move("d2", "d3");
        b.move("g7", "g5");
        assertEquals( "black-pawn", b.show("g5"));
        assertFalse(b.move("c1", "h6"));
    }

    @Test
    void shouldEatIfOpponentInDestination() {
        ChessBoard b = new ChessBoard();
        assertEquals( "white-bishop", b.show("f1"));
        b.move("e2", "e3");
        assertTrue(b.move("a7","a6"));
        assertTrue(b.move("f1","a6"));
        assertEquals( "white-bishop", b.show("a6"));
        assertTrue(b.move("d7","d5"));
        assertTrue(b.move("d5","d4"));
        assertTrue(b.move("d4","d3"));
        assertTrue(b.move("a6","d3"));

    }


}