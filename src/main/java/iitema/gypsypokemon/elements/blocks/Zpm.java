package iitema.gypsypokemon.elements.blocks;

import iitema.gypsypokemon.elements.Direction;
import iitema.gypsypokemon.elements.ProjectileInterface;

public class Zpm implements ObstacleInterface {

    /**
     * Step on a a field
     * <p>
     * When a player wants to step on this field
     *
     * @param player    player
     * @param direction direction player is moving
     */
    @Override
    public void stepOn(PlayerInterface player, Direction direction) {

    }

    /**
     * Shoot a projectile at this block
     *
     * @param projectile projectile
     */
    @Override
    public void shootAt(ProjectileInterface projectile) {

    }

    @Override
    public MovableInterface pickUp() {
        return null;
    }
}
