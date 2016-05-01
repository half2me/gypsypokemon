package iitema.gypsypokemon.model;

import iitema.gypsypokemon.model.Direction;

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
     * Executes operation when the Item is picked up
     *
     * @return if the Item can be picked up
     */
    boolean pickUp();

    /**
     * @return Weight of the item
     */
    float getWeight();

    /**
     * Return the name of the sprite
     *
     * @return name of the sprite
     */
    String sprite();
}
