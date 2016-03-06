package iitema.gypsypokemon.model;

/**
 * A player in the game
 */
public interface PlayerInterface extends ObstacleInterface {

    /**
     * Move player in a direction
     *
     * @param direction direction to move player
     */
    void move(Direction direction);

    /**
     * Change position of the player to a field specified
     *
     * @param field field to place player on
     */
    void changePostition(FieldInterface field);

    /**
     * Shoot projectile of pColor towards direction.
     *
     * @param direction direction
     * @param pColor projectile color
     */
    void shoot(Direction direction, PortalColor pColor);

    /**
     * Collects item, called by a CollectibleInterface when stepOn(...)
     *
     * @param item item to collect
     */
    void collect(CollectibleInterface item);

    /**
     * Kills the player.
     */
    void kill();
}
