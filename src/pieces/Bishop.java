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
        if (this.board.show(this.movement).equals("-") || isOpponent()) {
            if (Math.abs(this.x - this.xMov) == 1  && Math.abs(this.y - this.yMov) == 1) {
                return true;
            } else {
                while (this.x < this.xMov && this.y < this.yMov) {
                    this.x += 1;
                    this.y += 1;
                    String a = String.valueOf(x);
                    String b = String.valueOf(y);
                    String box1 = a + b;
                    return this.board.show(box1).equals("-");
                }

                while (this.x > this.xMov && this.y > this.yMov) {
                    this.x -= 1;
                    this.y -= 1;
                    String c = String.valueOf(x);
                    String d = String.valueOf(y);
                    String box2 = c + d;
                    return this.board.show(box2).equals("-");
                }

                while (this.x > this.xMov  && this.y < this.yMov) {
                    this.x -= 1;
                    this.y += 1;
                    String e = String.valueOf(x);
                    String f = String.valueOf(y);
                    String box3 = e + f;
                    return this.board.show(box3).equals("-");
                }

                while (this.x < this.xMov && this.y > this.yMov) {
                    this.x += 1;
                    this.y -= 1;
                    String g = String.valueOf(x);
                    String h = String.valueOf(y);
                    String box4 = g + h;
                    return this.board.show(box4).equals("-");
                }

            }

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
