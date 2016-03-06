package iitema.gypsypokemon.model;

/**
 * A block on the map
 */
public interface ObstacleInterface {

    /**
     * Step on a a field
     *
     * When a player wants to step on this field
     * @param player player
     * @param direction direction player is moving
     */
    void stepOn(PlayerInterface player, Direction direction);

    /**
     * Shoot a projectile at this block
     * @param projectile projectile
     */
    void shootAt(ProjectileInterface projectile);

    /**
     * Pickup a movable block from this field
     * @return a movable block which is on this field
     */
    MovableInterface pickUp();
}
