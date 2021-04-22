package pieces;

import board.Board;


import static java.lang.Integer.parseInt;

public class PawnMovements implements Move {
    @Override
    public boolean isMovementAllowed(String position, String movement, Board board, String color) {

        String[] positionData;
        positionData = position.split("");
        char x = positionData[0].charAt(0);
        int y = parseInt(positionData[1]);
        String[] movementData =  movement.split("");
        char xMov = movementData[0].charAt(0);
        int yMov =  parseInt(movementData[1]);

        if (!isPositionAvailable(board, movement) && canEat(board, movement, color, x, xMov, y, yMov)) {
            return true;
        }
        if (isPositionAvailable(board, movement)) {
            if (isWhite(color)) {
                if(isWhiteFirstMove(x, xMov, y, yMov)) {
                    return true;
                }
                else return canWhiteMove(x, xMov, y, yMov);
            }
            else {
                if (isBlackFirstMove(x, xMov, y, yMov)) {
                    return true;
                }
                else return canBlackMove(x, xMov, y, yMov);
            }
        }
        else {
            return false;
        }

    }

    public boolean isOpponentInDestination(Board board, String movement, String color) {
        return !board.getColorAtSquare(movement).equals(color);
    }
    public boolean canEat(Board board, String movement, String color, char x, char xMov, int y, int yMov) {
        if (isWhite(color)) {
            return (isOpponentInDestination(board, movement, color) && y - yMov == -1 && Math.abs(x - xMov) == 1);
        } else return (isOpponentInDestination(board, movement, color) && y - yMov == 1 && Math.abs(x - xMov) == 1);
    }

    private boolean isPositionAvailable(Board board, String movement) {
        return board.isSquareEmpty(movement);
    }

    private boolean isWhite(String color) {
        return color.equals("white");
    }

    private boolean canBlackMove(char x, char xMov, int y, int yMov) {
        return (x == xMov) && (y - yMov == 1);
    }

    private boolean isBlackFirstMove(char x, char xMov, int y, int yMov) {
        return (x == xMov) && y == 7 && yMov == 5;
    }

    private boolean canWhiteMove(char x, char xMov, int y, int yMov) {
        return (x == xMov) && (yMov - y == 1);
    }

    private boolean isWhiteFirstMove(char x, char xMov, int y, int yMov) {
        return (x == xMov) && y == 2 && yMov == 4;
    }

}
