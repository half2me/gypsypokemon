package iitema.gypsypokemon.elements.blocks;

import iitema.gypsypokemon.elements.Color;
import iitema.gypsypokemon.elements.Direction;

public interface ItemInterface {
    /**
     * Returns solidity for item
     * If an item is solid, projectiles and players cannot walk over or step on.
     * If an item is not solid, projectiles can be shot through and players can walk over or step on.
     * @param side side of the item to check
     * @return solidity
     */
    boolean solid(Direction side);

    /**
     * Shoot at the item
     * @param color color of the projectile
     * @param side side to shoot at
     */
    void shootAt(Color color, Direction side);

    /**
     * Executes operation when the Item is picked up
     *
     * @return if the Item can be picked up
     */
    boolean pickUp();
}
