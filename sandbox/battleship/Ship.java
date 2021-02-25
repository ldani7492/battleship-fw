package sandbox.battleship;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class Ship {

    private Set<Point> shipCoords;
    private Set<Point> hit;

    public Ship(int x, int y, int size, Direction direction) {
       shipCoords = new HashSet<>();
       hit = new HashSet<>();
        for (int i = 0; i < size; i++) {
            shipCoords.add(new Point(x + i*direction.value.x, y + i*direction.value.y));
        }
    }

    public Set<Point> area() {
        Set<Point> area = new HashSet<>();
        for (Point p: shipCoords) {
            area.add(p);
            area.add(new Point(p.x-1, p.y));
            area.add(new Point(p.x+1, p.y));
            area.add(new Point(p.x, p.y-1));
            area.add(new Point(p.x, p.y+1));
        }
        return area;
    }

    public boolean collidesWith(Ship other) {
        Set<Point> area = area();
        for (Point p: other.shipCoords) {
            if (area.contains(p)) {
                return true;
            }
        }
        return false;
    }

    public boolean shootAt(int x, int y) {
        Point target = new Point(x, y);
        if (shipCoords.contains(target) && !hit.contains(target)) {
            hit.add(target);
            return true;
        }
        return false;
    }

    public boolean isSunk() {
        return shipCoords.size() == hit.size();
    }

    public boolean isPartOf(int x, int y) {
        return shipCoords.contains(new Point(x, y));
    }

    public boolean isHit(int x, int y) {
        return hit.contains(new Point(x,y));
    }

    public Set<Point> getShipCoords() {
        return shipCoords;
    }
}
