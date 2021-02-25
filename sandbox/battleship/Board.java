package sandbox.battleship;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class Board {
    private int size;
    private Set<Ship> ships;
    private Set<Ship> sunk;

    public Board(int size) {
        this.size = size;
        ships = new HashSet<>();
        sunk = new HashSet<>();
    }

    public boolean addShip(Ship ship) {
        for (Point p: ship.getShipCoords()) {
            if (p.x < 0 || p.x >= size || p.y < 0 || p.y >= size) {
                return false;
            }
        }
        for (Ship s: ships) {
            if (ship.collidesWith(s)) {
                return false;
            }
        }
        ships.add(ship);
        return true;
    }

    public boolean shootAt(int x, int y) {
        for (Ship ship: ships) {
            if (ship.shootAt(x, y)) {
                if (ship.isSunk()) {
                    ships.remove(ship);
                    sunk.add(ship);
                }
                return true;
            }
        }
        return false;
    }

    public boolean isOver() {
        return ships.isEmpty();
    }

    private Ship getShip(int x, int y) {
        for (Ship ship: ships) {
            if (ship.isPartOf(x,y)) {
                return ship;
            }
        }
        return null;
    }

    private boolean isSunk(int x, int y) {
        for (Ship ship: sunk) {
            if (ship.isPartOf(x,y)) {
                return true;
            }
        }
        return false;
    }

    public void drawBoard() {
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < size; y++) {
            sb.append('\n');
            for (int x = 0; x < size; x++) {
                sb.append(' ');
                Ship ship = getShip(x,y);
                if (ship != null) {
                    if (ship.isHit(x,y)) {
                        sb.append('*');
                    }
                    else {
                        sb.append('O');
                    }
                } else if (isSunk(x,y)) {
                    sb.append('X');
                } else {
                    sb.append('.');
                }
            }
        }
        System.out.println(sb.toString());
    }
}
