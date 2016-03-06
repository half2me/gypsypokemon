package iitema.gypsypokemon.model;

public class Zpm implements CollectibleInterface {

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
