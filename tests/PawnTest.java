import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PawnTest {

    @Test
    void shouldMovePieceAndReturnTrueIfMovementIsAllowed() {
        ChessBoard b = new ChessBoard();
        assertEquals( "white-pawn", b.show("a2"));
        assertEquals( "-", b.show("a3"));
        assertTrue(b.move("a2", "a3"));
        assertEquals( "white-pawn", b.show("a3"));
        assertEquals( "-", b.show("a2"));
    }

    @Test
    void shouldWhitePawnMoveTwiceIfFirstMovement() {
        ChessBoard b = new ChessBoard();
        assertEquals( "white-pawn", b.show("a2"));
        assertEquals( "-", b.show("a3"));
        assertTrue(b.move("a2", "a4"));
        assertEquals( "white-pawn", b.show("a4"));
        assertEquals( "-", b.show("a2"));
    }

    @Test
    void shouldReturnFalseIfMovementIsNotAllowed() {
        ChessBoard b = new ChessBoard();
        assertFalse( b.move("a2", "c3"));
        assertFalse( b.move("b2", "b6"));
        assertFalse( b.move("c2", "a3"));
    }

    @Test
    void shouldReturnTueIfMovementIsAllowedForBlackPawn() {
        ChessBoard b = new ChessBoard();
        assertEquals( "black-pawn", b.show("a7"));
        assertEquals( "-", b.show("a6"));
        assertTrue(b.move("a7", "a6"));
        assertEquals( "black-pawn", b.show("a6"));
        assertEquals( "-", b.show("a7"));
    }

    @Test
    void shouldBlackPawnMoveTwiceIfFirstMovement() {
        ChessBoard b = new ChessBoard();
        assertEquals( "black-pawn", b.show("a7"));
        assertEquals( "-", b.show("a5"));
        assertTrue(b.move("a7", "a5"));
        assertEquals( "black-pawn", b.show("a5"));
        assertEquals( "-", b.show("a7"));
    }

    @Test
    void shouldReturnFalseIfMovementIsNotAllowedForBlackPawn() {
        ChessBoard b = new ChessBoard();
        assertFalse( b.move("a7", "c8"));
        assertFalse( b.move("b7", "b9"));
        assertFalse( b.move("c7", "a5"));
    }

    @Test
    void shouldReturnFalseIfMovementIsBlockedWithAnotherPiece() {
        ChessBoard b = new ChessBoard();
        assertTrue(b.move("a2", "a3"));
        assertTrue(b.move("a3", "a4"));
        assertTrue( b.move("a4", "a5"));
        assertTrue(b.move("a5", "a6"));
        assertFalse(b.move("a6", "a7"));
    }

    @Test
    void shouldReturnTrueIfCanEatAPiece() {
        ChessBoard b = new ChessBoard();
        b.move("a2", "a4");
        b.move("b7", "b5");
        Assertions.assertEquals("black-pawn", b.show("b5"));
        assertTrue( b.move("a4", "b5"));
        Assertions.assertEquals("white-pawn", b.show("b5"));
    }

    @Test
    void shouldReturnFalseIfCanNotEatSameColorPiece() {
        ChessBoard b = new ChessBoard();
        b.move("a2", "a3");
        b.move("b2", "b4");
        assertFalse(b.move("a3", "b4"));
        b.move("a7", "a6");
        b.move("b7", "b5");
        assertFalse(b.move("a6", "b5"));
    }

    @Test
    void shouldReturnFalseIfCanNotEatBehind() {
        ChessBoard b = new ChessBoard();
        b.move("a2", "a4");
        b.move("b7", "b5");
        b.move("a4", "a5");
        b.move("b5", "b4");
        assertFalse(b.move("a5", "b4"));
        b.move("f7", "f5");
        b.move("g2", "g4");
        b.move("f5", "f4");
        b.move("g4", "g5");
        assertFalse(b.move("f4", "g5"));
    }


}