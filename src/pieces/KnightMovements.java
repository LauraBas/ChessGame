package pieces;

import board.Board;

import static java.lang.Integer.parseInt;

public class KnightMovements implements Move {
    @Override
    public boolean isMovementAllowed(String position, String movement, Board board, String color) {

        String[] positionData;
        positionData = position.split("");
        char x = positionData[0].charAt(0);
        int y = parseInt(positionData[1]);
        String[] movementData = movement.split("");
        char xMov = movementData[0].charAt(0);
        int yMov = parseInt(movementData[1]);

        return canMove(board, movement, x, xMov, y, yMov,color);
    }

        public boolean canMove (Board board, String movement, char x, char xMov, int y, int yMov, String color ){
            return isPositionAvailable(board, movement, x, xMov, y, yMov) || canEat(board, movement,color, x, xMov, y, yMov);

        }
        private boolean isPositionAvailable (Board board, String movement, char x, char xMov, int y, int yMov){
            return board.isSquareEmpty(movement) && isMovementAllowed(x, xMov, y, yMov);
        }

        public boolean canEat (Board board, String movement, String color,char x, char xMov, int y, int yMov){
            return (isOpponentInDestination(board, movement, color) && isMovementAllowed(x, xMov, y, yMov));

        }


        private boolean isMovementAllowed(char x, char xMov, int y, int yMov) {
            if (y - yMov == -1 && x - xMov == -2) {
                return true;
            }
            if (y - yMov == -1 && x - xMov == 2) {
                return true;
            }
            if (y - yMov == 1 && x - xMov == -2) {
                return true;
            }
            if (y - yMov == 1 && x - xMov == 2) {
                return true;
            }
            if (y - yMov == -2 && x - xMov == 1) {
                return true;
            }
            if (y - yMov == -2 && x - xMov == -1) {
                return true;
            }
            if (y - yMov == 2 && x - xMov == 1) {
                return true;
            }
            return y - yMov == 2 && x - xMov == -1;
        }

        public boolean isOpponentInDestination(Board board, String movement, String color) {
            return !board.getColorAtSquare(movement).equals(color);
        }
    }
