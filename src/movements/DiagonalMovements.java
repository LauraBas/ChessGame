package movements;

import board.Board;

import static java.lang.Integer.parseInt;

public class DiagonalMovements implements Move {
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

    public boolean canMove(char x, char xMov, int y, int yMov, Board board, String movement, String color) {
        return isPositionAvailable(x, xMov, y, yMov, board, movement, color)
                || canEat(x, xMov, y, yMov, board, movement, color);
    }

    private boolean canEat(char x, char xMov, int y, int yMov, Board board, String movement, String color) {
        return isOpponentInDestination(board, movement, color)
                && isMovementAllowed(x, xMov, y, yMov, board, movement, color);
    }

    private char parseX(String position) {
        String[] positionData = position.split("");
        return positionData[0].charAt(0);
    }

    private int parseY(String position) {
        String[] positionData = position.split("");
        return parseInt(positionData[1]);
    }

    private boolean isMovementAllowed(char x, char xMov, int y, int yMov, Board board, String movement, String color) {
        return isFinalPositionAllowed(board, movement, color)
                && onSameDiagonal(x, y, xMov, yMov)
                && noPiecesBetween(x, xMov, y, yMov, board);
    }

    private boolean noPiecesBetween(char x, char xMov, int y, int yMov, Board board) {
        int xVector = getVector(x, xMov);
        int yVector = getVector(y, yMov);
        int xAttempt = (x + xVector);
        int yAttempt = y + yVector;
        while (xAttempt != xMov && yAttempt != y) {
            String box = getPosition(xAttempt, yAttempt);
            if (!board.isSquareEmpty(box)) {
                return false;
            }
            xAttempt += xVector;
            yAttempt += yVector;
        }
        return true;
    }

    private int getVector(int a, int b) {
        return (b - a) / distance(a, b);
    }

    private int distance(int a, int b) {
        return Math.abs(b - a);
    }

    private String getPosition(int xAttempt, int yAttempt) {
        String a = String.valueOf((char) xAttempt);
        String b = String.valueOf(yAttempt);
        return a + b;
    }

    private boolean onSameDiagonal(char x, int y, char xMov, int yMov) {
        return distance(xMov, x) == distance(y, yMov);
    }

    private boolean isFinalPositionAllowed(Board board, String movement, String color) {
        return board.isSquareEmpty(movement) || isOpponentInDestination(board, movement, color);
    }

    private boolean isPositionAvailable(char x, char xMov, int y, int yMov, Board board, String movement, String color) {
        return board.isSquareEmpty(movement) && isMovementAllowed(x, xMov, y, yMov, board, movement, color);
    }

    private boolean isOpponentInDestination(Board board, String destination, String color) {
        return !board.isSquareEmpty(destination) && !board.getColorAtSquare(destination).equals(color);
    }
}
