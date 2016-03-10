package iitema.gypsypokemon.elements.blocks;

import iitema.gypsypokemon.elements.Color;
import iitema.gypsypokemon.elements.Direction;
import iitema.gypsypokemon.elements.ProjectileInterface;

public class Door implements ItemInterface{

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
        return false;
    }

    /**
     * Shoot at the item
     *
     * @param color color of the projectile
     * @param side  side to shoot at
     */
    @java.lang.Override
    public void shootAt(Color color, Direction side) {

    }
}
