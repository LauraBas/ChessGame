package board;

public interface Board {
    String show(String position);

    boolean isSquareEmpty(String movement);

    String getColorAtSquare(String movement);
}
