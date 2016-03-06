package iitema.gypsypokemon.model;

/**
 * A field the player can move on, shoot through, or place a items on it.
 */
public class Ground extends AbstractContainerField{
    @Override
    public void placeOn(MovableInterface movable) {

    }

    @Override
    public MovableInterface pickUp() {
        return null;
    }

    @Override
    public void stepOn(PlayerInterface player, Direction direction) {

    }
}
