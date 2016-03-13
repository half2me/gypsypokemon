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
    protected boolean solid(Direction dir) {
        if (this.openSides.get(dir)) {
            if (this.item == null) {
                return true;
            }
            return this.item.solid(dir);
        }
        return false;
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
            return super.placeOn(dir, item);
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
            return super.removeItem(dir);
        }
        return false;
    }

    /**
     * Opens a door
     */
    public void open() {
        openSides.put(this.orientation, true);
        openSides.put(this.orientation.getOpposite(), true);
    }

    /**
     * Closes a Door
     */
    public void close() {
        openSides.put(this.orientation, false);
        openSides.put(this.orientation.getOpposite(), false);
    }
}
