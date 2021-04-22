package movements;

import board.Board;

import static java.lang.Integer.parseInt;

public class KingMovements implements Move {
    @Override
    public boolean isMovementAllowed(String position, String movement, Board board, String color) {
        String[] positionData;
        positionData = position.split("");
        char x = positionData[0].charAt(0);
        int y = parseInt(positionData[1]);
        String[] movementData =  movement.split("");
        char xMov = movementData[0].charAt(0);
        int yMov =  parseInt(movementData[1]);

        if (isPositionAvailable(board, movement) && isOneMovement(x, xMov, y, yMov)) {
            return true;
        } else return isOpponentInDestination(board, movement, color) && isOneMovement(x, xMov, y, yMov);
    }

    public boolean isOpponentInDestination(Board board, String movement, String color) {
        return !board.getColorAtSquare(movement).equals(color);
    }
    private boolean isPositionAvailable(Board board, String movement) {
        return board.isSquareEmpty(movement);
    }

    private boolean isOneMovement(char x, char xMov, int y, int yMov) {
        return Math.abs(x - xMov) == 1 || x - xMov == 0   && Math.abs(y - yMov) == 1;
    }
}
