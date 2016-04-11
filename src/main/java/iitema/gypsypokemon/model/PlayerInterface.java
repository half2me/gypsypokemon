package iitema.gypsypokemon.model;

/**
 * A player in the game
 */
public interface PlayerInterface{

    /**
     * Move player to a field
     *
     * @param field direction to move player
     */
    void move(FieldInterface field);

    /**
     * Turn or move in a direction
     * If the player is facing in a different direction, this will turn him around
     * If the player is facing in the same direction, the player will move one block
     * @param dir direction
     */
    void step(Direction dir);

    /**
     * Try to pickup an item from the field in front of the player if hands are empty, or
     * Try to put down an item on the field in front of the player if hands are full.
     */
    void action();

    /**
     * Shoots in the direction the player is facing
     * @param color color of the projectile
     */
    void shoot(Color color);

    /**
     * Kills the player
     */
    void kill();

    int getId();
}
