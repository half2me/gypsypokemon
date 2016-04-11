package iitema.gypsypokemon.model;

import java.text.ParseException;

/**
 * Direction
 * <p/>
 * For expressing color of the projectile
 */
public enum Color {
    BLUE, YELLOW;

    private Color opposite;

    static {
        BLUE.opposite = YELLOW;
        YELLOW.opposite = BLUE;
    }

    public Color getOpposite() {
        return opposite;
    }

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