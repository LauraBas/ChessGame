import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PawnTest {

    @Test
    void shouldMovePieceAndReturnTrueIfMovementIsAllowed() {
        Board b = new Board();
        assertEquals( "white-pawn", b.show("a2"));
        assertEquals( "-", b.show("a3"));
        assertTrue(b.move("a2", "a3"));
        assertEquals( "white-pawn", b.show("a3"));
        assertEquals( "-", b.show("a2"));
    }

    @Test
    void shouldWhitePawnMoveTwiceIfFirstMovement() {
        Board b = new Board();
        assertEquals( "white-pawn", b.show("a2"));
        assertEquals( "-", b.show("a3"));
        assertTrue(b.move("a2", "a4"));
        assertEquals( "white-pawn", b.show("a4"));
        assertEquals( "-", b.show("a2"));
    }

    @Test
    void shouldReturnFalseIfMovementIsNotAllowed() {
        Board b = new Board();
        assertFalse( b.move("a2", "c3"));
        assertFalse( b.move("b2", "b6"));
        assertFalse( b.move("c2", "a3"));
    }

    @Test
    void shouldReturnTueIfMovementIsAllowedForBlackPawn() {
        Board b = new Board();
        assertEquals( "black-pawn", b.show("a7"));
        assertEquals( "-", b.show("a6"));
        assertTrue(b.move("a7", "a6"));
        assertEquals( "black-pawn", b.show("a6"));
        assertEquals( "-", b.show("a7"));
    }

    @Test
    void shouldBlackPawnMoveTwiceIfFirstMovement() {
        Board b = new Board();
        assertEquals( "black-pawn", b.show("a7"));
        assertEquals( "-", b.show("a5"));
        assertTrue(b.move("a7", "a5"));
        assertEquals( "black-pawn", b.show("a5"));
        assertEquals( "-", b.show("a7"));
    }

    @Test
    void shouldReturnFalseIfMovementIsNotAllowedForBlackPawn() {
        Board b = new Board();
        assertFalse( b.move("a7", "c8"));
        assertFalse( b.move("b7", "b9"));
        assertFalse( b.move("c7", "a5"));
    }

    @Test
    void shouldReturnFalseIfMovementIsBlockedWithAnotherPiece() {
        Board b = new Board();
        assertTrue(b.move("a2", "a3"));
        assertTrue(b.move("a3", "a4"));
        assertTrue( b.move("a4", "a5"));
        assertTrue(b.move("a5", "a6"));
        assertFalse(b.move("a6", "a7"));
    }

    @Test
    void shouldReturnTrueIfCanEatAPiece() {
        Board b = new Board();
        b.move("a2", "a4");
        b.move("b7", "b5");
        Assertions.assertEquals("black-pawn", b.show("b5"));
        assertTrue( b.move("a4", "b5"));
        Assertions.assertEquals("white-pawn", b.show("b5"));
    }


}