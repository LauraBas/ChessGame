package pieces;

public interface Piece {
    boolean canMove();
    boolean canEat();
    boolean isOpponentInDestination();
}
