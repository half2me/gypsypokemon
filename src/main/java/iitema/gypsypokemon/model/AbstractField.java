package iitema.gypsypokemon.model;

/**
 * Implements the getNeighbor function
 */
public abstract class AbstractField implements FieldInterface {
    private FieldInterface neighborLeft = null;
    private FieldInterface neighborUp = null;
    private FieldInterface neighborRigth = null;
    private FieldInterface neighborDown = null;

    @Override
    public FieldInterface getNeighbor(Direction direction) {
        return null;
    }
}
