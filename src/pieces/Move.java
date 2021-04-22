package pieces;

import board.Board;

public interface Move {
    boolean isMovementAllowed(String position, String movement, Board board, String color);

}
