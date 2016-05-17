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
    private static Direction[] all = null;

    static {
        LEFT.opposite = RIGHT;
        RIGHT.opposite = LEFT;
        UP.opposite = DOWN;
        DOWN.opposite = UP;
    }

    /**
     * @return Opposite direction
     */
    public Direction getOpposite() {
        return opposite;
    }

    /**
     * Parses the color string and makes a color object out of it.
     *
     * @param dir direction string
     * @return Direction object
     * @throws ParseException
     */
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

    /**
     *
     * @return Array containing all 4 directions
     */
    public static Direction[] all(){
        if (all == null) {
            all = new Direction[4];
            all[0] = Direction.LEFT;
            all[1] = Direction.RIGHT;
            all[2] = Direction.UP;
            all[3] = Direction.DOWN;
        }
        return all;
    }
}