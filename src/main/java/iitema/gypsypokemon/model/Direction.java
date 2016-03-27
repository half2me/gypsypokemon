package iitema.gypsypokemon.model;

/**
 * Direction
 *
 * For expressing direction of movement
 */
public enum Direction {
    LEFT, RIGHT, UP, DOWN;

    private Direction opposite;
    private String name;

    static {
        LEFT.opposite = RIGHT;
        RIGHT.opposite = LEFT;
        UP.opposite = DOWN;
        DOWN.opposite = UP;

        LEFT.name = "Bal";
        RIGHT.name = "Jobb";
        UP.name = "Fenti";
        DOWN.name = "Lenti";
    }

    public Direction getOpposite() {
        return opposite;
    }

    @Override
    public String toString() {
        return name;
    }

}