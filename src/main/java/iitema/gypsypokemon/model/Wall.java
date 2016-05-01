package iitema.gypsypokemon.model;

import iitema.gypsypokemon.Log;

public class Wall extends SimpleField{

    @Override
    protected String defaultSprite() {
        return "wall";
    }

    /**
     * Return the name of the sprite
     *
     * @return name of the sprite
     */
    @Override
    public String sprite() {
        return this.defaultSprite();
    }

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

    /**
     * Shoot at the wall, one cannot shoot through it
     *
     * @param color color of projectile
     * @param dir direction projectile is travelling
     * @return True, the projectile is always stopped
     */
    @Override
    public boolean shootAt(Color color, Direction dir) {
        Log.println("Wall stopped the projectile");
        return true;
    }

    /**
     * Step on the wall, one cannot step on the wall
     *
     * @param dir direction the player is facing
     * @param player the player that is stepping on the field
     * @return False, the wall cannot be stepped on
     */
    @Override
    public boolean stepOn(Direction dir, PlayerInterface player) {
        Log.println("Player" + player.getId() + " couldn't move " + dir.toString() + " to Wall");
        return false;
    }
}
