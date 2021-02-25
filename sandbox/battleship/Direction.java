package sandbox.battleship;

import java.awt.*;

public enum Direction {
    UP(0,-1), DOWN(0, 1), LEFT(-1, 0), RIGHT(1, 0);

    public final Point value;

    Direction(int x, int y) {
        this.value = new Point(x, y);
    }
}
