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
     * Try to step on a field
     * @param side the side of the field the player is coming from
     * @param player the player that is stepping on the field
     */
    void stepOn(Direction side, PlayerInterface player);

    /**
     * If an item is on this field, return reference to it
     * @return an item on the field or null if none
     */
    ItemInterface getItem();

    /**
     * Get a neighbor of this field
     * @param direction direction to look for the neighbor
     * @return neighbor in the direction specified
     */
    FieldInterface getNeighbor(Direction dir);

    /**
     * Place an item on this field if there is space
     * @param item item to place
     * @return true if item could be placed, false if there is no space
     */
    boolean placeOn(ItemInterface item);

    /**
     * Remove the item on the field (if any)
     * @return true on removed item, false if there is no item to remove
     */
    boolean removeItem();
}