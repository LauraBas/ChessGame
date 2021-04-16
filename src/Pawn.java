import java.util.HashMap;

import static java.lang.Integer.parseInt;

public class Pawn implements Piece {
    String movement;
    String position;

    public Pawn(String position, String movement) {
        this.position = position;
        this.movement = movement;
    }

    public boolean move(HashMap<String, String> board_dict) {
       String[] position =  this.position.split("");
       String x = position[0];
       int y = parseInt(position[1]);
       String[] movement =  this.movement.split("");
       String xMov = movement[0];
       int yMov =  parseInt(movement[1]);

       if ((x.equals(xMov)) && (yMov - y == 1)){
            return true;
       } else {
           return false;
       }
    }


}
