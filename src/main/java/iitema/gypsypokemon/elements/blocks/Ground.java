package iitema.gypsypokemon.elements.blocks;

import iitema.gypsypokemon.elements.Direction;
import iitema.gypsypokemon.elements.ProjectileInterface;

/**
 * A field the player can move on, shoot through, or place a items on it.
 */
public class Ground implements FieldInterface{
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
}
