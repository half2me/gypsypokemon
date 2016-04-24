package iitema.gypsypokemon.model;

import iitema.gypsypokemon.Game;

public class Replicator extends Player {

    public Replicator(Game game, FieldInterface field, int id) {
        super(game, field, id);
    }

    public void start(){

    }

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
