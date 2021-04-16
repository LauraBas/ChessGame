import java.util.HashMap;

public class Board {
    HashMap<String, String> board_dict;

    public Board() {
        board_dict = new HashMap<>();
        board_dict.put("a1","white-rook");
        board_dict.put("b1","white-knight");
        board_dict.put("c1","white-bishop");
        board_dict.put("d1","white-queen");
        board_dict.put("e1","white-king");
        board_dict.put("f1","white-bishop");
        board_dict.put("g1","white-knight");
        board_dict.put("h1","white-rook");
        board_dict.put("a2","white-pawn");
        board_dict.put("b2","white-pawn");
        board_dict.put("c2","white-pawn");
        board_dict.put("d2","white-pawn");
        board_dict.put("e2","white-pawn");
        board_dict.put("f2","white-pawn");
        board_dict.put("g2","white-pawn");
        board_dict.put("h2","white-pawn");

        board_dict.put("a8", "black-rook");
        board_dict.put("b8", "black-knight");
        board_dict.put("c8", "black-bishop");
        board_dict.put("d8", "black-queen");
        board_dict.put("e8", "black-king");
        board_dict.put("f8", "black-bishop");
        board_dict.put("g8", "black-knight");
        board_dict.put("h8", "black-rook");
        board_dict.put("a7","black-pawn");
        board_dict.put("b7","black-pawn");
        board_dict.put("c7","black-pawn");
        board_dict.put("d7","black-pawn");
        board_dict.put("e7","black-pawn");
        board_dict.put("f7","black-pawn");
        board_dict.put("g7","black-pawn");
        board_dict.put("h7","black-pawn");

    }

    String show(String position) {
        if (board_dict.get(position) == null) {
            return "-";
        }
        return board_dict.get(position);
    }

    public boolean move(String position, String movement) {
      String piece = board_dict.get(position);
      String[] result = piece.split("-");
      String color = result[0];

      if (result[1].equals("pawn")) {
          Piece pawn = new Pawn(position, movement, color, this);
          if (pawn.move()) {
              board_dict.remove(position, piece);
              board_dict.put(movement, piece);
              return true;
          } else {
           return false;
          }
      } else {
          return false;
      }
  }



}
