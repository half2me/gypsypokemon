package iitema.gypsypokemon.model;

import java.text.ParseException;

/**
 * Direction
 *
 * For expressing direction of movement
 */
public enum Direction {
    LEFT, RIGHT, UP, DOWN;

    private Direction opposite;

    static {
        LEFT.opposite = RIGHT;
        RIGHT.opposite = LEFT;
        UP.opposite = DOWN;
        DOWN.opposite = UP;
    }

    public Direction getOpposite() {
        return opposite;
    }

    public static Direction parse(String dir) throws ParseException {
        if (dir.toUpperCase().equals("LEFT")) {
            return Direction.LEFT;
        } else if (dir.toUpperCase().equals("RIGHT")) {
            return Direction.RIGHT;
        } else if (dir.toUpperCase().equals("DOWN")) {
            return Direction.DOWN;
        } else if (dir.toUpperCase().equals("UP")) {
            return Direction.UP;
        } else {
            throw new ParseException("Invalid direction", 0);
        }
    }
}