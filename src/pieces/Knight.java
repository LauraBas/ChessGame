package pieces;

import board.Board;

import static java.lang.Integer.parseInt;

public class Knight implements Piece {

    String movement;
    String position;
    String color;
    char x;
    Board board;
    int y;
    char xMov;
    int yMov;

    public Knight(String position, String movement, String color, Board board) {
        this.position = position;
        this.movement = movement;
        this.color = color;
        String[] positionData =  this.position.split("");
        this.x = positionData[0].charAt(0);
        this.y = parseInt(positionData[1]);
        String[] movementData =  this.movement.split("");
        this.xMov = movementData[0].charAt(0);
        this.yMov =  parseInt(movementData[1]);
        this.board = board;
    }

    public boolean canMove() {
        return isPositionAvailable() || canEat();

    }
    private boolean isPositionAvailable() {
        return this.board.show(this.movement).equals("-") && isMovementAllowed();
    }

    public boolean canEat() {
        return (isOpponent() && isMovementAllowed());

    }

    private boolean isMovementAllowed() {
        if (this.y - this.yMov == -1 && this.x - this.xMov == -2) {
            return true;
        }
        if (this.y - this.yMov == -1 && this.x - this.xMov == 2) {
            return true;
        }
        if (this.y - this.yMov == 1 && this.x - this.xMov == -2) {
            return true;
        }
        if (this.y - this.yMov == 1 && this.x - this.xMov == 2) {
            return true;
        }
        if (this.y - this.yMov == -2 && this.x - this.xMov == 1) {
            return true;
        }
        if (this.y - this.yMov == -2 && this.x - this.xMov == -1) {
            return true;
        }
        if (this.y - this.yMov == 2 && this.x - this.xMov == 1) {
            return true;
        }
        if (this.y - this.yMov == 2 && this.x - this.xMov == -1) {
            return true;
        }
        else return false;
    }

    public boolean isOpponent() {
        String piece = this.board.show(this.movement);
        if (!piece.equals("-")) {
            String[] result = piece.split("-");
            String opponent = result[0];
            return !opponent.equals(this.color);
        }
        return false;
    }
}
