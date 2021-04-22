package pieces;

import board.Board;

import static java.lang.Integer.parseInt;

public class DiagonalMovements implements Move {
    @Override
    public boolean isMovementAllowed(String position, String movement, Board board, String color) {

        String[] positionData;
        positionData = position.split("");
        char x = positionData[0].charAt(0);
        int y = parseInt(positionData[1]);
        String[] movementData = movement.split("");
        char xMov = movementData[0].charAt(0);
        int yMov = parseInt(movementData[1]);
        return  canMove(x, xMov, y,yMov, board,  movement, color);
    }
    public boolean canMove(char x, char xMov,int y,int yMov, Board board, String movement, String color) {
        return isPositionAvailable(x, xMov, y,yMov, board,  movement, color) || canEat(x, xMov, y,yMov, board,  movement, color);
    }

    public boolean canEat(char x, char xMov,int y,int yMov, Board board, String movement, String color) {
        return (isOpponentInDestination(board, movement, color) && isMovementAllowed(x, xMov, y, yMov, board, movement, color));
    }

    private boolean isMovementAllowed(char x, char xMov, int y, int yMov,Board board,String movement, String color) {
        if (isFinalPositionAllowed(board, movement, color)) {
            if (isOneMovement(x, xMov, y, yMov)) {
                return true;
            }
            if(!isOneMovement(x, xMov, y, yMov)){
                if (x < xMov && y < yMov) {
                    boolean isEmptyBox = true;
                    while (x < xMov - 1 && y < yMov - 1 && isEmptyBox) {
                        x += 1;
                        y += 1;
                        String a = String.valueOf(x);
                        String b = String.valueOf(y);
                        String box1 = a + b;
                        isEmptyBox = board.isSquareEmpty(box1);
                    }
                    return isEmptyBox;

                }

                if (x > xMov && y > yMov) {
                    boolean isEmptyBox = true;
                    while (x > xMov + 1 && y > yMov + 1) {
                        x -= 1;
                        y -= 1;
                        String a = String.valueOf(x);
                        String b = String.valueOf(y);
                        String box1 = a + b;
                        isEmptyBox = board.isSquareEmpty(box1);
                    }
                    return isEmptyBox;
                }

                if (x > xMov  && y < yMov) {
                    boolean isEmptyBox = true;
                    while(x > xMov - 1  && y < yMov - 1  && isEmptyBox) {
                        x -= 1;
                        y += 1;
                        String a = String.valueOf(x);
                        String b = String.valueOf(y);
                        String box1 = a + b;
                        isEmptyBox = board.isSquareEmpty(box1);
                    }
                    return isEmptyBox;

                }

                if (x < xMov && y > yMov) {
                    boolean isEmptyBox = true;
                    while (x < xMov + 1 && y > yMov + 1 && isEmptyBox) {
                        x += 1;
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

    private boolean isFinalPositionAllowed(Board board, String movement, String color) {
        return board.isSquareEmpty(movement) || isOpponentInDestination(board, movement, color);
    }

    private boolean isOneMovement(char x, char xMov, int y, int yMov) {
        return Math.abs(x - xMov) == 1 && Math.abs(y - yMov) == 1;
    }

    private boolean isPositionAvailable(char x, char xMov,int y,int yMov, Board board, String movement, String color) {
        return board.isSquareEmpty(movement) && isMovementAllowed(x, xMov, y,yMov, board,  movement, color);
    }

    public boolean isOpponentInDestination(Board board, String movement, String color) {
        if(board.isSquareEmpty(movement)) {
            return false;
        }
        return !board.getColorAtSquare(movement).equals(color);
    }
}
