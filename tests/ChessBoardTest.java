import board.ChessBoard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChessBoardTest {

    @Test
    void shouldShowPiecesByPosition() {
        ChessBoard b = new ChessBoard();
        b.init();
        assertEquals( "white-pawn", b.show("a2"));
        assertEquals( "black-pawn", b.show("a7"));
        assertEquals( "white-king", b.show("e1"));
        assertEquals( "-", b.show("a5"));
    }

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