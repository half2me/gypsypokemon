package iitema.gypsypokemon.model;

/**
 * A block which is a field on the map
 *
 * Blocks can be places on a field
 * Fields store their 4 neighbors
 */
public interface FieldInterface{

    /**
     * Try to step on a field

     * @param dir direction the player is facing
     * @param player the player that is stepping on the field
     * @return if player moved to the field or not
     */
    boolean stepOn(Direction dir, PlayerInterface player);

    /**
     * Leave a field
     */
    void stepOff(PlayerInterface player);

    /**
     * Get a neighbor of this field

     * @param dir direction the player is facing
     * @return neighbor in the direction specified
     */
    FieldInterface getNeighbor(Direction dir);

    /**
     * Set neighbor of this field

     * @param dir direction what side the neighbor is on
     * @param field field to set as neighbor
     */
    void setNeighbor(Direction dir, FieldInterface field);

    /**
     * If an item is on this field, return reference to it

     * @param dir the direction the player is facing
     * @return an item on the field or null if none
     */
    ItemInterface getItem(Direction dir);

    /**
     * Place an item on this field if there is space

     * @param dir direction player is facing
     * @param item item to place
     * @return true if item could be placed, false if there is no space
     */
    boolean placeOn(Direction dir, ItemInterface item);

    /**
     * Remove the item on the field (if any)

     * @param dir direction player is facing
     * @return true on removed item, false if there is no item to remove
     */
    boolean removeItem(Direction dir);

    /**
     * Shoot at a field

     * @param color color of projectile
     * @param dir direction projectile is travelling
     * @return true on shot absorbed, false on shot through
     */
    boolean shootAt(Color color, Direction dir);
}
