package iitema.gypsypokemon.elements.blocks;


import iitema.gypsypokemon.elements.Direction;

public class Ground extends SimpleField {
    /**
     * Returns solidity for item
     * If an item is solid, projectiles and players cannot walk over or step on.
     * If an item is not solid, projectiles can be shot through and players can walk over or step on.
     *
     * @param dir direction projectile is going
     * @return solidity
     */
    @Override
    public boolean solid(Direction dir) {
        if (this.item != null) {
            return this.item.solid(dir);
        }
        return false;
    }

    /**
     * Try to step on a field
     *
     * @param dir    direction the player is facing
     * @param player the player that is stepping on the field
     */
    @Override
    public void stepOn(Direction dir, PlayerInterface player) {
        if (this.item != null) {
            if(this.item.solid(dir)) {
               return;
            }
        }
        player.move(this);
    }

    /**
     * Leave a field
     */
    @Override
    public void stepOff() {

    }
}
