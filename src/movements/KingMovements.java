package movements;

import board.Board;

public class KingMovements implements Move {
    @Override
    public boolean isMovementAllowed(String position, String movement, Board board, String color) {
        return false;
    }
}
