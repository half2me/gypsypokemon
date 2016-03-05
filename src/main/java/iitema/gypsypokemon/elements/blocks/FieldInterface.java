package iitema.gypsypokemon.elements.blocks;

/**
 * A block which is a field on the map
 *
 * Blocks can be places on a field
 * Fields store their 4 neighbors
 */
public interface FieldInterface extends BlockInterface{
    /**
     * Place a movable block on this field
     * @param movable movable block to place
     */
    public void placekOn(MovableInterface movable);

    /**
     * Pickup a movable block from this field
     * @return a movable block which is on this field
     */
    public MovableInterface pickUp();

    /**
     * Get a neighbor of this field
     * @param direction direction to look for the neighbor
     * @return neighbor in the direction specified
     */
    public FieldInterface getNeighbor(int direction);
}