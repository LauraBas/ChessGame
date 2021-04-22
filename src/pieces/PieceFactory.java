package pieces;

import board.Board;
import movements.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PieceFactory  {

    public Piece getPiece(String[] result, String position, Board board) {
        String color = result[0];

        if (result[1].equals("pawn")) {
            List<Move> list = new ArrayList<Move>();
            list.add(new PawnMovements());
            return new Piece(position, color, board, list);
        }
        if (result[1].equals("knight")) {
            List<Move> listKnight = new ArrayList<Move>();
            listKnight.add(new KnightMovements());
            return new Piece(position, color, board, listKnight);
        }
        if (result[1].equals("bishop")) {
            List<Move> listBishop = new ArrayList<Move>();
            listBishop.add(new DiagonalMovements());
            return new Piece(position, color, board, listBishop);
        }
       if (result[1].equals("rook")) {
           List<Move> listRook= new ArrayList<Move>();
           listRook.add(new StraightMovements());
            return new Piece(position, color, board, listRook);
       }
        if (result[1].equals("king")) {
            List<Move> listKing= new ArrayList<Move>();
            listKing.add(new KingMovements());
            return new Piece(position, color, board, listKing);
        }
        if (result[1].equals("queen")) {
            List<Move> listQueen= new ArrayList<Move>();
            listQueen.add(new StraightMovements());
            listQueen.add(new DiagonalMovements());
            return new Piece(position, color, board, listQueen);
        }
        throw new Error("No piece found!!! BAD ERROR");
    }

}
