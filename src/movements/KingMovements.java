package movements;

import board.Board;

import static java.lang.Integer.parseInt;

public class KingMovements implements Move {
    @Override
    public boolean isMovementAllowed(String position, String movement, Board board, String color) {

        return canMove(
                parseX(position),
                parseX(movement),
                parseY(position),
                parseY(movement),
                board,
                movement,
                color
        );
    }

    private boolean canMove(char x, char xMov, int y, int yMov, Board board, String movement, String color) {
         if (isPositionAvailable(board, movement) && isOneMovement(x, xMov, y, yMov)) {
             return true;
         } else return isOpponentInDestination(board, movement, color)
                && isOneMovement(x, xMov, y, yMov);
    }

    private char parseX(String position) {
        String[] positionData = position.split("");
        return positionData[0].charAt(0);
    }

    private int parseY(String position) {
        String[] positionData = position.split("");
        return parseInt(positionData[1]);
    }

    private boolean isOpponentInDestination(Board board, String movement, String color) {
        return !board.getColorAtSquare(movement).equals(color);
    }

    private boolean isPositionAvailable(Board board, String movement) {
        return board.isSquareEmpty(movement);
    }

    private boolean isOneMovement(char x, char xMov, int y, int yMov) {
        return Math.abs(x - xMov) <= 1 && Math.abs(y - yMov) <= 1;
    }
}
