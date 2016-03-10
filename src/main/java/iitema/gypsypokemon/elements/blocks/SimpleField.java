package iitema.gypsypokemon.elements.blocks;

import iitema.gypsypokemon.elements.Color;
import iitema.gypsypokemon.elements.Direction;

import java.util.EnumMap;

public abstract class SimpleField implements FieldInterface{

    protected EnumMap<Direction, FieldInterface> neighbors = new EnumMap<Direction, FieldInterface>(Direction.class);
    protected ItemInterface item;

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
        return this.item;
    }

    @Override
    public boolean placeOn(Direction dir, ItemInterface item) {
        if(this.item == null) {
            this.item = item;
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
        return true;
    }

    /**
     * Shoot at a field
     *
     * @param color color of projectile
     * @param dir   direction projectile is travelling
     */
    @Override
    public void shootAt(Color color, Direction dir) {

    }
}
