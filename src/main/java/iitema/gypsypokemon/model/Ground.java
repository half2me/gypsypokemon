package iitema.gypsypokemon.model;

/**
 * A field the player can move on, shoot through, or place a items on it.
 */
public class Ground implements ContainerFieldInterface{
    @Override
    public void placeOn(MovableInterface movable) {

    }

    @Override
    public MovableInterface pickUp() {
        return null;
    }

    @Override
    public FieldInterface getNeighbor(Direction direction) {
        return null;
    }

    @Override
    public void stepOn(PlayerInterface player, Direction direction) {

    }

    @Override
    public void shootAt(ProjectileInterface projectile) {

    }

    @Override
    public void removeContent() {

    }
}
