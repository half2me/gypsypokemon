package iitema.gypsypokemon.model;

import iitema.gypsypokemon.Reflector;

public class Wall extends SimpleField{

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
}