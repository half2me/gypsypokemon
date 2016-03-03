package iitema.gypsypokemon.elements.blocks;

import iitema.gypsypokemon.elements.ProjectileInterface;

public interface BlockInterface {
    /**
     * Step on a a field
     *
     * When a player wants to change move to this field
     * @param player player
     * @param direction direction player is moving
     */
    public void stepOn(PlayerInterface player, int direction);

    /**
     * Shoot a projectile at a block
     * @param projectile projectile
     */
    public void shootAt(ProjectileInterface projectile);
}
