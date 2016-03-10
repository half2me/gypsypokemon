package iitema.gypsypokemon.elements.blocks;

import iitema.gypsypokemon.elements.Color;
import iitema.gypsypokemon.elements.Direction;

public class Player implements PlayerInterface{
    /**
     * Move player to a field
     *
     * @param field direction to move player
     */
    @java.lang.Override
    public void move(FieldInterface field) {

    }

    /**
     * Turn or move in a direction
     * If the player is facing in a different direction, this will turn him around
     * If the player is facing in the same direction, the player will move one block
     *
     * @param dir direction
     */
    @java.lang.Override
    public void step(Direction dir) {

    }

    /**
     * Try to pickup an item from the field in front of the player if hands are empty, or
     * Try to put down an item on the field in front of the player if hands are full.
     */
    @java.lang.Override
    public void action() {

    }

    /**
     * Shoots in the direction the player is facing
     *
     * @param color color of the projectile
     */
    @java.lang.Override
    public void shoot(Color color) {

    }

    /**
     * Kills the player
     */
    @java.lang.Override
    public void kill() {

    }
}
