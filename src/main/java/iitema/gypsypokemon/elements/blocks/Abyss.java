package iitema.gypsypokemon.elements.blocks;

import iitema.gypsypokemon.elements.Color;
import iitema.gypsypokemon.elements.Direction;

public class Abyss extends SimpleField{
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
        return false;
    }

    /**
     * Try to step on a field

     * @param dir direction the player is facing
     * @param player the player that is stepping on the field
     * @return if player moved to the field or not
     */
    @Override
    public boolean stepOn(Direction dir, PlayerInterface player) {
        player.kill();
        return super.stepOn(dir, player);
    }
}
