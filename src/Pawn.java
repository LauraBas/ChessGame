import static java.lang.Integer.parseInt;

public class Pawn implements Piece {
    String movement;
    String position;
    String color;
    String x;
    Board board;
    int y;
    String xMov;
    int yMov;

    public Pawn(String position, String movement, String color, Board board) {
        this.position = position;
        this.movement = movement;
        this.color = color;
        String[] positionData =  this.position.split("");
        this.x = positionData[0];
        this.y = parseInt(positionData[1]);
        String[] movementData =  this.movement.split("");
        this.xMov = movementData[0];
        this.yMov =  parseInt(movementData[1]);
        this.board = board;
    }

    public boolean move() {
        if (isPositionAvailable()) {
           if (isWhite()) {
               if(isWhiteFirstMove()) {
                   return true;
               }
               else return canWhiteMove();
           }
           else {
               if (isBlackFirstMove()) {
                   return true;
               }
               else return canBlackMove();
           }
        }
        else {
            return false;
        }

    }

    private boolean isPositionAvailable() {
        return this.board.show(this.movement).equals("-");
    }

    private boolean isWhite() {
        return this.color.equals("white");
    }

    private boolean canBlackMove() {
        return (this.x.equals(this.xMov)) && (this.y - this.yMov == 1);
    }

    private boolean isBlackFirstMove() {
        return (this.x.equals(this.xMov)) && this.y == 7 && this.yMov == 5;
    }

    private boolean canWhiteMove() {
        return (this.x.equals(this.xMov)) && (this.yMov - this.y == 1);
    }

    private boolean isWhiteFirstMove() {
        return (this.x.equals(this.xMov)) && this.y == 2 && this.yMov == 4;
    }

}
