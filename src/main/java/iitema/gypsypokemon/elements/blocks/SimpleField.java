package iitema.gypsypokemon.elements.blocks;

import iitema.gypsypokemon.elements.Color;
import iitema.gypsypokemon.elements.Direction;

import java.util.EnumMap;

public abstract class SimpleField implements FieldInterface{

    protected EnumMap<Direction, FieldInterface> neighbors = new EnumMap<Direction, FieldInterface>(Direction.class);
    protected ItemInterface item;

    /**
     * Returns solidity for item
     * If an item is solid, projectiles and players cannot walk over or step on.
     * If an item is not solid, projectiles can be shot through and players can walk over or step on.
     * @param dir direction projectile is going
     * @return solidity
     */
    protected boolean solid(Direction dir) {
        return false;
    }

    /**
     * Get a neighbor of this field
     *
     * @param dir direction the player is facing
     * @return neighbor in the direction specified
     */
    @Override
    public FieldInterface getNeighbor(Direction dir) {
        return this.neighbors.get(dir);
    }

    /**
     * Set neighbor of this field
     *
     * @param dir   direction what side the neighbor is on
     * @param field field to set as neighbor
     */
    @Override
    public void setNeighbor(Direction dir, FieldInterface field) {
        this.neighbors.put(dir, field);
    }

    @Override
    public ItemInterface getItem(Direction dir){
        if(!this.solid(dir)) {
            return this.item;
        }
        return null;
    }

    @Override
    public boolean placeOn(Direction dir, ItemInterface item) {
        if(this.solid(dir) && this.item == null){
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
        if(!this.solid(dir) && this.item != null){
            this.item = null;
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
    public boolean shootAt(Color color, Direction dir) {
        if(this.solid(dir) || this.item.solid(dir)){
            return true;
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
    public boolean stepOn(Direction dir, PlayerInterface player) {
        if(!this.solid(dir) && this.item == null){
            player.move(this);
            return true;
        }
        return false;
    }

    /**
     * Leave a field
     */
    @Override
    public void stepOff() {

    }
}
