package iitema.gypsypokemon.model;

import iitema.gypsypokemon.Reflector;

import java.util.EnumMap;

public class Door extends SimpleField {

    private EnumMap<Direction, Boolean> openSides = new EnumMap<Direction, Boolean>(Direction.class);
    private Direction orientation;

    public Door(Direction dir) {
        Reflector.start();

        this.orientation = dir;
        openSides.put(Direction.LEFT, false);
        openSides.put(Direction.RIGHT, false);
        openSides.put(Direction.DOWN, false);
        openSides.put(Direction.UP, false);

        Reflector.end();
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
        Reflector.start();

        boolean ret;

        if (Reflector.ask(dir.getOpposite().toString() + " irányból be lehet lépni az ajtóba?")) {
            if (!Reflector.ask("Van tárgy az ajtóban?")) {
                ret =  true;
            } else {
                ret =  Reflector.ask("Át lehet menni a tárgyon?");
            }

        } else {
            ret = false;
        }

        Reflector.end();
        return ret;
    }

    /**
     * If an item is on this field, return reference to it
     *
     * @param dir the direction the player is facing
     * @return an item on the field or null if none
     */
    @Override
    public ItemInterface getItem(Direction dir) {
        Reflector.start();

        ItemInterface ret;

        if (Reflector.ask(dir.getOpposite().toString() + " irányból hozzáférhető az ajtóban lévő tárgy?")) {
            ret =  this.item;
        } else {
            ret = null;
        }

        Reflector.end();
        return ret;
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
        Reflector.start();

        boolean ret;

        if (Reflector.ask(dir.getOpposite().toString() + " irányból hozzáférhető az ajtóban lévő tárgy?")) {
            ret =  super.placeOn(dir, item);
        } else {
            ret = false;
        }

        Reflector.end();
        return ret;
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

        if (Reflector.ask(dir.getOpposite().toString() + " irányból hozzáférhető az ajtóban lévő tárgy?")) {
            ret = super.removeItem(dir);
        } else {
            ret = false;
        }

        Reflector.end();
        return ret;
    }

    /**
     * Opens a door
     */
    public void open() {
        Reflector.start();

        openSides.put(this.orientation, true);
        openSides.put(this.orientation.getOpposite(), true);

        Reflector.end();
    }

    /**
     * Closes a Door
     */
    public void close() {
        Reflector.start();

        openSides.put(this.orientation, false);
        openSides.put(this.orientation.getOpposite(), false);

        Reflector.end();
    }
}
