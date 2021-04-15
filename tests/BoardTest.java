import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BoardTest {

    @Test
    void shouldShowPiecesByPosition() {
        Board b = new Board();
        Assertions.assertEquals( "white-pawn", b.show("a2"));
        Assertions.assertEquals( "black-pawn", b.show("a7"));
        Assertions.assertEquals( "white-king", b.show("e1"));
    }

}