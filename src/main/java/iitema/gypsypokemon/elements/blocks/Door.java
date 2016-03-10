package iitema.gypsypokemon.elements.blocks;

import iitema.gypsypokemon.elements.Color;
import iitema.gypsypokemon.elements.Direction;

import java.util.ArrayList;
import java.util.EnumMap;

public class Door extends SimpleField {

    private EnumMap<Direction, Boolean> openSides = new EnumMap<Direction, Boolean>(Direction.class);
    private Direction orientation;

    public Door(Direction dir) {
        this.orientation = dir;
        openSides.put(Direction.LEFT, false);
        openSides.put(Direction.RIGHT, false);
        openSides.put(Direction.DOWN, false);
        openSides.put(Direction.UP, false);
    }

    /**
     * Returns solidity for item
     * If an item is solid, projectiles and players cannot walk over or step on.
     * If an item is not solid, projectiles can be shot through and players can walk over or step on.
     *
     * @param dir direction projectile is going
     * @return solidity
     */
    @Override
    public boolean solid(Direction dir) {
        return this.openSides.get(dir);
    }

    /**
     * Try to step on a field
     *
     * @param dir    direction the player is facing
     * @param player the player that is stepping on the field
     */
    @Override
    public void stepOn(Direction dir, PlayerInterface player) {
        if (this.openSides.get(dir)) {
            player.move(this);
        }
    }

    /**
     * Leave a field
     */
    @Override
    public void stepOff() {

    }

    /**
     * If an item is on this field, return reference to it
     *
     * @param dir the direction the player is facing
     * @return an item on the field or null if none
     */
    @Override
    public ItemInterface getItem(Direction dir) {
        if (this.openSides.get(dir)) {
            return this.item;
        }
        return null;
    }

    /**
     * Place an item on this field if there is space
     *
     * @param dir  direction player is facing
     * @param item item to place
     * @return true if item could be placed, false if there is no space
     */
    @Override
    public boolean placeOn(Direction dir, ItemInterface item) {
        if (this.openSides.get(dir)) {
            this.item = item;
            return true;
        }
        return false;
    }

    /**
     * Remove the item on the field (if any)
     *
     * @return true on removed item, false if there is no item to remove
     */
    @Override
    public boolean removeItem(Direction dir) {
        if (this.openSides.get(dir)) {
            if (this.item != null) {
                this.item = null;
                return true;
            }
        }
        return false;
    }

    /**
     * Opens a door from both sides
     */
    public void open() {
        openSides.put(this.orientation, true);
        openSides.put(this.orientation.getOpposite(), true);
    }

    public void close() {
        openSides.put(this.orientation, false);
        openSides.put(this.orientation.getOpposite(), false);
    }
}
