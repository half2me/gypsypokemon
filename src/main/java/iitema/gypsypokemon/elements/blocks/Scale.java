package iitema.gypsypokemon.elements.blocks;

import iitema.gypsypokemon.elements.Color;
import iitema.gypsypokemon.elements.Direction;

public class Scale extends SimpleField{

    private Door door;

    public Scale(Door door){
        this.door = door;
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
        return false;
    }

    /**
     * Try to step on a field
     *
     * @param dir    direction the player is facing
     * @param player the player that is stepping on the field
     */
    @Override
    public void stepOn(Direction dir, PlayerInterface player) {
        this.door.open();
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
        if(this.item == null) {
            this.item = item;
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
    public boolean removeItem(Direction dir){
        if(this.item == null) {
            return false;
        }
        this.item = null;
        this.door.close();
        return true;
    }
}
