package movements;

import board.ChessBoard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class isKingInCheckTest {
    @Test
    void shouldNotMoveIfKingIsInCheck() {
        ChessBoard b = new ChessBoard();
        b.set("e2", "white-king");
        b.set("d3", "white-pawn");
        b.set("c4", "black-bishop");
        assertFalse(b.move("d3","d4"));
        assertEquals( "white-pawn", b.show("d3"));
    }

}