package iitema.gypsypokemon.model;

public class Door extends AbstractContainerField{
    private boolean open = false;

    /**
     * Place a movable block on this field
     *
     * @param movable movable block to place
     */
    @Override
    public void placeOn(MovableInterface movable) {

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
     * Step on a a field
     * <p>
     * When a player wants to step on this field
     *
     * @param player    player
     * @param direction direction player is moving
     */
    @Override
    public void stepOn(PlayerInterface player, Direction direction) {

    }

    /**
     * Shoot a projectile at this block
     *
     * @param projectile projectile
     */
    @Override
    public void shootAt(Projectile projectile) {

    }
}
