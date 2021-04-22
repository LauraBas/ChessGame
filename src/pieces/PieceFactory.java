package pieces;

import board.Board;
import movements.DiagonalMovements;
import movements.KnightMovements;
import movements.PawnMovements;
import movements.StraightMovements;

public class PieceFactory  {

    public Piece getPiece(String[] result, String position, Board board) {
        String color = result[0];
        if (result[1].equals("pawn")) {
            return new Piece(position, color, board, new PawnMovements());
        }
        if (result[1].equals("knight")) {
            return new Piece(position, color, board, new KnightMovements());
        }
        if (result[1].equals("bishop")) {
            return new Piece(position, color, board, new DiagonalMovements());
        }
       if (result[1].equals("rook")) {
            return new Piece(position, color, board, new StraightMovements());
      }
        throw new Error("No piece found!!! BAD ERROR");
    }

}
