import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void shouldShowPiecesByPosition() {
        Board b = new Board();
        assertEquals( "white-pawn", b.show("a2"));
        assertEquals( "black-pawn", b.show("a7"));
        assertEquals( "white-king", b.show("e1"));
        assertEquals( "-", b.show("a5"));
    }

}