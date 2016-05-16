package iitema.gypsypokemon.model;

import iitema.gypsypokemon.Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Replicator extends Player {

    private volatile boolean stop;
    private Thread aiThread = new Thread(){

        /**
         * Ai of the replicator
         */
        public void run() {
            Random rand = new Random();
            Direction prevDir = Direction.RIGHT;
            FieldInterface prevField = field.getNeighbor(Direction.LEFT);
            try {
                while (!stop) {
                    sleep(800);
                    List<Direction> chosables = new ArrayList<Direction>(Arrays.asList(Direction.all()));
                    if (prevField == field) {
                        prevDir = prevDir.getOpposite();
                    }
                    chosables.remove(prevDir.getOpposite());
                    prevDir = chosables.get(rand.nextInt(3));
                    prevField = field;
                    if (dir != prevDir) {
                        step(prevDir);
                    }
                    step(prevDir);
                }
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    };

    public Replicator(Game game, FieldInterface field, int id) {
        super(game, field, id);
    }

    /**
     * Starts the replicators ai thread
     */
    public void start(){
        stop = false;
        aiThread.start();
    }

    /**
     * Stops the replicators ai thread
     */
    public void stop() {
        stop = true;
    }

    /**
     * Kills the replicator. Exchanges the field it is on to a Ground if dies in an Abyss.
     */
    public void kill() {
        this.stop = true;

        Ground g = new Ground();

        FieldInterface left =  field.getNeighbor(Direction.LEFT);
        FieldInterface right =  field.getNeighbor(Direction.RIGHT);
        FieldInterface up =  field.getNeighbor(Direction.UP);
        FieldInterface down =  field.getNeighbor(Direction.DOWN);

        if (left != null) {
            g.setNeighbor(Direction.LEFT, left);
            left.setNeighbor(Direction.RIGHT, g);
        }

        if (right != null) {
            g.setNeighbor(Direction.RIGHT, right);
            right.setNeighbor(Direction.LEFT, g);
        }

        if (up != null) {
            g.setNeighbor(Direction.UP, up);
            up.setNeighbor(Direction.DOWN, g);
        }

        if (down != null) {
            g.setNeighbor(Direction.DOWN, down);
            down.setNeighbor(Direction.UP, g);
        }

        super.kill();
    }

    /**
     * Return the name of the sprite
     *
     * @return name of the sprite
     */
    @Override
    public String sprite() {
        return "replicator-" + this.dir.toString().toLowerCase();
    }
}
