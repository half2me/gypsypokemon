package iitema.gypsypokemon.elements;

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
}