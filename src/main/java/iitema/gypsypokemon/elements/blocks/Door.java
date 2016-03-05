package iitema.gypsypokemon.elements.blocks;

import iitema.gypsypokemon.elements.ProjectileInterface;

public class Door implements FieldInterface{

    /**
     * Place a movable block on this field
     *
     * @param movable movable block to place
     */
    @Override
    public void placekOn(MovableInterface movable) {

    }

    /**
     * Pickup a movable block from this field
     *
     * @return a movable block which is on this field
     */
    @Override
    public MovableInterface pickUp() {
        return null;
    }

    /**
     * Get a neighbor of this field
     *
     * @param direction direction to look for the neighbor
     * @return neighbor in the direction specified
     */
    @Override
    public FieldInterface getNeighbor(int direction) {
        return null;
    }

    /**
     * Step on a a field
     * <p>
     * When a player wants to step on this field
     *
     * @param player    player
     * @param direction direction player is moving
     */
    @Override
    public void stepOn(PlayerInterface player, int direction) {

    }

    /**
     * Shoot a projectile at this block
     *
     * @param projectile projectile
     */
    @Override
    public void shootAt(ProjectileInterface projectile) {

    }
}
