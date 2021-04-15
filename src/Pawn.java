public class Pawn implements Piece {
    String movement;
    String position;

    public Pawn(String position, String movement) {
        this.position = position;
        this.movement = movement;
        this.move();
    }

   public void move() {
        this.position  = this.movement;
    }


}
