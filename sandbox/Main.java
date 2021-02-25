package sandbox;

import sandbox.battleship.Board;
import sandbox.battleship.Ship;

import static sandbox.battleship.Direction.*;

public class Main {
    public static void main(String... args) {
        Board player1 = new Board(10);

        player1.addShip(new Ship(5, 7, 4, LEFT));
        player1.addShip(new Ship(0,0, 3, RIGHT));
        player1.addShip(new Ship(4, 1, 2, DOWN));
        player1.addShip(new Ship(9, 3, 1, UP));
        player1.addShip(new Ship(0, 1, 2, DOWN));

        player1.shootAt(4,1);
        player1.shootAt(4,2);
        player1.shootAt(1,0);

        player1.drawBoard();
    }
}
