package iitema.gypsypokemon.model;

import iitema.gypsypokemon.Reflector;

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
        Reflector.start();

        boolean ret;

        if (super.stepOn(dir, player)) {
            this.door.open();
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

        this.door.close();

        Reflector.end();
    }

    @Override
    public boolean placeOn(Direction dir, ItemInterface item) {
        Reflector.start();

        boolean ret;

        if (super.placeOn(dir, item)) {
            this.door.open();
            ret =  true;
        } else {
            ret = false;
        }

        Reflector.end();
        return ret;
    }

    /**
     * Remove the item on the field (if any)
     * @return true on removed item, false if there is no item to remove
     */
    @Override
    public boolean removeItem(Direction dir) {
        Reflector.start();

        boolean ret;

        if (super.removeItem(dir)) {
            this.door.close();
            ret =  true;
        } else {
            ret = false;
        }

        Reflector.end();
        return ret;
    }
}
