package iitema.gypsypokemon.model;

public class Player implements PlayerInterface{
    private Direction lookDir;
    private MovableInterface heldItem = null;
    private int numZpm = 0;

    /**
     * Move player in a direction
     *
     * @param direction direction to move player
     */
    @Override
    public void move(Direction direction) {

    }

    /**
     * Change position of the player to a field specified
     *
     * @param field field to place player on
     */
    @Override
    public void changePostition(FieldInterface field) {

    }

    @Override
    public void shoot(Direction direction, PortalColor pColor) {

    }

    @Override
    public void collect(CollectibleInterface item) {

    }

    @Override
    public void kill() {

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

    @Override
    public MovableInterface pickUp() {
        return null;
    }
}
