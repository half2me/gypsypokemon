package iitema.gypsypokemon.elements.blocks;

import iitema.gypsypokemon.elements.Direction;

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
}
