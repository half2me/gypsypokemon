package iitema.gypsypokemon.model;

import iitema.gypsypokemon.Game;
import iitema.gypsypokemon.Log;

public class Player implements PlayerInterface{
    private static float WEIGHT = 2.0f;

    protected FieldInterface field;
    private ItemInterface item;
    private Direction dir;
    private Game game;
    private int id;

    public Player(Game game, FieldInterface field, int id){
        this.field = field;
        this.dir = Direction.RIGHT;
        this.game = game;
        this.id = id;
    }

    /**
     * Move player to a field
     *
     * @param field direction to move player
     */
    @java.lang.Override
    public void move(FieldInterface field) {
        this.field.stepOff(this);
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
            Log.println("Player" + id + " turned " + dir.toString());
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
                Log.print("Player" + id);
                if(item.pickUp()) {
                    this.item = item;
                    this.field.getNeighbor(this.dir).removeItem(this.dir);
                }
            } else { Log.println("Player" + id + " picked up nothing"); }
        } else {
            Log.print("Player" + id);
            boolean result = this.field.getNeighbor(this.dir).placeOn(this.dir, this.item);
            if(result) {
                this.item = null;
            } else { Log.println(" couldn't put down Box"); }
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
        Log.println("Player" + id + " shot " + color.toString() + " " + dir.toString());
        do {
            field = field.getNeighbor(this.dir);
        } while (!field.shootAt(color, this.dir));
    }

    /**
     * Kills the player
     */
    @java.lang.Override
    public void kill() {
        Log.println("Player" + id + " killed");
        game.deletePlayer(this);
    }

    public int getId() {return id; }

    public float getWeight() {
        return WEIGHT;
    }
}
