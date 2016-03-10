package iitema.gypsypokemon.elements.blocks;

import iitema.gypsypokemon.elements.Direction;

/**
 * A block which is a field on the map
 *
 * Blocks can be places on a field
 * Fields store their 4 neighbors
 */
public interface FieldInterface{
    /**
     * Returns solidity for item
     * If an item is solid, projectiles and players cannot walk over or step on.
     * If an item is not solid, projectiles can be shot through and players can walk over or step on.
     * @param dir direction projectile is going
     * @return solidity
     */
    boolean solid(Direction dir);

    /**
     * Try to step on a field
     * @param dir direction the player is facing
     * @param player the player that is stepping on the field
     */
    void stepOn(Direction dir, PlayerInterface player);

    /**
     * Leave a field
     */
    void stepOff();

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
}