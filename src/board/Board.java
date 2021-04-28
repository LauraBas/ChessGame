package board;

import java.util.HashMap;

public interface Board {
    String show(String position);

    boolean isSquareEmpty(String movement);

    String getColorAtSquare(String movement);

    String getPiecePosition(String king);

    HashMap<String, String> getBoard();
}
