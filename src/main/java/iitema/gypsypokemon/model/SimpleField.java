package iitema.gypsypokemon.model;

import java.util.EnumMap;
import java.util.Stack;

abstract class SimpleField implements FieldInterface{

    private EnumMap<Direction, FieldInterface> neighbors = new EnumMap<Direction, FieldInterface>(Direction.class);
    Stack<ItemInterface> items = new Stack<ItemInterface>();

    /**
     * Returns solidity for item
     * If an item is solid, projectiles and players cannot walk over or step on.
     * If an item is not solid, projectiles can be shot through and players can walk over or step on.
     * @param dir direction projectile is going
     * @return solidity
     */
    synchronized protected boolean solid(Direction dir) {
        for (ItemInterface item : items) {
            if (item.solid(dir)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Get a neighbor of this field
     *
     * @param dir direction the player is facing
     * @return neighbor in the direction specified
     */
    @Override
    synchronized public FieldInterface getNeighbor(Direction dir) {
        return this.neighbors.get(dir);
    }

    /**
     * Set neighbor of this field
     *
     * @param dir   direction what side the neighbor is on
     * @param field field to set as neighbor
     */
    @Override
    synchronized public void setNeighbor(Direction dir, FieldInterface field) {
        this.neighbors.put(dir, field);
    }

    @Override
    synchronized public ItemInterface getItem(Direction dir){
        if (!items.empty()) {
            return items.peek();
        }
        return null;
    }

    @Override
    synchronized public boolean placeOn(Direction dir, ItemInterface item) {
        items.push(item);
        return true;
    }

    /**
     * Remove the item on the field (if any)
     *
     * @return true on removed item, false if there is no item to remove
     */
    @Override
    synchronized public boolean removeItem(Direction dir) {
        if (!items.empty()) {
            items.pop();
            return true;
        }
        return false;
    }

    /**
     * Shoot at a field

     * @param color color of projectile
     * @param dir direction projectile is travelling
     * @return true on shot absorbed, false on shot through
     */
    @Override
    synchronized public boolean shootAt(Color color, Direction dir) {
        for (ItemInterface item : items) {
            if (item.solid(dir)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Try to step on a field

     * @param dir direction the player is facing
     * @param player the player that is stepping on the field
     * @return if player moved to the field or not
     */
    @Override
    synchronized public boolean stepOn(Direction dir, PlayerInterface player) {
        for (ItemInterface item : items) {
            if (item.solid(dir)) {
                return false;
            }
        }
        player.move(this);
        return true;
    }

    /**
     * Leave a field
     */
    @Override
    synchronized public void stepOff(PlayerInterface player) {

    }
}
