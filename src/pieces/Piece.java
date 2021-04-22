package pieces;

import board.Board;
import movements.Move;
import java.util.List;

public class Piece implements IPiece{
    String position;
    String color;
    Board board;
    List<Move> list;


    public Piece(String position, String color, Board board, List listOfMovements) {

        this.position = position;
        this.color = color;
        this.board = board;
        this.list = listOfMovements;

    }

    public boolean canMove(String movement){
        for (int i = 0; i < this.list.size(); i++) {
           while(this.list.get(i).isMovementAllowed(this.position, movement, this.board, this.color)){
               return true;
           }
        }
        return false;

    }
}
