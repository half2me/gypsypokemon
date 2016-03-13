package iitema.gypsypokemon.elements.blocks;

import iitema.gypsypokemon.elements.Color;
import iitema.gypsypokemon.elements.Direction;

public class Scale extends SimpleField{

    private Door door;

    public Scale(Door door){
        this.door = door;
    }

    /**
     * Try to step on a field

     * @param dir direction the player is facing
     * @param player the player that is stepping on the field
     * @return if player moved to the field or not
     */
    @Override
    public boolean stepOn(Direction dir, PlayerInterface player) {
        if (super.stepOn(Direction dir, PlayerInterface player)) {
            this.door.open();
            return true;
        }
        return false;
    }

    /**
     * Leave a field
     */
    @Override
    public void stepOff() {
        this.door.close();
    }

    @Override
    public boolean placeOn(Direction dir, ItemInterface item) {
        if (super.placeOn(Direction dir, ItemInterface item)) {
            this.door.open();
            return true;
        }
        return false;
    }

    /**
     * Remove the item on the field (if any)
     * @return true on removed item, false if there is no item to remove
     */
    @Override
    public boolean removeItem(Direction dir) {
        if (super.removeItem(Direction dir)) {
            this.door.close();
            return true;
        }
        return false;
    }
}
