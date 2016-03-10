package iitema.gypsypokemon.elements.blocks;

import iitema.gypsypokemon.elements.Direction;
import iitema.gypsypokemon.elements.ProjectileInterface;

public class Scale implements FieldInterface{

    /**
     * Try to step on a field
     *
     * @param side   the side of the field the player is coming from
     * @param player the player that is stepping on the field
     */
    @java.lang.Override
    public void stepOn(Direction side, PlayerInterface player) {

    }

    /**
     * If an item is on this field, return reference to it
     *
     * @return an item on the field or null if none
     */
    @java.lang.Override
    public ItemInterface getItem() {
        return null;
    }

    /**
     * Get a neighbor of this field
     *
     * @param dir@return neighbor in the direction specified
     */
    @java.lang.Override
    public FieldInterface getNeighbor(Direction dir) {
        return null;
    }

    /**
     * Place an item on this field if there is space
     *
     * @param item item to place
     * @return true if item could be placed, false if there is no space
     */
    @java.lang.Override
    public boolean placeOn(ItemInterface item) {
        return false;
    }

    /**
     * Remove the item on the field (if any)
     *
     * @return true on removed item, false if there is no item to remove
     */
    @java.lang.Override
    public boolean removeItem() {
        return false;
    }
}
