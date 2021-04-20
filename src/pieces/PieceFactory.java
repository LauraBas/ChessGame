package pieces;

import board.Board;

public class PieceFactory  {

    public Piece getPiece(String[] result, String position, String movement, Board board) {
        String color = result[0];
        if (result[1].equals("pawn")) {
            return new Pawn(position, movement, color, board);
        }
        if (result[1].equals("knight")) {
            return new Knight(position, movement, color, board);
        }
        if (result[1].equals("bishop")) {
            return new Bishop(position, movement, color, board);
        }
        throw new Error("No piece found!!! BAD ERROR");
    }


}
