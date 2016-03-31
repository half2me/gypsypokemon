package iitema.gypsypokemon.model;

import iitema.gypsypokemon.Game;

public class Player implements PlayerInterface{

    private FieldInterface field;
    private ItemInterface item;
    private Direction dir;
    private Game game;

    public Player(Game game, FieldInterface field){
        this.field = field;
        this.dir = Direction.RIGHT;
        this.game = game;
    }

    /**
     * Move player to a field
     *
     * @param field direction to move player
     */
    @java.lang.Override
    public void move(FieldInterface field) {
        this.field.stepOff();
        this.field = field;
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
        if(this.dir == dir) {
            this.field.getNeighbor(dir).stepOn(dir, this);
        } else {
            this.dir = dir;
        }
    }

    /**
     * Try to pickup an item from the field in front of the player if hands are empty, or
     * Try to put down an item on the field in front of the player if hands are full.
     */
    @java.lang.Override
    public void action() {
        if(this.item == null) {
            ItemInterface item = this.field.getNeighbor(this.dir).getItem(this.dir);
            if(item != null) {
                if(item.pickUp()) {
                    this.item = item;
                    this.field.getNeighbor(this.dir).removeItem(this.dir);
                }
            }
        } else {
            boolean result = this.field.getNeighbor(this.dir).placeOn(this.dir, this.item);
            if(result) {
                this.item = null;
            }
        }
    }

    /**
     * Shoots in the direction the player is facing
     *
     * @param color color of the projectile
     */
    @java.lang.Override
    public void shoot(Color color) {
        FieldInterface field = this.field;
        do {
            field = field.getNeighbor(this.dir);
        } while (!field.shootAt(color, this.dir));
    }

    /**
     * Kills the player
     */
    @java.lang.Override
    public void kill() {
        this.game.endGame();
    }
}
