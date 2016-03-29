package iitema.gypsypokemon.model;

import com.sun.org.apache.regexp.internal.RE;
import com.sun.webkit.graphics.Ref;
import iitema.gypsypokemon.Game;
import iitema.gypsypokemon.Reflector;

public class Player implements PlayerInterface{

    private FieldInterface field;
    private ItemInterface item;
    private Direction dir;
    private Game game;

    public Player(Game game, FieldInterface field){
        Reflector.start();

        this.field = field;
        this.dir = Direction.RIGHT;
        this.game = game;

        Reflector.end();
    }

    /**
     * Move player to a field
     *
     * @param field direction to move player
     */
    @java.lang.Override
    public void move(FieldInterface field) {
        Reflector.start();

        this.field.stepOff();
        this.field = field;

        Reflector.end();
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
        Reflector.start();

        if(Reflector.ask("Irányba néz az Ezredes?")) {
            this.field.getNeighbor(dir).stepOn(dir, this);
        } else {
            this.dir = dir;
        }

        Reflector.end();
    }

    /**
     * Try to pickup an item from the field in front of the player if hands are empty, or
     * Try to put down an item on the field in front of the player if hands are full.
     */
    @java.lang.Override
    public void action() {
        Reflector.start();

        if(!Reflector.ask("Van a játékosnál tárgy?")) {
            ItemInterface candidateItem = this.field.getNeighbor(this.dir).getItem(this.dir);

            if(Reflector.ask("Volt tárgy a mezőn?")) {
            //if(candidateItem != null && candidateItem.pickUp()) {
                candidateItem = Reflector.askType();
                if (candidateItem.pickUp()) {
                    this.field.getNeighbor(this.dir).removeItem(this.dir);
                    this.item = candidateItem;
                }
            }
        } else {
            boolean result = this.field.getNeighbor(this.dir).placeOn(this.dir, this.item);
            if(result) {
                this.item = null;
            }
        }

        Reflector.end();
    }

    /**
     * Shoots in the direction the player is facing
     *
     * @param color color of the projectile
     */
    @java.lang.Override
    public void shoot(Color color) {
        Reflector.start();

        FieldInterface f;

        do {
            f = this.field.getNeighbor(this.dir);
        } while (!f.shootAt(color, this.dir));

        Reflector.end();
    }

    /**
     * Kills the player
     */
    @java.lang.Override
    public void kill() {
        Reflector.start();

        this.game.endGame();

        Reflector.end();
    }
}
