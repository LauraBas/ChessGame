package pieces;

import board.Board;

import static java.lang.Integer.parseInt;

public class Bishop implements Piece{
    String movement;
    String position;
    String color;
    char x;
    Board board;
    int y;
    char xMov;
    int yMov;

    public Bishop(String position, String movement, String color, Board board) {
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

    public boolean canEat() {
        return (isOpponent() && isMovementAllowed());
    }

    private boolean isMovementAllowed() {

            while (this.x < this.xMov && this.y < this.yMov) {
                this.x += 1;
                this.y += 1;
                String a = String.valueOf(x);
                String b = String.valueOf(y);
                String box = a + b;
                return this.board.show(box).equals("-");
                }

            while (this.x > this.xMov && this.y > this.yMov) {
                this.x -= 1;
                this.y -= 1;
                String a = String.valueOf(x);
                String b = String.valueOf(y);
                String box = a + b;
                return this.board.show(box).equals("-");
            }

            while (this.x > this.xMov && this.y < this.yMov) {
                this.x -= 1;
                this.y += 1;
                String a = String.valueOf(x);
                String b = String.valueOf(y);
                String box = a + b;
                return this.board.show(box).equals("-");
            }

            while (this.x < this.xMov && this.y > this.yMov) {
                this.x += 1;
                this.y -= 1;
                String a = String.valueOf(x);
                String b = String.valueOf(y);
                String box = a + b;
                return this.board.show(box).equals("-");
            }
            return false;
    }

    private boolean isPositionAvailable() {
        return this.board.show(this.movement).equals("-") && isMovementAllowed();
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
