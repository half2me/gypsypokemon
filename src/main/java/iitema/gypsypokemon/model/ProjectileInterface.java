package iitema.gypsypokemon.model;

/**
 * A projectile which can be shot
 */
public interface ProjectileInterface {

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
    PortalColor getColor();
}
