package iitema.gypsypokemon.model;

import java.text.ParseException;

/**
 * Direction
 * <p/>
 * For expressing color of the projectile
 */
public enum Color {
    BLUE, YELLOW, RED, GREEN;

    private Color opposite;

    static {
        BLUE.opposite = YELLOW;
        YELLOW.opposite = BLUE;
        RED.opposite = GREEN;
        GREEN.opposite = RED;
    }

    /**
     * The opposite of a color is the one it can make a wormhole with.
     *
     * @return Opposite color
     */
    public Color getOpposite() {
        return opposite;
    }

    /**
     * Returns a Color object of the given color.
     *
     * @param color Name of the color
     * @return Color object
     * @throws ParseException
     */
    public static Color parse(String color) throws ParseException {
        if (color.toUpperCase().equals("YELLOW"))
            return Color.YELLOW;
        else if (color.toUpperCase().equals("BLUE")) {
            return Color.BLUE;
        } else {
            throw new ParseException("Invalid color", 0);
        }
    }
}