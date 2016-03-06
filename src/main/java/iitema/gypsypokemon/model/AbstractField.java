package iitema.gypsypokemon.model;

/**
 * Implements the getNeighbor function
 */
public abstract class AbstractField implements FieldInterface {
    @Override
    public FieldInterface getNeighbor(Direction direction) {
        return null;
    }
}
