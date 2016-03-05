package iitema.gypsypokemon.elements.blocks;

import iitema.gypsypokemon.elements.Direction;
import iitema.gypsypokemon.elements.ProjectileInterface;

/**
 * A block on the map
 */
public interface BlockInterface {

    /**
     * Step on a a field
     *
     * When a player wants to step on this field
     * @param player player
     * @param direction direction player is moving
     */
    void stepOn(PlayerInterface player, Direction direction);

    /**
     * Shoot a projectile at this block
     * @param projectile projectile
     */
    void shootAt(ProjectileInterface projectile);
}
