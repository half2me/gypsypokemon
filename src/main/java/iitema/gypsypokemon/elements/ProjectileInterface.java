package iitema.gypsypokemon.elements;

/**
 * A projectile which can be shot
 */
public interface ProjectileInterface {

    /**
     * Get the direction of a projectile
     *
     * @return direction
     */
    public int getDirection();

    /**
     * Get the color of a projectile
     *
     * @return color
     */
    public int getColor();
}
