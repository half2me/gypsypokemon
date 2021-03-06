package iitema.gypsypokemon.model;

import iitema.gypsypokemon.Log;

public class Abyss extends SimpleField{
    @Override
    protected String defaultSprite() {
        return "abyss";
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
        Log.println("Player" + player.getId() + " moved " + dir.toString() + " into Abyss");
        player.move(this);
        player.kill();
        return true;
    }

    /**
     * Place an item on this field if there is space
     *
     * @param dir  direction player is facing
     * @param item item to place
     * @return true if item could be placed, false if there is no space
     */
    @Override
    public boolean placeOn(Direction dir, ItemInterface item) {
        Log.println(" threw Box in Abyss");
        return true;
    }

    /**
     * Return the name of the sprite
     *
     * @return name of the sprite
     */
    @Override
    public String sprite() {
        return "abyss";
    }
}
