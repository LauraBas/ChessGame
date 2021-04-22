package pieces;

import board.Board;

public class Piece implements IPiece{
    String position;
    String color;
    Board board;
    Move movementsAllowed;

    public Piece(String position, String color, Board board, Move movementsAllowed) {

        this.position = position;
        this.color = color;
        this.board = board;
        this.movementsAllowed = movementsAllowed;

    }

    public boolean canMove(String movement){
        return this.movementsAllowed.isMovementAllowed(this.position, movement, this.board, this.color);
    }
}
