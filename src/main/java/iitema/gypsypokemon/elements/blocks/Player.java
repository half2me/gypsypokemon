package iitema.gypsypokemon.elements.blocks;

import iitema.gypsypokemon.elements.Direction;
import iitema.gypsypokemon.elements.ProjectileInterface;

public class Player implements PlayerInterface{

    /**
     * Move player in a direction
     *
     * @param direction direction to move player
     */
    @Override
    public void move(Direction direction) {

    }

    /**
     * Change position of the player to a field specified
     *
     * @param field field to place player on
     */
    @Override
    public void changePostition(FieldInterface field) {

    }

    @Override
    public void shoot(Direction direction, ProjectileInterface.ProjectileColor pColor) {

    }

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
}
