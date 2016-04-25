package iitema.gypsypokemon.model;

import iitema.gypsypokemon.Game;

import java.util.Random;

public class Replicator extends Player {

    private volatile boolean stop;
    private Thread aiThread = new Thread(){

        /**
         * Ai of the replicator
         */
        public void run() {
            Random rand = new Random();
            try {
                while (!stop) {
                    sleep(1000);
                    switch (rand.nextInt(3)) {
                        case 0:
                            if (dir != Direction.LEFT) {
                                step(Direction.LEFT);
                            }
                            step(Direction.LEFT);
                            break;
                        case 1:
                            if (dir != Direction.RIGHT) {
                                step(Direction.RIGHT);
                            }
                            step(Direction.RIGHT);
                            break;
                        case 2:
                            if (dir != Direction.UP) {
                                step(Direction.UP);
                            }
                            step(Direction.UP);
                            break;
                        case 3:
                            if (dir != Direction.DOWN) {
                                step(Direction.DOWN);
                            }
                            step(Direction.DOWN);
                            break;
                    }
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
}
