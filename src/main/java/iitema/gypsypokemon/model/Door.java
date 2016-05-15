package iitema.gypsypokemon.model;

import iitema.gypsypokemon.Log;

import java.util.EnumMap;

public class Door extends SimpleField {

    private EnumMap<Direction, Boolean> openSides = new EnumMap<Direction, Boolean>(Direction.class);
    private Direction orientation;

    /**
     * Creates a door facing the given direction.
     *
     * @param dir Direction the door is facing
     */
    public Door(Direction dir) {
        this.orientation = dir;
        openSides.put(Direction.LEFT, false);
        openSides.put(Direction.RIGHT, false);
        openSides.put(Direction.DOWN, false);
        openSides.put(Direction.UP, false);
    }

    @Override
    protected String defaultSprite() {
        return "door-" + (this.openSides.get(orientation) ? "open-" : "closed-") + this.orientation.toString().toLowerCase();
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
    synchronized protected boolean solid(Direction dir) {
        if (this.openSides.get(dir)) {
            for (ItemInterface item : items) {
                if (item.solid(dir)) {
                    return true;
                }
            }
            return false;
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
    synchronized public ItemInterface getItem(Direction dir) {
        if (this.openSides.get(dir) && !items.empty()) {
            return items.peek();
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
    synchronized public boolean placeOn(Direction dir, ItemInterface item) {
        if (this.openSides.get(dir)) {
            boolean ret = super.placeOn(dir, item);
            if (ret) Log.println(" placed Box in Door");
            return ret;
        }
        return false;
    }

    /**
     * Remove the item on the field (if any)
     *
     * @return true on removed item, false if there is no item to remove
     */
    @Override
    synchronized public boolean removeItem(Direction dir) {
        if (this.openSides.get(dir)) {
            Log.println(" from Door");
            return super.removeItem(dir);
        }
        return false;
    }

    /**
     * Opens a door
     */
    void open() {
        openSides.put(this.orientation, true);
        openSides.put(this.orientation.getOpposite(), true);
        Log.println("Door opened");
    }

    /**
     * Closes a Door
     */
    void close() {
        openSides.put(this.orientation, false);
        openSides.put(this.orientation.getOpposite(), false);
        Log.println("Door closed");
    }

    /**
     * Same as in SimpleField, only used for logging
     */
    @Override
    synchronized public boolean stepOn(Direction dir, PlayerInterface player) {
        boolean ret = false;
        if (openSides.get(dir) && super.stepOn(dir, player)) {
            ret = true;
        }

        if (ret) Log.println("Player" + player.getId() + " moved " + dir.toString() + " in Door");
        else Log.println("Player" + player.getId() + " couldn't move " + dir.toString() + " in Door");
        return ret;
    }
}
