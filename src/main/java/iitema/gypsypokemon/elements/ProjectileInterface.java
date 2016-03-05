package iitema.gypsypokemon.elements;

/**
 * A projectile which can be shot
 */
public interface ProjectileInterface {
    /**
     * Color of projectile
     */
    enum ProjectileColor {YELLOW, BLUE}

    /**
     * Get the direction of a projectile
     *
     * @return direction
     */
    Direction getDirection();

    /**
     * Get the color of a projectile
     *
     * @return color
     */
    ProjectileColor getColor();
}
