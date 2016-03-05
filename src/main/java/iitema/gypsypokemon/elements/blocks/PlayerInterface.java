package iitema.gypsypokemon.elements.blocks;

/**
 * A player in the game
 */
public interface PlayerInterface extends BlockInterface{

    /**
     * Move player in a direction
     *
     * @param direction direction to move player
     */
    public void move(int direction);

    /**
     * Change position of the player to a field specified
     *
     * @param field field to place player on
     */
    public void changePostition(FieldInterface field);
}
