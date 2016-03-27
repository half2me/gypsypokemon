package iitema.gypsypokemon.model;

import iitema.gypsypokemon.Reflector;

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
        Reflector.start();

        boolean ret;

        if(Reflector.ask("Van a mezőn tárgy?")) {
            ret =  this.item.solid(dir);
        } else {
            ret = false;
        }

        Reflector.end();
        return ret;
    }

    /**
     * Get a neighbor of this field
     *
     * @param dir direction the player is facing
     * @return neighbor in the direction specified
     */
    @Override
    public FieldInterface getNeighbor(Direction dir) {
        Reflector.start();
        Reflector.end();
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
        Reflector.start();
        Reflector.end();
        this.neighbors.put(dir, field);
    }

    @Override
    public ItemInterface getItem(Direction dir){
        Reflector.start();
        Reflector.end();
        return this.item;
    }

    @Override
    public boolean placeOn(Direction dir, ItemInterface item) {
        Reflector.start();

        boolean ret;

        if (!Reflector.ask("Van a mezőn tárgy?")) {
            this.item = item;
            ret =  true;
        } else {
            ret = false;
        }

        Reflector.end();
        return  ret;
    }

    /**
     * Remove the item on the field (if any)
     *
     * @return true on removed item, false if there is no item to remove
     */
    @Override
    public boolean removeItem(Direction dir) {
        Reflector.start();

        boolean ret;

        if (!Reflector.ask("Van a mezőn tárgy?")) {
            ret =  false;
        } else {
            this.item = null;
            ret =  true;
        }

        Reflector.end();
        return ret;
    }

    /**
     * Shoot at a field

     * @param color color of projectile
     * @param dir direction projectile is travelling
     * @return true on shot absorbed, false on shot through
     */
    @Override
    public boolean shootAt(Color color, Direction dir) {
        Reflector.start();
        Reflector.end();
        return this.solid(dir);
    }

    /**
     * Try to step on a field

     * @param dir direction the player is facing
     * @param player the player that is stepping on the field
     * @return if player moved to the field or not
     */
    @Override
    public boolean stepOn(Direction dir, PlayerInterface player) {
        Reflector.start();

        boolean ret;

        if(Reflector.ask(dir.getOpposite().toString() + " irányból rá lehet lépni a mezőre?")) {
            player.move(this);
            ret =  true;
        } else {
            ret = false;
        }

        Reflector.end();
        return ret;
    }

    /**
     * Leave a field
     */
    @Override
    public void stepOff() {
        Reflector.start();
        Reflector.end();
    }
}