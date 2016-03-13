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
        return this.openSides.get(dir);
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
