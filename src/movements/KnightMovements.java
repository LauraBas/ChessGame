package movements;

import board.Board;

import static java.lang.Integer.parseInt;

public class KnightMovements implements Move {
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
        return isPositionAvailable(board, movement, x, xMov, y, yMov)
                || canEat(board, movement, color, x, xMov, y, yMov);

    }

    private char parseX(String position) {
        String[] positionData = position.split("");
        return positionData[0].charAt(0);
    }

    private int parseY(String position) {
        String[] positionData = position.split("");
        return parseInt(positionData[1]);
    }

    private boolean isPositionAvailable(Board board, String movement, char x, char xMov, int y, int yMov) {
        return board.isSquareEmpty(movement) && isMovementAllowed(x, xMov, y, yMov);
    }

    private boolean canEat(Board board, String movement, String color, char x, char xMov, int y, int yMov) {
        return (isOpponentInDestination(board, movement, color) && isMovementAllowed(x, xMov, y, yMov));

    }

    private boolean isMovementAllowed(char x, char xMov, int y, int yMov) {
        if (y - yMov == -1 && x - xMov == -2) {
            return true;
        }
        if (y - yMov == -1 && x - xMov == 2) {
            return true;
        }
        if (y - yMov == 1 && x - xMov == -2) {
            return true;
        }
        if (y - yMov == 1 && x - xMov == 2) {
            return true;
        }
        if (y - yMov == -2 && x - xMov == 1) {
            return true;
        }
        if (y - yMov == -2 && x - xMov == -1) {
            return true;
        }
        if (y - yMov == 2 && x - xMov == 1) {
            return true;
        }
        return y - yMov == 2 && x - xMov == -1;
    }

    private boolean isOpponentInDestination(Board board, String movement, String color) {
        return !board.getColorAtSquare(movement).equals(color);
    }
}
