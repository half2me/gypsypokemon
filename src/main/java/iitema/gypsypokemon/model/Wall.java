package iitema.gypsypokemon.model;

import iitema.gypsypokemon.Log;

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
    protected boolean solid(Direction side) {
        return true;
    }

    @Override
    public boolean shootAt(Color color, Direction dir) {
        Log.println("Wall stopped the projectile");
        return true;
    }

    @Override
    public boolean stepOn(Direction dir, PlayerInterface player) {
        Log.println("Player" + player.getId() + " couldn't move " + dir.toString() + " to Wall");
        return super.stepOn(dir, player);
    }
}
