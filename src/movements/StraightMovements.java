package movements;

import board.Board;

import static java.lang.Integer.parseInt;

public class StraightMovements implements Move {
    @Override
    public boolean isMovementAllowed(String position, String movement, Board board, String color) {

        String[] positionData = position.split("");
        char x = positionData[0].charAt(0);
        int y = parseInt(positionData[1]);
        String[] movementData = movement.split("");
        char xMov = movementData[0].charAt(0);
        int yMov = parseInt(movementData[1]);

        if (isFinalPositionAllowed(movement, board, color)) {
            if (isOneMovement(x, xMov, y, yMov)) {
                return true;
            }
            if (!isOneMovement(x, xMov, y, yMov)) {
                if (x < xMov - 1 && y == yMov) {
                    boolean isEmptyBox = true;
                    while (x < xMov - 1 && isEmptyBox) {
                        x += 1;
                        String a = String.valueOf(x);
                        String b = String.valueOf(y);
                        String box1 = a + b;
                        isEmptyBox = board.isSquareEmpty(box1);
                    }
                    return isEmptyBox;

                }

                if (x > xMov && y == yMov) {
                    boolean isEmptyBox = true;
                    while (x > xMov + 1 && isEmptyBox) {
                        x -= 1;
                        String a = String.valueOf(x);
                        String b = String.valueOf(y);
                        String box1 = a + b;
                        isEmptyBox = board.isSquareEmpty(box1);
                    }
                    return isEmptyBox;
                }

                if (y < yMov && x == xMov) {
                    boolean isEmptyBox = true;
                    while (y < yMov - 1 && isEmptyBox) {
                        y += 1;
                        String a = String.valueOf(x);
                        String b = String.valueOf(y);
                        String box1 = a + b;
                        isEmptyBox = board.isSquareEmpty(box1);
                    }
                    return isEmptyBox;

                }

                if (y > yMov && x == xMov) {
                    boolean isEmptyBox = true;
                    while (y > yMov + 1 && isEmptyBox) {
                        y -= 1;
                        String a = String.valueOf(x);
                        String b = String.valueOf(y);
                        String box1 = a + b;
                        isEmptyBox = board.isSquareEmpty(box1);
                    }
                    return isEmptyBox;
                }
            }

        }
        return false;
    }

    private boolean isFinalPositionAllowed(String movement, Board board, String color) {
        return board.isSquareEmpty(movement) || isOpponentInDestination(board, movement, color);
    }

    private boolean isOneMovement(char x, char xMov, int y, int yMov) {
        return Math.abs(x - xMov) == 1 || Math.abs(y - yMov) == 1;
    }

    public boolean isOpponentInDestination(Board board, String movement, String color) {
        if (board.isSquareEmpty(movement)) {
            return false;
        }
        return !board.getColorAtSquare(movement).equals(color);
    }
}

