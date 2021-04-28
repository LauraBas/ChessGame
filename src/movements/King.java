package movements;

import board.ChessBoard;
import pieces.Piece;
import pieces.PieceFactory;

import java.util.Map;

public class King {

    public boolean isInCheck(ChessBoard board, String color) {
       String kingPosition = board.getPiecePosition(color + "-king");
        if(canEatKing(kingPosition, board, color)){
           return true;
        }
       return false;
    }

    private boolean canEatKing(String kingPosition, ChessBoard board, String color) {
        for (Map.Entry<String, String> entry : board.board_dict.entrySet()) {
            String position = entry.getKey();
            String pieceName = entry.getValue();
            PieceFactory pieceFactory = new PieceFactory();
            String[] result = pieceName.split("-");
            Piece piece = pieceFactory.getPiece(result, position, board);
            if (piece.canMove(kingPosition)) {
                return true;
            }
        }
        return false;
        }

}
