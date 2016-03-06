package iitema.gypsypokemon.model;

/**
 * A block which is a field on the map
 *
 * Blocks can be places on a field
 * Fields store their 4 neighbors
 */
public interface FieldInterface extends ObstacleInterface {
    /**
     * Place a movable block on this field
     * @param movable movable block to place
     */
    void placeOn(MovableInterface movable);

    /**
     * Get a neighbor of this field
     * @param direction direction to look for the neighbor
     * @return neighbor in the direction specified
     */
    FieldInterface getNeighbor(Direction direction);
}