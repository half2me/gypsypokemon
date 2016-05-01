package iitema.gypsypokemon.model;

import iitema.gypsypokemon.Log;

public class Box implements ItemInterface{
    private static float WEIGHT = 1.0f;

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
        return true;
    }

    /**
     * Executes operation when the Item is picked up
     *
     * @return if the Item can be picked up
     */
    @Override
    public boolean pickUp() {
        Log.print(" picked up Box");
        return true;
    }

    /**
     * @return Weight of the item
     */
    public float getWeight() {
        return WEIGHT;
    }

    /**
     * Return the name of the sprite
     *
     * @return name of the sprite
     */
    @Override
    public String sprite() {
        return "box";
    }
}
