package movements;

import board.Board;
import pieces.Piece;
import pieces.PieceFactory;

import java.util.HashMap;
import java.util.Map;

public class isKingInCheck {

    public boolean isInCheck(Board board, String color) {
       String kingPosition = board.getPiecePosition(color + "-king");
        if(canEatKing(kingPosition, board, color)){
           return true;
        }
       return false;
    }

    private boolean canEatKing(String kingPosition, Board board, String color) {
        HashMap<String, String> board_dict = board.getBoard();
        for (Map.Entry<String, String> entry : board_dict.entrySet()) {
                String position = entry.getKey();
                String pieceName = entry.getValue();
                PieceFactory pieceFactory = new PieceFactory();
                String[] result = pieceName.split("-");
                if(!result[0].equals(color)) {
                    Piece piece = pieceFactory.getPiece(result, position, board);
                    if (piece.canMove(kingPosition)) {
                        return true;
                    }
                }
        }
        return false;
    }

}
