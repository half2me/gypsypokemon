package iitema.gypsypokemon.elements.blocks;

import iitema.gypsypokemon.elements.Direction;
import iitema.gypsypokemon.elements.ProjectileInterface;

/**
 * A player in the game
 */
public interface PlayerInterface extends BlockInterface{

    /**
     * Move player in a direction
     *
     * @param direction direction to move player
     */
    void move(Direction direction);

    /**
     * Change position of the player to a field specified
     *
     * @param field field to place player on
     */
    void changePostition(FieldInterface field);

    /**
     * Shoot projectile of pColor towards direction.
     *
     * @param direction direction
     * @param pColor projectile color
     */
    void shoot(Direction direction, ProjectileInterface.ProjectileColor pColor);
}
