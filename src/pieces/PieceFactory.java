package pieces;

import board.Board;
import movements.*;

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
        if (result[1].equals("king")) {
            return new Piece(position, color, board, new KingMovements());
        }
        throw new Error("No piece found!!! BAD ERROR");
    }

}
