import java.util.HashMap;

import static java.lang.Integer.parseInt;

public class Pawn implements Piece {
    String movement;
    String position;
    String color;

    public Pawn(String position, String movement, String color) {
        this.position = position;
        this.movement = movement;
        this.color = color;
    }

    public boolean move() {
       String[] position =  this.position.split("");
       String x = position[0];
       int y = parseInt(position[1]);
       String[] movement =  this.movement.split("");
       String xMov = movement[0];
       int yMov =  parseInt(movement[1]);

       if (this.color.equals("white")) {
           if((x.equals(xMov)) && y == 2 && yMov == 4) {
               return true;
           }
           else if ((x.equals(xMov)) && (yMov - y == 1)){
                return true;
           } else {
               return false;
           }
       } else {
           if((x.equals(xMov)) && y == 7 && yMov == 5) {
               return true;
           }
           else if ((x.equals(xMov)) && (y - yMov == 1)){
               return true;
           } else {
               return false;
           }
       }
    }


}
