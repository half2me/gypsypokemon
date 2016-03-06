package iitema.gypsypokemon.model;

public class SpecialWall extends Wall {
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

    @Override
    public void shootAt(Projectile projectile) {
        super.shootAt(projectile);
    }

    /**
     * Teleport player to this SpecialWall
     *
     * @param palyer player
     */
    public void teleportTo(PlayerInterface palyer, PortalColor source){

    }
}
