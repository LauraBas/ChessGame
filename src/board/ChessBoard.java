package board;

import movements.isKingInCheck;
import pieces.Piece;
import pieces.PieceFactory;

import java.util.HashMap;
import java.util.Objects;

public class ChessBoard implements Board {
    private HashMap<String, String> board_dict;

    public ChessBoard() {
        board_dict = new HashMap<>();
    }

    public String show(String position) {
        if (board_dict.get(position) == null) {
            return "-";
        }
        return board_dict.get(position);
    }

    public boolean isSquareEmpty(String position) {
        return board_dict.get(position) == null;
    }

    public String getColorAtSquare(String position) {
        if (!isSquareEmpty(position)) {
            String pieceData = board_dict.get(position);
            String[] result = pieceData.split("-");
            return result[0];
        }
        return "-";
    }

    public HashMap<String, String> getBoard() {
        return board_dict;
    }

    public boolean move(String position, String movement) {
        String pieceData = board_dict.get(position);
        String[] result = pieceData.split("-");
        PieceFactory pieceFactory = new PieceFactory();
        Piece piece = pieceFactory.getPiece(result, position, this);

        if (piece.canMove(movement)) {
            board_dict.remove(position, pieceData);
            board_dict.put(movement, pieceData);
            isKingInCheck king = new isKingInCheck();
            if (king.isInCheck(this, result[0])){
                board_dict.put(position, pieceData);
                return false;
            }
            if (canConvertWhitePawnInQueen(movement, pieceData)){
                board_dict.put(movement, "white-queen");
            }
            if (canConvertBlackPawnInQueen(movement, pieceData)){
                board_dict.put(movement, "black-queen");
            }
            return true;
        } else {
            return false;
        }
    }

    public String getPiecePosition(String piece){
        for(String key : board_dict.keySet()){
            if(Objects.equals(board_dict.get(key), piece)){
                return key;
            }
        }
        return null;
    }

    public void init() {
        board_dict.put("a1", "white-rook");
        board_dict.put("b1", "white-knight");
        board_dict.put("c1", "white-bishop");
        board_dict.put("d1", "white-queen");
        board_dict.put("e1", "white-king");
        board_dict.put("f1", "white-bishop");
        board_dict.put("g1", "white-knight");
        board_dict.put("h1", "white-rook");
        board_dict.put("a2", "white-pawn");
        board_dict.put("b2", "white-pawn");
        board_dict.put("c2", "white-pawn");
        board_dict.put("d2", "white-pawn");
        board_dict.put("e2", "white-pawn");
        board_dict.put("f2", "white-pawn");
        board_dict.put("g2", "white-pawn");
        board_dict.put("h2", "white-pawn");

        board_dict.put("a8", "black-rook");
        board_dict.put("b8", "black-knight");
        board_dict.put("c8", "black-bishop");
        board_dict.put("d8", "black-queen");
        board_dict.put("e8", "black-king");
        board_dict.put("f8", "black-bishop");
        board_dict.put("g8", "black-knight");
        board_dict.put("h8", "black-rook");
        board_dict.put("a7", "black-pawn");
        board_dict.put("b7", "black-pawn");
        board_dict.put("c7", "black-pawn");
        board_dict.put("d7", "black-pawn");
        board_dict.put("e7", "black-pawn");
        board_dict.put("f7", "black-pawn");
        board_dict.put("g7", "black-pawn");
        board_dict.put("h7", "black-pawn");
    }

    public void set(String position, String piece) {
        board_dict.put(position, piece);
    }

    private boolean canConvertBlackPawnInQueen(String movement, String pieceData) {
        return pieceData == "black-pawn" && movement.charAt(1) == '1';
    }

    private boolean canConvertWhitePawnInQueen(String movement, String pieceData) {
        return pieceData == "white-pawn" && movement.charAt(1) == '8';

    }


}
