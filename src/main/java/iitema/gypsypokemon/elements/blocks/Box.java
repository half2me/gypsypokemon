package iitema.gypsypokemon.elements.blocks;

import iitema.gypsypokemon.Reflector;
import iitema.gypsypokemon.elements.Direction;

public class Box implements ItemInterface{
    /**
     * Returns solidity for item
     * If an item is solid, projectiles and players cannot walk over or step on.
     * If an item is not solid, projectiles can be shot through and players can walk over or step on.
     *
     * @param side side of the item to check
     * @return solidity
     */
    @java.lang.Override
    public boolean solid(Direction side) {
        Reflector.start();
        Reflector.end();

        return true;
    }

    /**
     * Executes operation when the Item is picked up
     *
     * @return if the Item can be picked up
     */
    @Override
    public boolean pickUp() {
        Reflector.start();
        Reflector.end();

        return true;
    }
}
